package starclipse.building;

import starclipse.common.Timer;
import starclipse.common.Subject;

/**
 * This class implements an object <b>House</b> that has three types:
 * small, average, big. Depending on the type of <b>House</b> 
 * after a certain period of time brings income: residents, money.
 * Also depending on the type of <b>House</b> contains a certain 
 * number of residents.
 * 
 * @author Hugant MD
 * 
 * @see starclipse.building.Building
 *
 */
public class House extends starclipse.building.Building {
	/**
	 * Create a <b>House</b> where the parameters specified a type
	 * of <b>House</b>.
	 * @param type is type of <b>House</b>
	 */
	public House(String type) {
		switch (type.toLowerCase()) {
			case "big":
				super.setResidents(new Subject(Subject.RESIDENTS, "0", "100"));
				super.setName("Big House");
				super.setBuildTimer(new Timer(Timer.MINUTE * 30, "Start"));
				super.setIncomeTimer(new Timer(Timer.SECOND * 20, "Claim"));
				super.setIncome(new Resources(Subject.RESIDENTS, "10", Subject.MONEY, "100"));
				super.setExpenses(new Resources(Subject.STONE,  "100", 
											  	Subject.TREE,   "50", 
											  	Subject.MONEY,  "1000", 
											  	Subject.IRON,   "10",  
											  	Subject.WATER,  "10", 
											  	Subject.ENERGY, "10"  ));
				return;
				
			case "average":
				super.setResidents(new Subject(Subject.RESIDENTS, "0", "50"));
				super.setName("Average House");
				super.setBuildTimer(new Timer(Timer.MINUTE * 5, "Start"));
				super.setIncomeTimer(new Timer(Timer.SECOND * 20, "Claim"));
				super.setIncome(new Resources(Subject.RESIDENTS, "5", Subject.MONEY, "50"));
				super.setExpenses(new Resources(Subject.STONE,  "50", 
											  	Subject.TREE,   "25", 
											  	Subject.MONEY,  "500",
											  	Subject.IRON,   "5" , 
											  	Subject.WATER,  "5" , 
											  	Subject.ENERGY, "5"  ));	
				return;
				
			case "small":
				super.setResidents(new Subject(Subject.RESIDENTS, "0", "10"));
				super.setName("Small House");
				super.setBuildTimer(new Timer(Timer.SECOND * 5, "Start"));
				super.setIncomeTimer(new Timer(Timer.SECOND * 10, "Claim"));
				super.setIncome(new Resources(Subject.RESIDENTS, "3", Subject.MONEY, "25"));
				super.setExpenses(new Resources(Subject.STONE,  "12", 
												Subject.TREE,   "6", 
											  	Subject.MONEY,  "125",
											  	Subject.IRON,   "1" , 
											  	Subject.WATER,  "1", 
											  	Subject.ENERGY, "1"  ));
				return;
		}
	}
}
