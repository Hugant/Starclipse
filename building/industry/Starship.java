package starclipse.building.industry;

import java.util.Arrays;

import starclipse.building.Resources;
import starclipse.common.Subject;
import starclipse.common.LimitlessNumber;

public class Starship {
	
	public class Cost {
		private Resources resources = null;
		private LimitlessNumber volume = new LimitlessNumber("300");// the amount of resources per unit 
		private Resources expenses = null;
		
		
		public Cost(Resources res) {
			
		}
		
		public Resources getNeedResources() {
			return this.expenses;
		}
	}
	
	
	
	private static final byte PASSENGER_VOLUME = 10;// quantity per unit
	private static final String NAMES_MAS[] = {"Crimson", "Wenda", ""};
	
	
	private int damage = 0;
	private int speed = 0;
	private int passenger = 0;
	private Cost cost = null;
		 
	private int residents = 25;
	
	private String name = "";
	private Resources expenses = null;
	
	public Starship(String name, Resources res, String... cells) {
		for(String i : cells) {
			switch(i) {
				case "damage":
					this.damage++;
					this.manpower++;
					break;
					
				case "speed":
					this.speed++;
					this.manpower++;
					break;
					
				case "passenger":
					this.passenger++;
					this.manpower += 3;
					break;
				
				case "cost":
					if(cost == null) {
						throw new IllegalArgumentException("If you specify an element of 'cost', "
															+ "the object cannot be null");
					} else {
						this.cost = new Cost("");
						this.manpower += cost.getManpower();
					}
					break;
					
				default:
					throw new UnsupportedOperationException("Such a resource does not exist");
			}
			
			this.name = name;
			this.residents = passenger * PASSENGER_VOLUME;
		}
	}
	
	public int getResidents() {
		return this.residents;
	}
}

