package starclipse.common;

import java.util.Arrays;
import java.math.BigDecimal;

/**
 * The class LimitlessNumber allows you to translate number in a more convenient
 * form for the user.
 *
 * <p>
 * <strong>What number is converted: </strong>
 * <br>
 * <pre>  1000 = 1K;
 *  1000K = 1M;// Million
 *  1000M = 1B;// Billion
 *  1000B = 1T;// Trillion
 *  1000T = 1V;// Villion
 *  1000V = 1Z;// Zillion
 *  1000Z = 1J;// Jillion
 *  1000J = 1BaM;// BaMillion
 *  1000BaM = 1BaB;// BaBillion
 *  ...
 *  1000GaZ = 1GaJ;// GaJillion
 * <br>
 * @author Hugant MD
 */
public class LimitlessNumber {
	/**
	* <b>Contains the names of large numbers: <br></b>
	* K = 1000, <br>
	* M - Million = 100K, <br>
	* B - Billion = 100M, <br>
	* T - Trillion = 100B, <br>
	* V - Villion = 100T, <br>
	* Z - Zillion = 100V, <br>
	* J - Jillion = 100Z, <br>
	* BaM - BaMillion = 100J, <br>
	* BaB - BaBillion = 100BaM, <br>
	* BaT - BaTrillion = 100BaB, <br>
	* BaV - BaVillion = 100BaT, <br>
	* BaZ - BaZillion = 100BaV, <br>
	* BaJ - BaJillion = 100BaZ, <br>
	* GaM - GaMillion = 100BaJ, <br>
	* GaB - GaBillion = 100GaM, <br>
	* GaT - GaTrillion = 100GaB, <br>
	* GaV - GaVillion = 100GaT, <br>
	* GaZ - GaZillion = 100GaV, <br>
	* GaJ - GaJillion = 100GaZ;
	*/
	private static final String[] POSTFIX_MAS = new String[]{ "", "K", "M", "B", "T", "V", "Z", "J",
													         "BaM", "BaB", "BaT", "BaV", "BaZ", "BaJ",
													         "GaM", "GaB", "GaT", "GaV", "GaZ", "GaJ" };
	private BigDecimal prefix = new BigDecimal("0");
	private String postfix = "";

	/**
	* Create number type of LimitlessNumber and convert it to the form
	* prefix + postfix. If number has an irregular form, will generate
	* an IllegalArgumentException.
	*
	* <p>
	* <strong>Example:</strong>
	* <pre><code>  LimitlessNumber num = new LimitlessNumber("1000");// 1K
	*  LimitlessNumber num = new LimitlessNumber("45M");// 45M
	*  LimitlessNumber num = new LimitlessNumber("1502M");// 1.502B
	*  LimitlessNumber num = new LimitlessNumber("0.53B");// 530M
	* <br>
	* 
	* @param number the string which will be translated
	*/
	public LimitlessNumber(String number) {
		if(number != null && number.matches("^(\\d+|\\d+[.]\\d+)([KMBTVZJ]|Ba[KMBTVZJ]|Ga[KMBTVZJ])?$")) {
			for(int i = POSTFIX_MAS.length - 1; i > 0; i--) {
				if(number.contains(POSTFIX_MAS[i])) {
					this.prefix = 
							BigDecimal.valueOf(Double.parseDouble(number.substring(0, number.indexOf(POSTFIX_MAS[i]))));
					this.postfix = number.substring(number.indexOf(POSTFIX_MAS[i]), number.length());
					break;
				}
			}
			
			this.prefix = BigDecimal.valueOf(Double.parseDouble(number));
			this.checkNumber();
			
		} else {
			throw new IllegalArgumentException("Incorrect number");
		}
	}
	
	
	/**
	* Add number to this LimitlessNumber.
	* 
	* @param number the string, which you want to add.
	*/
	public void add(String number) {
		this.add(new LimitlessNumber(number));
	}
	
	
	/**
	* Add number to this LimitlessNumber.
	* 
	* @param number the LimitlessNumber, which you want to add.
	*/
	public void add(LimitlessNumber number) {
		final int fPostfix = Arrays.asList(POSTFIX_MAS).indexOf(this.postfix);
		final int sPostfix = Arrays.asList(POSTFIX_MAS).indexOf(number.postfix);
		
		if(fPostfix > sPostfix) {
			this.prefix = number.transferTo(this.postfix).add(this.prefix);
		} else if(fPostfix < sPostfix) {
			this.prefix = this.transferTo(number.postfix).add(number.prefix);
			this.postfix = number.postfix;
		} else {
			this.prefix = this.prefix.add(number.prefix);
		}
		
		this.checkNumber();
	}
	
	
	/**
	* Takes the number from this LimitlessNumber.
	* 
	* @param number the string, which you want take.
	*/
	public void minus(String number) {
		this.minus(new LimitlessNumber(number));
	}
	
	
	/**
	* Takes the number from this LimitlessNumber.
	* 
	* @param number the LimitlessNumber, which you want take.
	*/
	public void minus(LimitlessNumber number) {
		final int fPostfix = Arrays.asList(POSTFIX_MAS).indexOf(this.postfix);
		final int sPostfix = Arrays.asList(POSTFIX_MAS).indexOf(number.postfix);
		
		if(fPostfix > sPostfix) {
			this.prefix = this.prefix.subtract(number.transferTo(this.postfix));
		} else if(fPostfix < sPostfix) {
			this.prefix = BigDecimal.valueOf(0);
			this.postfix = "";
			//throw new ArithmeticException("You cannot subtract more from lot!"); 
		} else {
			this.prefix = this.prefix.subtract(number.prefix);
		}

		this.checkNumber();
	}
	

	
	private BigDecimal transferTo(String system) {
		for(int i = 0; i < POSTFIX_MAS.length; i++) {
			if(POSTFIX_MAS[i].contains(system)) {
				final int fPostfix = Arrays.asList(POSTFIX_MAS).indexOf(this.postfix);
				final int sPostfix = i;
				if(fPostfix > sPostfix) {
					this.prefix = this.prefix.multiply(BigDecimal.valueOf(Math.pow(10, (fPostfix - sPostfix) * 3)));
					this.postfix = system;
					break;
				} else if(fPostfix < sPostfix) {
					this.prefix = this.prefix.divide(BigDecimal.valueOf(Math.pow(10, (sPostfix - fPostfix) * 3)));
					this.postfix = system;
					break;
				} else {
					break;
				}
			}
			
			if(i == POSTFIX_MAS.length - 1 ) {
				throw new IllegalArgumentException("Such system does not exist!"); 
			}
		}
		
		return this.prefix;
	}
	
	
	/**
	* Compare this LimitlessNumber to the string.
	* 
	* @param number the string to compare with.
	*/
	public int compareTo(String number) {
		return this.compareTo(new LimitlessNumber(number));
	}
	
	
	/**
	* Compare this LimitlessNumber to the LimitlessNumber.
	* 
	* @param number the LimitlessNumber to compare with.
	*/
	public int compareTo(LimitlessNumber number) {
		String numberPost = number.postfix;
		number.transferTo(this.postfix);
		if(this.prefix.compareTo(number.prefix) == -1){
			number.transferTo(numberPost);
			return -1;
		} else if(this.prefix.compareTo(number.prefix) == 1) {
			number.transferTo(numberPost);
			return 1;
		}
		return 0;
	}
	

