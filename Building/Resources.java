package Starclipse.Building;

import Starclipse.Subject;
import Starclipse.LimitlessNumber;
import java.util.ArrayList;

public class Resources {
	private Subject tree = new Subject("tree", "0");
	private Subject iron = new Subject("iron", "0");
	private Subject gold = new Subject("gold", "0");
	private Subject energy = new Subject("energy", "0");
	private Subject water = new Subject("water", "0");
	private Subject oxygen = new Subject("oxygen", "0");
	private Subject coal = new Subject("coal", "0");
	private Subject stone = new Subject("stone", "0");
	private Subject food = new Subject("food", "0");
	private Subject money = new Subject("money", "0");
	
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	//building time 
	//
	
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
}
