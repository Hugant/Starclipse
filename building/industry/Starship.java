package starclipse.building.industry;

import java.util.Arrays;

import starclipse.common.Subject;
import starclipse.common.LimitlessNumber;
import starclipse.common.Resources;

public class Starship {
	
	class Storage {
		private Resources resources = null;
		private Resources expenses = null;
		
		
		public Storage(Resources res) {
			if (res.isStorage()) {
				if (res.asTypeArray().length == 5) {
					this.resources = res;
					this.expenses = new Resources();
					
					for (String i : res.asTypeArray()) {
						switch (i) {
							case Subject.GOLD:
								expenses.add(new Subject("something", "1"));
								break;
							
							case Subject.IRON:
								expenses.add(new Subject("something", "1"));
								break;
								
							case Subject.COAL:
								expenses.add(new Subject("something", "1"));
								break;
							
							case Subject.TREE:
								expenses.add(new Subject("something", "1"));
								break;
							
							case Subject.STONE:
								expenses.add(new Subject("something", "1"));
								break;
								
							case Subject.WATER:
								expenses.add(new Subject("something", "1"));
								break;
								
							case Subject.OXYGEN:
								expenses.add(new Subject("something", "1"));
								break;
								
							case Subject.ENERGY:
								expenses.add(new Subject("something", "1"));
								break;
								
							case Subject.FOOD:
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
	private static final String NAMES_MAS[] = {"Crimson", "Wenda", "Lexa"};
	
	
	private int damage = 0;
	private int speed = 0;
	private int passenger = 0;
	private Storage storage = null;
		 
	private Subject residents = new Subject(Subject.RESIDENTS, "25", "25");
	
	private String name = "";
	private String owner = "";
	private Resources expenses = null;
	
	public Starship(String name, Resources res, String... cells) {
		for (String i : cells) {
			switch (i) {
				case "damage":    this.damage++;    break;
				case "speed":     this.speed++;     break;
				case "passenger": this.passenger++; break;
				
				case "storage":
					if (res == null) {
						this.toAnnihilateVariables();
						throw new IllegalArgumentException("If you specify an element of 'storage', "
															+ "the object cannot be null");
					} else {
						storage = new Storage(res);
						expenses = storage.getExpenses();
					}
					break;
					
				default:
					this.toAnnihilateVariables();
					throw new IllegalArgumentException("Such a resource does not exist");
			}
		}
		
		if (name != null && !name.equals("")) {
			this.name = name;
		} else {
			this.name = NAMES_MAS[new java.util.Random().nextInt(NAMES_MAS.length)];
		}
	}
	
	private void toAnnihilateVariables() {
		this.damage = 0;
		this.speed = 0;
		this.passenger = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public int getPassenger() {
		return this.passenger;
	}
	
	public Resources getExpenses() {
		return this.expenses;
	}
}