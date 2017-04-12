package starclipse.common;

import java.util.Arrays;
import java.math.BigDecimal;

/**
 * The class <b>ScaleNumber</b> allows you to translate number in a more convenient
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
public class ScaleNumber {
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
	* CaM - CaMillion = 100BaJ, <br>
	* CaB - CaBillion = 100CaM, <br>
	* CaT - CaTrillion = 100CaB, <br>
	* CaV - CaVillion = 100CaT, <br>
	* CaZ - CaZillion = 100CaV, <br>
	* CaJ - CaJillion = 100CaZ; <br>
	* and more...
	*/
	private static final String[] POSTFIX_MAS = new String[]{ "", "K", "M", "B", "T", "V", "Z",   "J",
													         "BaM", "BaB", "BaT", "BaV", "BaZ", "BaJ",
													         "CaM", "CaB", "CaT", "CaV", "CaZ", "CaJ",
													         "DaM", "DaB", "DaT", "DaV", "DaZ", "DaJ",
													         "FaM", "FaB", "FaT", "FaV", "FaZ", "FaJ",
													         "GaM", "GaB", "GaT", "GaV", "GaZ", "GaJ",
													         "HaM", "HaB", "HaT", "HaV", "HaZ", "HaJ",
													         "JaM", "JaB", "JaT", "JaV", "JaZ", "JaJ",
													         "KaM", "KaB", "KaT", "KaV", "KaZ", "KaJ",
													         "LaM", "LaB", "LaT", "LaV", "LaZ", "LaJ",
													         "MaM", "MaB", "MaT", "MaV", "MaZ", "MaJ",
													         "NaM", "NaB", "NaT", "NaV", "NaZ", "NaJ",
													         "PaM", "PaB", "PaT", "PaV", "PaZ", "PaJ",
													         "RaM", "RaB", "RaT", "RaV", "RaZ", "RaJ",
													         "SaM", "SaB", "SaT", "SaV", "SaZ", "SaJ",
													         "TaM", "TaB", "TaT", "TaV", "TaZ", "TaJ",
													         "VaM", "VaB", "VaT", "VaV", "VaZ", "VaJ",
													         "ZaM", "ZaV", "ZaT", "ZaV", "ZaZ", "ZaJ"};
	private static final String PATTERN_PREFIX = getPrefixPattern();
	private static final String PATTERN_POSTFIX = getPostfixPattern();
	
	private BigDecimal prefix = new BigDecimal("0");
	private String postfix = "";

	/**
	* Create number type of <b>ScaleNumber</b> and convert it to the form
	* prefix + postfix. If number has an irregular form, will generate
	* an IllegalArgumentException.
	*
	* <p>
	* <strong>Example:</strong>
	* <pre><code>  ScaleNumber num = new ScaleNumber("1000");// 1K
	*  ScaleNumber num = new ScaleNumber("45M");// 45M
	*  ScaleNumber num = new ScaleNumber("1502M");// 1.502B
	*  ScaleNumber num = new ScaleNumber("0.53B");// 530M
	* <br>
	* 
	* @throws IllegalArgumentException
	* @param number the string which will be translated
	*/
	public ScaleNumber(String number) {
		if (number != null && number.matches("^-?(\\d+|\\d+[.]\\d+)(([" + PATTERN_PREFIX + "]a)"
				+ "?[" + PATTERN_POSTFIX + "])?$")) {
			for (int i = POSTFIX_MAS.length - 1; i > 0; i--) {
				if (number.contains(POSTFIX_MAS[i])) {
					this.prefix = 
							BigDecimal.valueOf(Double.parseDouble(number.substring(0, number.indexOf(POSTFIX_MAS[i]))));
					this.postfix = number.substring(number.indexOf(POSTFIX_MAS[i]));
					this.checkingValidity();
					return;
				}
			}
			
			this.prefix = BigDecimal.valueOf(Double.parseDouble(number));
			this.checkingValidity();
			
		} else {
			throw new IllegalArgumentException("Incorrect number");
		}
	}
	
	
	/**
	* Add <b>ScaleNumber</b> to this <b>ScaleNumber</b>.
	* 
	* @param number the string, which you want to add.
	*/
	public ScaleNumber add(String number) {
		return this.add(new ScaleNumber(number));
	}
	
	
	/**
	* Add <b>ScaleNumber</b> to this <b>ScaleNumber</b>.
	* 
	* @param number the <b>ScaleNumber</b>, which you want to add.
	*/
	public ScaleNumber add(ScaleNumber number) {
		this.prefix = number.transferTo(this.postfix).add(this.prefix);
		this.checkingValidity();
		return this;
	}
	
	
	/**
	* Takes the <b>ScaleNumber</b> from this <b>ScaleNumber</b>.
	* 
	* @param number the string, which you want take.
	*/
	public ScaleNumber minus(String number) {
		return this.minus(new ScaleNumber(number));
	}
	
	
	/**
	* Takes the <b>ScaleNumber</b> from this <b>ScaleNumber</b>.
	* 
	* @param number the <b>ScaleNumber</b>, which you want take.
	*/
	public ScaleNumber minus(ScaleNumber number) {
		this.prefix = this.prefix.subtract(number.transferTo(this.postfix));
		this.checkingValidity();
		return this;
	}
	
	
	/**
	 * Multiplies the <b>ScaleNumber</b> with another <b>ScaleNumber</b>.
	 * 
	 * @param number the String, which you want to multiply
	 */
	public ScaleNumber multiply(String number) {
		return this.multiply(new ScaleNumber(number));
	}
	
	
	/**
	 * Multiplies the the <b>ScaleNumber</b> with another the <b>ScaleNumber</b>.
	 * 
	 * @param number the <b>ScaleNumber</b>, which you want to multiply
	 */
	public ScaleNumber multiply(ScaleNumber number) {
		int thisPostfix = Arrays.asList(POSTFIX_MAS).indexOf(this.postfix);
		int numberPostfix = Arrays.asList(POSTFIX_MAS).indexOf(number.postfix);
		
		if (thisPostfix > numberPostfix) {
			this.prefix = this.prefix.multiply(number.transferTo(""));
		} else if (thisPostfix < numberPostfix) {
			this.prefix = number.prefix.multiply(this.transferTo(""));
			this.postfix = number.postfix;
		} else {
			this.prefix = this.prefix.multiply(number.transferTo(""));
		}

		this.checkingValidity();
		return this;
	}
	
	
	/**
	 * Divides a <b>ScaleNumber</b> by another <b>ScaleNumber</b>.
	 * 
	 * @param number the String, which you want to divide
	 */
	public ScaleNumber divide(String number) {
		return this.divide(new ScaleNumber(number));
	}
	
	/**
	 * Divides a <b>ScaleNumber</b> by another <b>ScaleNumber</b>.
	 * 
	 * @param number the <b>ScaleNumber</b>, which you want to divide
	 */
	public ScaleNumber divide(ScaleNumber number) {
		this.prefix = this.transferTo("").divide(number.transferTo(""));
		this.checkingValidity();
		return this;
	}
	
	private BigDecimal transferTo(String system) {
		// number * 10^(this.postfix - system) * 3
		this.prefix = this.prefix.multiply(
				BigDecimal.valueOf(Math.pow(10, (Arrays.asList(POSTFIX_MAS).indexOf(this.postfix) - 
						Arrays.asList(POSTFIX_MAS).indexOf(system)) * 3)));
		this.postfix = system;

		return this.prefix;
	}
	
	
	/**
	* Compare this <b>ScaleNumber</b> to the string.
	* 
	* @param number the string to compare with.
	*/
	public int compareTo(String number) {
		return this.compareTo(new ScaleNumber(number));
	}
	
	
	/**
	* Compare this <b>ScaleNumber</b> to the <b>ScaleNumber</b>.
	* 
	* @param number the <b>ScaleNumber</b> to compare with.
	*/
	public int compareTo(ScaleNumber number) {
		String numberPost = number.postfix;
		number.transferTo(this.postfix);
		if (this.prefix.compareTo(number.prefix) == -1){
			number.transferTo(numberPost);
			return -1;
		} else if(this.prefix.compareTo(number.prefix) == 1) {
			number.transferTo(numberPost);
			return 1;
		}
		return 0;
	}
	

	private void checkingValidity() {
		while (this.prefix.abs().compareTo(BigDecimal.valueOf(1)) == -1 && !this.postfix.equals("")) {
			this.prefix = this.prefix.multiply(BigDecimal.valueOf(1000));
			this.postfix = POSTFIX_MAS[Arrays.asList(POSTFIX_MAS).indexOf(this.postfix) - 1];
		}
		
		while (this.prefix.abs().compareTo(BigDecimal.valueOf(999)) == 1 && 
				!this.postfix.equals(POSTFIX_MAS[POSTFIX_MAS.length - 1])) {
			this.prefix = this.prefix.divide(BigDecimal.valueOf(1000));
			this.postfix = POSTFIX_MAS[Arrays.asList(POSTFIX_MAS).indexOf(this.postfix) + 1];
		}
	}
	
	/**
	* Return the BigDecimal number, this prefix.
	* <br>
	* <br>
	* <strong>Example: </strong>
	* <pre><code> new ScaleNumber("55B").getPrefix();// 55
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
	* <pre><code> new ScaleNumber("324M").getPostfix();// M
	*/
	public String getPostfix() {
		return this.postfix;
	}
	
	/**
	* Set prefix to this <b>ScaleNumber</b>.
	* <br>
	* <br>
	* <strong>Example: </strong>
	* <pre><code> new ScaleNumber("23B").setPrefix(BigDecimal.valueOf(132));// 132B
	* <br>
	* 
	* @param prefix the number, which replaced this prefix.
	*/
	public void setPrefix(BigDecimal prefix) {
		this.prefix = prefix;
	}
	
	/**
	* Set postfix to this <b>ScaleNumber</b>.
	* <br>
	* <br>
	* <strong>Example: </strong>
	* <pre><code> new ScaleNumber("43B").setPostfix("J");// 43J
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
