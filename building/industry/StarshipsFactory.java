package Starclipse.building.industry;

import Starclipse.common.Resources;
import Starclipse.common.Timer;

public class StarshipsFactory extends Starclipse.Building {
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
