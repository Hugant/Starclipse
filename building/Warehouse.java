package starclipse.building;

import starclipse.common.LimitlessNumber;
import starclipse.common.Resources;
import starclipse.common.Subject;

public class Warehouse extends starclipse.building.Building {
	
	private Subject residents = new Subject(Subject.RESIDENTS, "10", "70");
	private LimitlessNumber volume = new LimitlessNumber("500");// the amount of resources per unit 
	private Resources store;
	private Resources expenses = null;
	
	public Warehouse(String[] cells) {
		if(cells.length != 6) {
			throw new IllegalArgumentException("The number of elements in the string array must be equal to 6");
		} else {
			store = new Resources(volume, cells);
		}
	}
	
	public void addToStore(Subject sub) {
		store.add(sub);
	}
	
	public void addToStore(Resources res) {
		store.add(res);
	}
}
