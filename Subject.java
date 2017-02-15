package Starclipse;

import java.math.BigDecimal;

public class Subject {
	private LimitlessNumber value;
	private LimitlessNumber maxValue;
	private String name = "";
	
	

	public Subject(String value) {
		this.value = new LimitlessNumber(value);
	}
	
	public Subject(String name, String value) {
		this.value = new LimitlessNumber(value);
		this.name = name.toLowerCase();
	}
	
	public Subject(String name, String value, String maxValue) {
		this.value = new LimitlessNumber(value);
		this.maxValue = new LimitlessNumber(maxValue);
		this.name = name.toLowerCase();
	}

	
	public void add(Subject subject) {
		if(this.name.equals(subject.name)) {
			this.value.add(subject.value);
		} else {
			throw new ArithmeticException("Arithmetic operations can only be done with the same material");
		}
		
		if(this.maxValue.compareTo("0") > 0 && this.value.compareTo(this.maxValue) == 1) {
			this.value = new LimitlessNumber();
		}
		
	}
	

	public void minus(Subject subject) {
		if(this.name.equals(subject.name)) {
			this.value.minus(subject.value);
		} else {
			throw new ArithmeticException("Arithmetic operations can only be done with the same material");
		}
	}
	
	
	public String getNumber() {
		if(value.getPrefix().scale() > 2) {
			if(value.getPrefix().toString().contains(".00")) {
				return value.getPrefix().setScale(0, BigDecimal.ROUND_DOWN) + " " + value.getPostfix();
			}
			return value.getPrefix().setScale(2, BigDecimal.ROUND_DOWN) + " " + value.getPostfix();
		}
		return value.getPrefix() + " " + value.getPostfix();
	}
	
	public void addToMaxValue(Subject subject) {
		this.maxValue.setPrefix(subject.value.getPrefix());
		this.maxValue.setPostfix(subject.value.getPostfix());
	}
	
	public void setMaxValue(Subject subject) {
		
	}
	
	public String getMaxValue() {
		return maxValue.getPrefix() + " " + maxValue.getPostfix();
	}
	
	public String getName() {
		return this.name;
	}
}
