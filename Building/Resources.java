package starclipse.building;

import java.util.ArrayList;

import starclipse.common.LimitlessNumber;
import starclipse.common.Subject;

/**
 * Allows you to store an array of Subjects and to work with them.
 * 
 * @author Hugant MD
 *
 */
public class Resources {
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	
	/**
	 * Create <b>Resources</b> in which all <b>Subjects</b> will have
	 * a maximal size volume. If the <b>Subjects</b> are repeat, it will be
	 * added to the previous current.
	 * 
	 * <p>
	 * <strong>Example: </strong>
	 * <pre><code> Resources a = new Resources(new LimitlessNumber("100"), "iron",
	 * 	"tree", "gold");// maxValue of iron = 100, tree = 100, gold = 100
	 * Resources a = new Resources(new LimitlessNumber("100"), "iron", "iron",
	 * 	"tree", "gold");// maxValue of iron = 200, tree = 100, gold = 100
	 * </code></pre>
	 * @param volume is a <b>LimitlessNumber</b> the future maximal size of each <b>Subject</b>.
	 * @param res is a array of string where each string is the type of <b>Subject</b>.
	 */
	public Resources(LimitlessNumber volume, String... res) {
		for(String i : res) {
			if(!subjects.contains(new Subject(i, "0"))) {
				subjects.add(new Subject(i, "0", volume.getPrefix() + volume.getPostfix()));
			} else {
				subjects.get(subjects.indexOf(new Subject(i, "0"))).addToMaxValue(volume.getPrefix() + volume.getPostfix());
			}
		}	
	}
	
	/**
	 * Create <b>Resources</b> in which you can specify the size of each <b>Subject</b>.
	 * If <b>Subject</a> will be repeated then will be generated an IllegalArgumentException.
	 * 
	 * <p>
	 * <strong>Example: </strong>
	 * <pre><code>Resources a = new Resources("iron", "100B"
	 *                            "gold", "100K"
	 *                            "water", "1M");
	 * //iron = 100B, gold = 100K, water = 1M
	 * 
	 * @throws IllegalArgumentException
	 * @param res
	 */
	public Resources(String... res) {
		if(res.length % 2 != 0) {
			throw new IllegalArgumentException("The number of array elements must be even");
		} else {
			for(int i = 0; i < res.length; i += 2) {
				if(subjects.contains(new Subject(res[i], "0"))) {
					subjects.clear();
					throw new IllegalArgumentException("There are two of the same item");
				} else {
					subjects.add(new Subject(res[i], res[i + 1]));
				}
			}
		}
	}
	
	
	/**
	 * Adds to the existing <b>Subject</b> other <b>Subject</b>.
	 * If the <b>Subject</b> does not exist, will be generated an 
	 * ArithmeticException.
	 * @param sub is a <b>Subject</b> which you want to add
	 */
	public void add(Subject sub) {
		if(subjects.contains(sub)) {
			subjects.get(subjects.indexOf(sub)).add(sub);;
		} else {
			throw new ArithmeticException("No such element exists");
		}
	}
	
	/**
	 * Takes away from the existing <b>Subject</b> other <b>Subject</b>.
	 * If the <b>Subject</b> does not exist, will be generated an 
	 * ArithmeticException.
	 * @param sub is a <b>Subject</b> which you want to take
	 */
	public void minus(Subject sub) {
		if(subjects.contains(sub)) {
			subjects.get(subjects.indexOf(sub)).minus(sub);
		} else {
			throw new ArithmeticException("No suck element exists");
		}
	}
	
	
	/**
	 * Return <b>Subject</b> with the type you specified.
	 * If the <b>Subject</b> does not exist, will be generated an
	 * ArithmeticException
	 * 
	 * @throws ArithmeticException
	 * @param type is a type <b>Subject</b>
	 * @return Subject with the type you specified
	 */
	public Subject get(String type) {
		if(subjects.contains(new Subject(type, "0"))) {
			return subjects.get(subjects.indexOf(new Subject(type, "0")));
		} else {
			throw new ArithmeticException("No suck element exists");
		}
	}
}
