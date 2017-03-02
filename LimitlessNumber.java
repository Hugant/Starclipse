package Starclipse;

import java.util.Arrays;
import java.math.BigDecimal;

public class LimitlessNumber {
	private static final String[] POSTFIX_MAS = new String[]{ "", "K", "M", "B", "T", "V", "Z", "J",
													         "BaM", "BaB", "BaT", "BaV", "BaZ", "BaJ",
													         "GaM", "GaB", "GaT", "GaV", "GaZ", "GaJ" };
//																							GaJ = 10e+57
	private BigDecimal prefix = new BigDecimal("0");// number
	private String postfix = "";// system

	
	public LimitlessNumber(String number) {
		if(!number.equals("")) {
			for(int i = POSTFIX_MAS.length - 1; i > 0; i--) {
				if(number.contains(POSTFIX_MAS[i])) {
					this.prefix = 
							BigDecimal.valueOf(Double.parseDouble(number.substring(0, number.indexOf(POSTFIX_MAS[i]))));
					this.postfix = number.substring(number.indexOf(POSTFIX_MAS[i]), number.length());
					break;
				}
			}
			
			if(this.postfix.equals("")) {
				this.prefix = BigDecimal.valueOf(Double.parseDouble(number));
			}
			
			this.checkNumber();
		}
	}
	
	
	
	public void add(String number) {
		this.add(new LimitlessNumber(number));
	}
	
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
	
	
	
	public void minus(String number) {
		this.minus(new LimitlessNumber(number));
	}
	
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
	
	
	
	public int compareTo(String number) {
		return this.compareTo(new LimitlessNumber(number));
	}
	
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
	
	public BigDecimal getPrefix() {
		return this.prefix;	
	}
	
	public String getPostfix() {
		return this.postfix;
	}
	
	public void setPrefix(BigDecimal prefix) {
		this.prefix = prefix;
	}
	
	public void setPostfix(String postfix) {
		this.postfix = postfix;
	}
}
