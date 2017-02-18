package Starclipse.Building;

import Starclipse.Subject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

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
	
	public Resources(String... res) {
		for(String i : res) {
			if(subjects.isEmpty()) {
				subjects.add(new Subject(i, "0"));
			} else {
				if(!subjects.contains(new Subject(i, "0"))) {
					subjects.add(new Subject(i, "0"));
				}
			}
		}	
	}
	
	public Resources(int i, String... res) {
		if(res.length % 2 != 0) {
			throw new IllegalArgumentException("The number of array elements must be even");
		} else {
			for(int i = 0; i < res.length; i += 2) {
				this.expenses(res[i].toLowerCase(), res[i + 1]);
			}
		}
		
	}
	
//	private void addStorage(String res, int volume) {
//		
//	}
//	
//	public String get(String res) {
//		
//	}
//	
//	private void expenses(String res, String volume) {
//		throw new UnsupportedOperationException("Such a resource does not exist");
//	}
}
