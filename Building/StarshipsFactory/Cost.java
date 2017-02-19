package Starclipse.Building.StarshipsFactory;

import Starclipse.Building.Resources;
import Starclipse.LimitlessNumber;

public class Cost {
	private Resources res;
	private int manpower = 0;
	private LimitlessNumber volume = new LimitlessNumber("300");// the amount of resources per unit 
	
	//private int buildingTime = 0;
	private Resources needResources = null;
	
	//private int incomeTime = 0;
	
	public Cost(String... cells) {
		if(cells.length != 5) {// only 5 cells
			throw new IllegalArgumentException("The number of elements in the string array must be equal to 5");
		} else {
			res = new Resources(volume, cells);
			for(String i : cells) {
				switch(i) {
					case "tree":   this.manpower += 1; break;
					case "iron":   this.manpower += 2; break;
					case "gold":   this.manpower += 3; break;
					case "energy": this.manpower += 1; break;			
					case "water":  this.manpower += 1; break;
					case "oxygen": this.manpower += 1; break;
					case "coal":   this.manpower += 2; break;
					case "stone":  this.manpower += 1; break;
					case "food":   this.manpower += 1; break;
				}
			}
		}
	}
	
	public int getManpower() {
		return this.manpower;
	}
	
	public Resources getNeedResources() {
		return this.needResources;
	}
}
