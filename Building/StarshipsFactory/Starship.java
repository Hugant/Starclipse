package Starclipse.Building.StarshipsFactory;

import Starclipse.Building.Resources;

public class Starship {
	private static final byte PASSENGER_VOLUME = 10;// quantity per unit
	private static final String NAMES_MAS[] = {"Crimson", "Wenda", ""};
	
	
	private int damage = 0;
	private int speed = 0;
	private int passenger = 0;
	private Cost cost = null;
		
	private int residents = 0;
	private int manpower = 5;// 2(pilots) , 3(mechanics)
	
	private String name = "";
	private Resources expenses = null;
	
	public Starship(String name, Cost cost, String... cells) {
		if(cells.length != 5) {
			throw new IllegalArgumentException("The number of elements in the string array must be equal to 5");
		} else {
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
							this.cost = cost;
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
	}
	
	public int getResidents() {
		return this.residents;
	}
}
