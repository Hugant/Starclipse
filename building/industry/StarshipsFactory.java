package starclipse.building.industry;

import starclipse.building.Resources;
import starclipse.common.Cost;

public class StarshipsFactory {
	private String name = "Starships Factory";
	private Starship starship = null;
	private int manpower = 0;
	private Resources expenses = new Resources("iron",   "10K",   
													"gold",   "5K",   
													"tree",   "1K",
													"stone",  "1K",    
													"energy", "1M", 
													"water",  "10K",
													"money",  "10M");
	
//	public void createStarship(String name, Cost cost, String... cells) {
//		this.starship = new Starship(name, cost, cells);
//	}
	
	public Starship getStarship() {
		return this.starship;
	}
	
	public String getName() {
		return this.name;
	}
}
