package starclipse.building;

import starclipse.common.LimitlessNumber;
import starclipse.common.Resources;
import starclipse.common.Subject;

public class Warehouse extends starclipse.building.Building {
	
	private LimitlessNumber volume = new LimitlessNumber("500");// the amount of resources per unit 
	private Resources store;
	
	public Warehouse(String... cells) {
		if(cells.length != 6) {
			throw new IllegalArgumentException("The number of elements in the string array must be equal to 6");
		} else {
			this.store = new Resources(volume, cells);
			super.setName("Warehouse");
			super.setResidents(new Subject(Subject.RESIDENTS, "10", "70"));
			super.setExpenses(new Resources());
		}
	}
	
	public void addToStore(Subject sub) {
		store.add(sub);
	}
	
	public void addToStore(Resources res) {
		store.add(res);
	}
	
	public void takeFromStore(Subject sub) {
		store.minus(sub);
	}
	
	public void takeFromStore(Resources res) {
		store.minus(res);
	}
}
