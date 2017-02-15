package Starclipse.Building.Warehouse;

import Starclipse.Building.Resources;

public class Warehouse {
	private Resources res;
	private int manpower = 10;// 10(protection)
	private int volume = 500;// the amount of resources per unit 
	
	private int moneyCost = 0;
	//private int buildingTime = 0;
	private Resources needResources = null;
	
	//private int incomeTime = 0;
	
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
