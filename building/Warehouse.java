package starclipse.building;

import starclipse.common.Resources;
import starclipse.common.Subject;
import starclipse.common.ScaleNumber;

/**
 * 
 * @author Hugant MD
 *
 */
public class Warehouse extends starclipse.Building {
	
	private starclipse.common.ScaleNumber volume = new starclipse.common.ScaleNumber("500");// the amount of resources per unit 
	private Resources store;
	
	public Warehouse(ScaleNumber volume, String... cells) {
		if (cells.length != 6) {
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
	
	public Subject takeFromStore(Subject sub) {
		store.minus(sub);
		return sub;
	}
	
	public Resources takeFromStore(Resources res) {
		store.minus(res);
		return res;
	}
	
	public void fill() {
		store.fill();
	}
}
