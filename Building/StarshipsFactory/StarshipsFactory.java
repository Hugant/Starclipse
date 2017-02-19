package Starclipse.Building.StarshipsFactory;

import Starclipse.Building.Resources;

public class StarshipsFactory {
	private String name = "Starships Factory";
	private Starship starship = null;
	private int manpower = 0;
	private Resources needResources = new Resources("iron",   "10000",   
													"gold",   "5000",   
													"tree",   "1000",
													"stone",  "1000",    
													"energy", "100000", 
													"water",  "10000",
													"money",  "10000000");
	
	public void createStarship(String name, Cost cost, String... cells) {
		this.starship = new Starship(name, cost, cells);
	}
	
	public Starship getStarship() {
		return this.starship;
	}
	
	public String getName() {
		return this.name;
	}
}
