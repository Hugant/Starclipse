package starclipse.common;

import java.math.BigDecimal;

/**
 * The class <b>Subject</b> creates the subject with its type, quantity and maximum value.
 * <p>
 * You can create a subject which will have only the value, value and type, 
 * value and type and maximum value.
 * <pre><code> Subject a = new Subject("100V");
 * Subject b = new Subject("gold", "10B");
 * Subject c = new Subject("iron", "10J", "100BaM");
 * </pre></code>
 * <p>
 * You can make arithmetic operations on subjects, but on the condition that
 * have the same types.
 * <pre><code> Subject a = new Subject("tree", "10");
 * Subject b = new Subject("tree", "100");
 * a.add(b);// a = 110
 * b.minus(a);// b = 90
 * <br>
 * 
 * @author Hugant MD
 */
public class Subject {
	public final static String RESIDENTS = "residents";
	private LimitlessNumber value = null;
	private LimitlessNumber maxValue = null;
	private String type = null;
	
	
	/**
	* Create a <b>Subject</b> which have only value.
	* If value less than zero, will be generated 
	* an IllegalArgumentException.
	* 
	* @throws IllegalArgumentException
	* @param value is the amount of a subject
	*/
	public Subject(String value) {
		if (new LimitlessNumber(value).getPrefix().doubleValue() < 0) {
			throw new IllegalArgumentException("The amount of material cannot be less than zero");
		} else {
			this.value = new LimitlessNumber(value);
		}
	}
	
	/**
	* Create a <b>Subject</b> which have type and value.
	* If value less than zero, will be generated 
	* an IllegalArgumentException.
	* 
	* @throws IllegalArgumentException
	* @param type is the type of a subject
	* @param value is the amount of a subject
	*/
	public Subject(String type, String value) {
		if (new LimitlessNumber(value).getPrefix().doubleValue() < 0) {
			throw new IllegalArgumentException("The amount of material cannot be less than zero");
		} else {
			this.value = new LimitlessNumber(value);
		}
		
		this.type = type == null ? type : type.toLowerCase();
	}
	
	/**
	* Create a <b>Subject</b> which have type, value and maximum value.
	* If value or maxValue less than zero, will be generated 
	* an IllegalArgumentException.
	* 
	* @throws IllegalArgumentException
	* @param type is the type of a subject
	* @param value is the amount of a subject
	* @param maxValue is the maximum amount of a subject
	*/
	public Subject(String type, String value, String maxValue) {
		if (new LimitlessNumber(value).getPrefix().doubleValue() < 0) {
			throw new IllegalArgumentException("The amount of material cannot be less than zero");
		} else {
			this.value = new LimitlessNumber(value);
		}
		
		if (new LimitlessNumber(maxValue).getPrefix().doubleValue() < 0) {
			throw new IllegalArgumentException("The maximum amount of material cannot be less than zero");
		} else {
			this.maxValue = new LimitlessNumber(maxValue);
		}
		
		this.type = type == null ? type : type.toLowerCase();
	}

	/**
	 * Adds a <b>Subject</b> to the <b>Subject</b>.
	 * If the have a different type will generate
	 * an ArithmeticException.
	 * If the value exceeds the maximum value, will generate
	 * an ArithmeticException.
	 * 
	 * @throws ArithmeticException
	 * @param subject is a Subject which you want to add
	 */
	public void add(Subject subject) {
		if (subject.type == null || this.type == null) {
			this.value.add(subject.value);
		} else if (this.type.equals(subject.type)) {
			this.value.add(subject.value);
		} else {
			throw new ArithmeticException("Arithmetic operations can only be done with the same material");
		}
		
		if (this.maxValue != null && this.value.compareTo(this.maxValue) == 1) {
			this.value.minus(subject.value);
			throw new ArithmeticException("Out of bounds the maximum value");
		}
	}
	
	/**
	 * Take a <b>Subject</b> to the <b>Subject</b>.
	 * If the have a different type will generate
	 * an ArithmeticException.
	 * If the value less than the minimal value, will generate
	 * an ArithmeticException.
	 * 
	 * @throws ArithmeticException
	 * @param subject is a Subject which you want to take
	 */
	public void minus(Subject subject) {
		if (subject.type == null || this.type == null) {
			this.value.minus(subject.value);
		} else if (this.type.equals(subject.type)) {
			this.value.minus(subject.value);
		} else {
			throw new ArithmeticException("Arithmetic operations can only be done with the same material");
		}
		
		if (this.value.compareTo("0") == -1) {
			this.value.add(subject.value);
			throw new ArithmeticException("Out of bounds the minimum value");
		}

	}
	
	/**
	 * Return the string in the form <b>LimitlessNumber</b> rounded down to the nearest tenth.
	 * <br>
	 * <pre><code> new Subject("145T").getNumber();// "145T"
	 *  new Subject("1.001V").getNumber();// "1V"
	 *  new Subject("1.10Z").getNumber();// "1.1Z"
	 *  new Subject("1.1234J").getNumber();// "1.12J"
	 * </pre><code>
	 * @return string in the form <b>LimitlessNumber</b>
	 */
	public String getNumber() {
		return value.getPrefix().setScale(2, BigDecimal.ROUND_DOWN).toString().
				replaceAll("(\\.00)|(0$)", "") + value.getPostfix();
	}
	
	
	/**
	 * Adds the value to the maximum value of this <b>Subject</b>.
	 * @param subject is a string in the form <b>LimitlessNumber</b>
	 */
	public void addToMaxValue(String subject) {
		this.addToMaxValue(new Subject(subject));
	}
	
	/**
	 * Adds the Subject to the maximum value of this <b>Subject</b>.
	 * @param subject is a <b>Subject</b>
	 */
	public void addToMaxValue(Subject subject) {
		this.maxValue.add(subject.value);
	}
	
	
	/**
	 * Set the maximum value.
	 * @param subject is a string in the form <b>LimitlessNumber</b>
	 */
	public void setMaxValue(String subject) {
		this.setMaxValue(new Subject(subject));
	}
	
	/**
	 * Set the maximum value.
	 * @param subject is a <b>Subject</b>
	 */
	public void setMaxValue(Subject subject) {
		this.maxValue.setPrefix(subject.value.getPrefix());
		this.maxValue.setPostfix(subject.value.getPostfix());
	}
	
	
	/**
	 * Return the string in the form <b>LimitlessNumber</b>.
	 * <br>
	 * <pre><code> new Subject("gold", "145T", "1J").getNumber();// "1J"
	 * </pre><code>
	 * @return string in the form <b>LimitlessNumber</b>
	 */
	public String getMaxValue() {
		return maxValue.getPrefix() + maxValue.getPostfix();
	}
	
	
	/**
	 * Return the string the type of this object.
	 * @return string the type of this object
	 */
	public String getType() {
		return this.type == null ? "no type" : this.type;
	}
	
	/**
	 * Compares <b>Subject</b>'s by name.
	 */
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Subject) {
			if (this.type.equals(((Subject) o).type)) 
				return true;
		}

		return false;
	}
	
	/**
	 * Return the string in the form: type + " " + number.
	 * <pre><code> new Subject("oxygen", "10B").toString();// oxygen 10B
	 * </pre></code>
	 */
	@Override
	public String toString() {
		return (this.type == null ? "no type" : this.type) + " " + this.getNumber();
	}
}
