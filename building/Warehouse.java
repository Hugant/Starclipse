package Starclipse.building;

import Starclipse.common.Resources;
import Starclipse.common.Subject;
import Starclipse.common.ScaleNumber;

/**
 * 
 * @author Hugant MD
 *
 */
public class Warehouse extends Starclipse.Building {
	
	private Starclipse.common.ScaleNumber volume = new Starclipse.common.ScaleNumber("1K");// the amount of resources per unit 
	private Resources store;
	
	public Warehouse(ScaleNumber volume, String... cells) {
		if (cells.length != 6) {
			throw new IllegalArgumentException("The number of elements in the string array must be equal to 6");
		} else {
			this.store = new Resources(volume, cells);
			super.setName("Warehouse");
			super.setResidents("10", "70");
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
