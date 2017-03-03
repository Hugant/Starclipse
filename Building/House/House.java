package Starclipse.Building.House;

import Starclipse.Building.Resources;
import Starclipse.Timer;

public class House {
	private int maxResidents = 0;
	private int residents = 0;
	private String status = "";
	private String name = "";
	private Resources expenses = null;
	private Timer buildTime;
	private Timer incomeTime;
	
	public House(String type) {
		switch(type) {
		switch(type.toLowerCase()) {
			case "big":
				this.maxResidents = 100;
				this.name = "Big House";
				this.buildTime = new Timer(Timer.MINUTE + Timer.SECOND * 30);
				this.expenses = new Resources("stone",  "100", 
											  "tree",   "50", 
											  "money",  "1000", 
											  "iron",   "10",  
											  "water",  "10", 
											  "energy", "10"  );
				return;
				
			case "avarage":
				this.maxResidents = 50;
				this.name = "Avarage House";
				this.buildTime = new Timer(Timer.MINUTE * 5);
				this.expenses = new Resources("stone",  "50", 
											  "tree",   "25", 
											  "money",  "500",
											  "iron",   "5" , 
											  "water",  "5" , 
											  "energy", "5"  );	
				return;
				
			case "small":
				this.maxResidents = 10;
				this.name = "Small House";
				this.buildTime = new Timer(Timer.MINUTE * 30);
				this.expenses = new Resources("stone",  "12", 
											  "tree",   "6", 
											  "money",  "125",
											  "iron",   "1" , 
											  "water",  "1", 
											  "energy", "1"  );
				return;
		}
	}
}
