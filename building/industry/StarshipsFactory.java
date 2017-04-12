package starclipse.building.industry;

import starclipse.common.Resources;
import starclipse.common.Timer;

public class StarshipsFactory extends starclipse.Building {
	private String name = "Starships Factory";
	private Starship starship = null;
	private int manpower = 0;
	private Resources expenses = null;
			
	public StarshipsFactory() {
		super.setName("Starships Factory");
		super.setBuildTimer(30 * Timer.DAY, "Start");
		super.setIncomeTimer(10 * Timer.DAY, "Claim");
		super.setResidents("0", "");
		super.setExpenses(new Resources());
	}
	
	
	
	public Starship getStarship() {
		return this.starship;
	}
	
	public String getName() {
		return this.name;
	}
}
