package starclipse.building.industry;

import starclipse.common.Subject;
import starclipse.common.ScaleNumber;
import starclipse.common.Resources;

/**
 * Allows you to create a <b>Starship</b> with certain
 * properties: <b>damage</b>, <b>speed</b>, <b>passenger</b>, <b>storage</b>.
 * <ul>
 * 	<li>damage - gives your <b>Starship</b> ability to fight or defend.</li>
 * 	<li>speed - your <b>Starship</b> become more mobile.</li>
 * 	<li>passenger - allows your <b>Starship</b> to carry passengers in
 * a certain amount.
 * 	<li>storage - allows your <b>Starship</b> to carry any resources 
 * a certain amount.
 * </ul>
 * <p>
 * Each <b>Starship</b> has 5 cells in which you specify 
 * properties of the <b>Starship</b> which have been mentioned above.
 * <br>
 * You can specify the some property multiple times.
 * <p>
 * <table border = 1 cellpadding = 3>
 * 	<tr>
 * 		<td>damage</td>
 * 		<td>damage</td>
 * 		<td>speed</td>
 * 		<td>passenger</td>
 * 		<td>storage</td>
 * 	</tr>
 * </table>
 * 
 * @author Hugant MD
 *
 */
public class Starship {
	
	/**
	 * Allows you to create a <b>Storage</b> where you can 
	 * store <b>Resources</b> for <b>Starship</b>.
	 * @author Hugant MD
	 *
	 */
	class Storage {
		private Resources resources = null;
		private Resources expenses = null;
		
		/**
		 * Create <b>Storage</b> with these <b>Resources</b>.
		 * @param res is <b>Resources</b> which should be
		 * in the <b>Storage</b>.
		 */
		Storage(Resources res) {
			if (res.isStorage()) {
				if (res.length() == 5) {
					this.resources = res;
					this.expenses = new Resources(
							Subject.IRON, res.getVolume().divide("10").multiply(res.length() + "").toString(),
							Subject.ENERGY, res.getVolume().divide("2").multiply(res.length() + "").toString(),
							Subject.MONEY, res.getVolume().divide("2").multiply(res.length() + "").toString());
				} else {
					throw new IllegalArgumentException("The amount of storage must equal 5");
				}	
			} else {
				throw new IllegalArgumentException("The resources array needs to be a storage");
			}
		}
		
		/**
		 * Return expenses(<b>Resources</b>) of this <b>Storage</b>.
		 * @return expenses
		 */
		public Resources getExpenses() {
			return this.expenses;
		}
		
		/**
		 * Return <b>Resources</b> of this <b>Storage</b>.
		 * @return
		 */
		public Resources getResources() {
			return this.resources;
		}
		
		/**
		 * Adds to the <b>Resources</b> of this <b>Storage</b>
		 * <b>Subject</b>.
		 * @param sub is a <b>Subject</b> which you will to add
		 */
		public void add(Subject sub) {
			this.resources.add(sub);
		}
		
		/**
		 * Adds to the <b>Resources</b> of this <b>Storage</b>
		 * <b>Resources</b>.
		 * @param res is a <b>Resources</b> which you will to add
		 */
		public void add(Resources res) {
			this.resources.add(res);
		}
		
		/**
		 * Take from the <b>Resources</b> of this <b>Storage</b>
		 * <b>Subject</b>.
		 * @param sub is a <b>Subject</b> which you will to take
		 */
		public void minus(Subject sub) {
			this.resources.minus(sub);
		}
		
		/**
		 * Take from the <b>Resources</b> of this <b>Storage</b>
		 * <b>Resources</b>.
		 * @param res is a <b>Resources</b> which you will take
		 */
		public void minus(Resources res) {
			this.resources.add(res);
		}
	}
	
	
	
	private static final String NAMES_MAS[] = {"Crimson", "Wenda", "Lexa"};
	private static final ScaleNumber FOOD_FOR_ONE_PASSENGER = new ScaleNumber("50");
	private static final ScaleNumber OXYGEN_FOR_ONE_PASSENGER = new ScaleNumber("100");
	private static final ScaleNumber MONEY_FOR_ONE_PASSENGER = new ScaleNumber("500");
	
	private int damage = 0;
	private int speed = 0;
	private int passengerCompartment = 0;
	
	private String name = "";
	private String owner = "";// ???????????
	
	private Subject residents = new Subject(Subject.RESIDENTS, "25", "25");
	private Subject passenger = null;
	private ScaleNumber passengerValume = new ScaleNumber("10");
	
	
	private Storage storage = null;
	private Resources expenses = new Resources();
	
	/**
	 * Creates a <b>Starship</b> with the specified parameters.
	 * @throws IllegalArgumentException
	 * @param name is name of the <b>Starship</b>, it can be empty,
	 * then it will be chosen by random name
	 * @param res is <b>Resources</b> of the <b>Storage</b>, if you
	 * do not specify "storage" parameter, then it can be null.
	 * @param cells is a massive of strings where you should specify
	 * parameters of the <b>Starship</b>: damage, speed, passenger, storage
	 */
	public Starship(String name, Resources res, String... cells) {
		for (String i : cells) {
			switch (i) {
				case "damage":    
					this.damage++;
					expenses.add(new Resources( Subject.IRON, 	"10K",
												Subject.ENERGY, "1K" ,
												Subject.MONEY,	"100K"));
					break;
					
				case "speed":     
					this.speed++;
					expenses.add(new Resources( Subject.ENERGY, "1K",
												Subject.MONEY, 	"10K"));
					break;
					
				case "passenger": 
					this.passengerCompartment++;
					expenses.add(new Subject(
							Subject.OXYGEN, OXYGEN_FOR_ONE_PASSENGER.multiply(passengerValume).toString()));
					expenses.add(new Subject(
							Subject.FOOD, FOOD_FOR_ONE_PASSENGER.multiply(passengerValume).toString()));
					expenses.add(new Subject(
							Subject.MONEY, MONEY_FOR_ONE_PASSENGER.multiply(passengerValume).toString()));
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
	
	/**
	 * Return name of the <b>Starship</b>.
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Return owner of the <b>Starship</b>.
	 * @return
	 */
	public String getOwner() {
		return this.owner;
	}
	
	/**
	 * Return amount of cells with parameter "damage".
	 * @return amount of damage
	 */
	public int getDamage() {
		return this.damage;
	}
	
	/**
	 * Return amount of cells with parameter "speed".
	 * @return amount of speed
	 */
	public int getSpeed() {
		return this.speed;
	}
	
	/**
	 * Return amount of cells with parameter "passenger".
	 * @return amount of passenger
	 */
	public int getPassenger() {
		return this.passengerCompartment;
	}
	
	/**
	 * Return expenses(<b>Resources</b>) of this <b>Starship</b>.
	 * @return expenses
	 */
	public Resources getExpenses() {
		return this.expenses;
	}
	
	/**
	 * Return residents in form of <b>Subject</b>.
	 * @return residents
	 */
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
	
	public void defend(Starship starhips) {
		
	}
	
	public void defend(starclipse.Planet planet) {
		
	}
	
	public void attack(Starship starship) {
		
	}
}