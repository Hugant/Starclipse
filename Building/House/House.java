package Starclipse.Building.House;

import Starclipse.Building.Resources;
import Starclipse.Timer;

public class House {
	private int maxResidents = 0;
	private int residents = 0;
	private String name = "";
	private Resources needResources = null;
	
	public House(String type) {
		switch(type) {
			case "big":
				this.maxResidents = 100;
				this.name = "Big House";
				//this.incomeTime;
				//this.buildingTime;
				this.needResources = new Resources("stone",  "100", 
												   "tree",   "50", 
												   "money",  "1000", 
												   "iron",   "10",  
												   "water",  "10", 
												   "energy", "10"  );
				break;
				
			case "avarage":
				this.maxResidents = 50;
				this.name = "Avarage House";
				//this.incomeTime;
				//this.buildingTime;
				this.needResources = new Resources("stone",  "50", 
												   "tree",   "25", 
												   "money",  "500",
												   "iron",   "5" , 
												   "water",  "5" , 
												   "energy", "5"  );	
				break;
				
			case "small":
				this.maxResidents = 10;
				this.name = "Small House";
				//this.incomeTime;
				//this.buildingTime;
				this.needResources = new Resources("stone",  "12", 
												   "tree",   "6", 
												   "money",  "125",
												   "iron",   "1" , 
												   "water",  "1", 
												   "energy", "1"  );
				break;
		}
	}
}
