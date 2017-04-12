package starclipse.building.industry;

import starclipse.common.Resources;

public class StarshipsFactory extends starclipse.Building {
	private String name = "Starships Factory";
	private Starship starship = null;
	private int manpower = 0;
	private Resources expenses = null;
			
	public StarshipsFactory() {
		
	}
	
	public Starship getStarship() {
		return this.starship;
	}
	
	public String getName() {
		return this.name;
	}
}
