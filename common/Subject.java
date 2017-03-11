package starclipse.common;

import java.math.BigDecimal;

/**
 * The class Subject creates the subject with its type, quantity and maximum value.
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
	private LimitlessNumber value;
	private LimitlessNumber maxValue = new LimitlessNumber("0");
	private String type = "";
	
	
	/**
	* Create a Subject which have only value.
	* @param value is the amount of a subject
	*/
	public Subject(String value) {
		this.value = new LimitlessNumber(value);
	}
	
	/**
	* Create a Subject which have type and value
	* @param type is the type of a subject
	* @param value is the amount of a subject
	*/
	public Subject(String type, String value) {
		this.value = new LimitlessNumber(value);
		this.type = type.toLowerCase();
	}
	
	/**
	* Create a Subject which have type, value and maximum value.
	* @param type is the type of a subject
	* @param value is the amount of a subject
	* @param maxValue is the maximum amount of a subject
	*/
	public Subject(String type, String value, String maxValue) {
		this.value = new LimitlessNumber(value);
		this.maxValue = new LimitlessNumber(maxValue);
		this.type = type.toLowerCase();
	}

	/**
	 * Adds a Subject to the Subject.
	 * If the have a different type then pop up a ArithmeticException.
	 * 
	 * @throws ArithmeticException
	 * @param subject is a Subject which you want to add
	 */
	public void add(Subject subject) {
		if(this.type.equals(subject.type)) {
			this.value.add(subject.value);
			
			if(this.maxValue.compareTo("0") == 1 && this.value.compareTo(this.maxValue) == 1) {
				this.value = this.maxValue;
			}
		} else {
			throw new ArithmeticException("Arithmetic operations can only be done with the same material");
		}
	}
	
	/**
	 * Take a Subject to the Subject.
	 * If the have a different type then pop up a ArithmeticException.
	 * 
	 * @throws ArithmeticException
	 * @param subject is a Subject which you want to take
	 */
	public void minus(Subject subject) {
		if(this.type.equals(subject.type)) {
			this.value.minus(subject.value);
			
			if(this.value.compareTo("0") == -1) {
				this.value = new LimitlessNumber("0");
			}
		} else {
			throw new ArithmeticException("Arithmetic operations can only be done with the same material");
		}
	}
	
	/**
	 * Return the string in the form LimitlessNumber rounded down to the nearest tenth.
	 * <br>
	 * <pre><code> new Subject("145T").getNumber();// "145T"
	 *  new Subject("1.001V").getNumber();// "1V"
	 *  new Subject("1.01Z").getNumber();// "1Z"
	 *  new Subject("1.1234J").getNumber();// "1.12J"
	 * </pre><code>
	 * @return string in the form LimitlessNumber
	 */
	public String getNumber() {
		if(value.getPrefix().toString().contains(".00") || value.getPrefix().toString().contains(".0")) {
			return value.getPrefix().setScale(0, BigDecimal.ROUND_DOWN) + value.getPostfix();
		}
		
		return value.getPrefix().setScale(2, BigDecimal.ROUND_DOWN) + value.getPostfix();
	}
	
	
	/**
	 * Adds the value to the maximum value of this Subject
	 * @param subject is a string in the form LimitlessNumber
	 */
	public void addToMaxValue(String subject) {
		this.addToMaxValue(new Subject(subject));
	}
	
	/**
	 * Adds the Subject to the maximum value of this Subject
	 * @param subject is a Subject
	 */
	public void addToMaxValue(Subject subject) {
		this.maxValue.add(subject.value);
	}
	
	
	/**
	 * Set the maximum value.
	 * @param subject is a string in the form LimitlessNumber
	 */
	public void setMaxValue(String subject) {
		this.setMaxValue(new Subject(subject));
	}
	
	/**
	 * Set the maximum value.
	 * @param subject is a Subject
	 */
	public void setMaxValue(Subject subject) {
		this.maxValue.setPrefix(subject.value.getPrefix());
		this.maxValue.setPostfix(subject.value.getPostfix());
	}
	
	
	/**
	 * Return the string in the form LimitlessNumber.
	 * <br>
	 * <pre><code> new Subject("gold", "145T", "1J").getNumber();// "1J"
	 * </pre><code>
	 * @return string in the form LimitlessNumber
	 */
	public String getMaxValue() {
		return maxValue.getPrefix() + maxValue.getPostfix();
	}
	
	
	/**
	 * Return the string the type of this object.
	 * @return string the type of this object
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Compares Subjects by name.
	 */
	@Override
	public boolean equals(Object o) {
		if(o != null && o instanceof Subject) {
			if(this.type.equals(((Subject) o).type)) 
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
		return this.type + " " + this.getNumber();
	}
}