	private void checkNumber() {
		if(this.prefix.compareTo(BigDecimal.valueOf(0)) == 1) {
			// number < 1, but number > 0
			while(this.prefix.compareTo(BigDecimal.valueOf(1)) == -1) {	
				if(!this.postfix.equals("")) {
					this.prefix = this.prefix.multiply(BigDecimal.valueOf(1000));
					this.postfix = POSTFIX_MAS[Arrays.asList(POSTFIX_MAS).indexOf(this.postfix) - 1];
				}
			}
	
			//number >= 1000
			while(this.prefix.compareTo(BigDecimal.valueOf(1000)) != -1) {
				if(!this.postfix.equals(POSTFIX_MAS[POSTFIX_MAS.length - 1])) {
					this.prefix = this.prefix.divide(BigDecimal.valueOf(1000));
					this.postfix = POSTFIX_MAS[Arrays.asList(POSTFIX_MAS).indexOf(this.postfix) + 1];
				}
			}
			
			if(this.prefix.compareTo(BigDecimal.valueOf(0)) == 1) {
				//remove extra zeros
				
				if(this.prefix.divide(this.prefix.setScale(0, BigDecimal.ROUND_DOWN)).compareTo(BigDecimal.valueOf(1)) == 0) {
					this.prefix = this.prefix.setScale(0, BigDecimal.ROUND_DOWN);
				}
			}
		} else {
			this.postfix = "";
		}
	}
	
	/**
	* Return the BigDecimal number, this prefix.
	* <br>
	* <br>
	* <strong>Example: </strong>
	* <pre><code> new LimitlessNumber("55B").getPrefix();// 55
	* </pre></code>
	*/
	public BigDecimal getPrefix() {
		return this.prefix;	
	}
	
	/**
	* Return the system of the number, this postfix.
	* <br>
	* <br>
	* <strong>Example: </strong>
	* <pre><code> new LimitlessNumber("324M").getPostfix();// M
	*/
	public String getPostfix() {
		return this.postfix;
	}
	
	/**
	* Set prefix to this LimitlessNumber.
	* <br>
	* <br>
	* <strong>Example: </strong>
	* <pre><code> new LimitlessNumber("23B").setPrefix(BigDecimal.valueOf(132));// 132B
	* <br>
	* 
	* @param prefix the number, which replaced this prefix.
	*/
	public void setPrefix(BigDecimal prefix) {
		this.prefix = prefix;
	}
	
	/**
	* Set postfix to this LimitlessNumber.
	* <br>
	* <br>
	* <strong>Example: </strong>
	* <pre><code> new LimitlessNumber("43B").setPostfix("J");// 43J
	* <br>
	* 
	* @param postfix the string, which replaced this postfix.
	*/	
	public void setPostfix(String postfix) {
		this.postfix = postfix;
	}
	
	/**
	 * Return string in the form prefix + postfix.
	 */
	@Override
	public String toString() {
		return this.prefix + this.postfix;
	}
}
