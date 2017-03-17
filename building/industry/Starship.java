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
				if(res.asTypeArray().length == 5) {
					this.resources = res;
					this.expenses = new Resources();
					
					for(String i : res.asTypeArray()) {
						switch(i) {
							case "gold":
								expenses.add(new Subject("something", "1"));
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
								this.expenses = null;
								this.resources = null;
								throw new IllegalArgumentException(i + " this type is not used in storage");
						}
					}
				} else {
					throw new IllegalArgumentException("The amount of storage must equal 5");
				}	
			} else {
				throw new IllegalArgumentException("The resources array needs to be a storage");
			}
		}
		
		public Resources getExpenses() {
			return this.expenses;
		}
		
		public Resources getResources() {
			return this.resources;
		}
	}
	
	
	
	private static final int PASSENGER_VOLUME = 10;// quantity per unit
	private static final String NAMES_MAS[] = {"Crimson", "Wenda", "Lexa", ""};
	
	
	private int damage = 0;
	private int speed = 0;
	private int passenger = 0;
	private Storage storage = null;
		 
	private Subject residents = new Subject(Subject.RESIDENTS, "25", "25");
	
	private String name = "";
	private Resources expenses = null;
	
	public Starship(String name, Resources res, String... cells) {
		for(String i : cells) {
			switch(i) {
				case "damage":    this.damage++;    break;
				case "speed":     this.speed++;     break;
				case "passenger": this.passenger++; break;
				
				case "storage":
					if(res == null) {
						throw new IllegalArgumentException("If you specify an element of 'storage', "
															+ "the object cannot be null");
					} else {
						Storage a = new Storage(res);
					}
					break;
					
				default:
					throw new IllegalArgumentException("Such a resource does not exist");
			}
		}
		
		if(name != null && !name.equals("")) {
			this.name = name;
		} else {
			
		}
	}
}

