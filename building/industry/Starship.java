package starclipse.building.industry;

import java.util.Arrays;

import starclipse.building.Resources;
import starclipse.common.Subject;
import starclipse.common.LimitlessNumber;

public class Starship {
	
	class Storage {
		private Resources resources = null;
		private Resources expenses = null;
		
		
		public Storage(Resources res) {
			if(res.isStorage()) {
				this.resources = res;
				this.expenses = new Resources();
				for(String i : res.asTypeArray()) {
					switch(i) {
						case "gold":
							expenses.add(new Subject("something", "1"));// bug
							break;
						
						case "iron":
							expenses.add(new Subject("something", "1"));
							break;
							
						case "coal":
							expenses.add(new Subject("something", "1"));
							break;
						
						case "stone":
							expenses.add(new Subject("something", "1"));
							break;
							
						case "water":
							expenses.add(new Subject("something", "1"));
							break;
							
						case "oxygen":
							expenses.add(new Subject("something", "1"));
							break;
							
						case "energy":
							expenses.add(new Subject("something", "1"));
							break;
							
						case "food":
							expenses.add(new Subject("something", "1"));
							break;
							
						default: 
							throw new IllegalArgumentException(i + " this type of use in storage");
					}
				}
			} else {
				throw new IllegalArgumentException("The resources array needs to be a storage");
			}
		}
		
		public Resources getExpenses() {
			return this.expenses;
		}
	}
	
	
	
	private static final int PASSENGER_VOLUME = 10;// quantity per unit
	private static final String NAMES_MAS[] = {"Crimson", "Wenda", "Lexa", ""};
	
	
	private int damage = 0;
	private int speed = 0;
	private int passenger = 0;
	private Storage storage = null;
		 
	private int residents = 25;
	
	private String name = "";
	private Resources expenses = null;
	
	public Starship(String name, Resources res/*, String... cells*/) {
		Storage a = new Storage(res);
//		for(String i : cells) {
//			switch(i) {
//				case "damage":
//					this.damage++;
//					this.manpower++;
//					break;
//					
//				case "speed":
//					this.speed++;
//					this.manpower++;
//					break;
//					
//				case "passenger":
//					this.passenger++;
//					this.manpower += 3;
//					break;
//				
//				case "cost":
//					if(cost == null) {
//						throw new IllegalArgumentException("If you specify an element of 'cost', "
//															+ "the object cannot be null");
//					} else {
//						this.cost = new Cost("");
//						this.manpower += cost.getManpower();
//					}
//					break;
//					
//				default:
//					throw new UnsupportedOperationException("Such a resource does not exist");
//			}
//			
//			this.name = name;
//			this.residents = passenger * PASSENGER_VOLUME;
//		}
	}
	
	public int getResidents() {
		return this.residents;
	}
}

