package starclipse.building.warehouse;

import starclipse.building.Resources;
import starclipse.common.LimitlessNumber;

public class Warehouse {
	private Resources res;
	private int manpower = 10;// 10(protection)
	private LimitlessNumber volume = new LimitlessNumber("500");// the amount of resources per unit 
	private Resources needResources = null;
	
	public Warehouse(String[] cells) {
		if(cells.length != 6) {
			throw new IllegalArgumentException("The number of elements in the string array must be equal to 6");
		} else {
			res = new Resources(volume, cells);
			
			for(String i : cells) {
				switch(i) {
					case "tree":   this.manpower +=  1; break;
					case "iron":   this.manpower +=  3; break;
					case "gold":   this.manpower += 10; break;
					case "energy": this.manpower +=  1; break;			
					case "water":  this.manpower +=  2; break;
					case "oxygen": this.manpower +=  2; break;
					case "coal":   this.manpower +=  2; break;
					case "stone":  this.manpower +=  1; break;
					case "food":   this.manpower +=  2; break;
				}
			}
		}
	}
}
