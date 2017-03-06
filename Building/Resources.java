package starclipse.building;

import java.util.ArrayList;

import starclipse.common.LimitlessNumber;
import starclipse.common.Subject;

public class Resources {
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	
	public Resources(LimitlessNumber volume, String... res) {
		for(String i : res) {
			if(!subjects.contains(new Subject(i, "0"))) {
				subjects.add(new Subject(i, "0", volume.getPrefix() + volume.getPostfix()));
			} else {
				subjects.get(subjects.indexOf(new Subject(i, "0"))).addToMaxValue(volume.getPrefix() + volume.getPostfix());
			}
		}	
	}
	
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
	
	public void add(Subject sub) {
		if(subjects.contains(sub)) {
			subjects.get(subjects.indexOf(sub)).add(sub);;
		} else {
			throw new ArithmeticException("No such element exists");
		}
	}
	
	public void minus(Subject sub) {
		if(subjects.contains(sub)) {
			subjects.get(subjects.indexOf(sub)).minus(sub);
		} else {
			throw new ArithmeticException("No suck element exists");
		}
	}
	
	public Subject get(String name) {
		if(subjects.contains(new Subject(name, "0"))) {
			return subjects.get(subjects.indexOf(new Subject(name, "0")));
		} else {
			throw new ArithmeticException("No suck element exists");
		}
	}
	
	public void get() {
		for(Subject i : subjects) {
			if(i.getName().equals("tree"))
				i.minus(new Subject("tree", "100B"));
			System.out.println(i.getName() + ": " + i.getNumber());
		}
	}
}
