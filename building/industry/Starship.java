package starclipse.building.industry;

import starclipse.common.Subject;
import starclipse.common.ScaleNumber;
import starclipse.common.Resources;

public class Starship {
	
	class Storage {
		private Resources resources = null;
		private Resources expenses = null;
		
		
		Storage(Resources res) {
			if (res.isStorage()) {
				if (res.length() == 5) {
					this.resources = res;
					this.expenses = new Resources(
							Subject.IRON, res.getVolume().divide("10").multiply(res.length() + "").toString(),
							Subject.ENERGY, res.getVolume().divide("2").multiply(res.length() + "").toString());
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
		
		public void add(Subject sub) {
			this.resources.add(sub);
		}
		
		public void add(Resources res) {
			this.resources.add(res);
		}
		
		public void minus(Subject sub) {
			this.resources.minus(sub);
		}
		
		public void minus(Resources res) {
			this.resources.add(res);
		}
	}
	
	
	
	private static final String NAMES_MAS[] = {"Crimson", "Wenda", "Lexa"};
	private static final ScaleNumber FOOD_FOR_ONE_PASSENGER = new ScaleNumber("50");
	private static final ScaleNumber OXYGEN_FOR_ONE_PASSENGER = new ScaleNumber("100");
	
	private int damage = 0;
	private int speed = 0;
	private int passengerCompartment = 0;
	
	private String name = "";
	private String owner = "";// ???????????
	
	private Subject residents = new Subject(Subject.RESIDENTS, "25", "25");
	private Subject passenger = null;
	private static ScaleNumber passengerValume = new ScaleNumber("10");
	
	private Storage storage = null;
	private Resources expenses = new Resources();
	
	public Starship(String name, Resources res, String... cells) {
		for (String i : cells) {
			switch (i) {
				case "damage":    
					this.damage++;
					expenses.add(new Subject("damage", "1"));
					break;
					
				case "speed":     
					this.speed++;
					expenses.add(new Subject("speed", "1"));
					break;
					
				case "passenger": 
					this.passengerCompartment++;
					expenses.add(new Subject("food", "1"));
					break;
				
				case "storage":
					if (res == null) {
						this.toAnnihilateVariables();
						throw new IllegalArgumentException("If you specify an element of 'storage', "
															+ "the object cannot be null");
					} else {
						storage = new Storage(res);
						expenses.add(storage.getExpenses());
					}
					break;
					
				default:
					this.toAnnihilateVariables();
					throw new IllegalArgumentException("Such a resource does not exist");
			}
		}
		
		;
		this.passenger = new Subject(Subject.RESIDENTS, "0",
				passengerValume.multiply(new ScaleNumber(passengerCompartment + "")).toString());
		
		if (name != null && !name.equals("")) {
			this.name = name;
		} else {
			this.name = NAMES_MAS[new java.util.Random().nextInt(NAMES_MAS.length)];
		}
	}
	
	private void toAnnihilateVariables() {
		this.damage = 0;
		this.speed = 0;
		this.passengerCompartment = 0;
		this.expenses = null;
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
		return this.passengerCompartment;
	}
	
	public Resources getExpenses() {
		return this.expenses;
	}
	
	public Subject getResidents() {
		return residents;
	}
	
	public void addPassenger(String number) {
		this.residents.add(new Subject(number)); 
	}
	
	public void setPassengerValume(String number) {
		this.passengerValume = new ScaleNumber(number);
	}
	
	public void setPassengerValume(ScaleNumber number) {
		this.passengerValume = number;
	}
}