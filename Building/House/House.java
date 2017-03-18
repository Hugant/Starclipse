package starclipse.building.house;

import starclipse.building.Resources;
import starclipse.common.Timer;
import starclipse.common.Subject;

public class House extends starclipse.building.Building {
	private String name = "";
	private Timer buildTime;
	private Timer incomeTime;
	private Subject residents;
	private Resources expenses = null;
	
	public House(String type) {
		switch (type.toLowerCase()) {
			case "big":
				this.residents = new Subject(Subject.RESIDENTS, "0", "100");
				this.name = "Big House";
				this.buildTime = new Timer(Timer.MINUTE + Timer.SECOND * 30, "Start");
				this.incomeTime = new Timer(Timer.SECOND * 20, "Claim");
				this.income = new Resources(Subject.RESIDENTS, "10", Subject.MONEY, "100");
				this.expenses = new Resources(Subject.STONE,  "100", 
											  Subject.TREE,   "50", 
											  Subject.MONEY,  "1000", 
											  Subject.IRON,   "10",  
											  Subject.WATER,  "10", 
											  Subject.ENERGY, "10"  );
				return;
				
			case "avarage":
				this.residents = new Subject(Subject.RESIDENTS, "0", "50");
				this.name = "Avarage House";
				this.buildTime = new Timer(Timer.MINUTE * 5, "Start");
				this.incomeTime = new Timer(Timer.SECOND * 20, "Claim");
				this.income = new Resources(Subject.RESIDENTS, "5", Subject.MONEY, "50");
				this.expenses = new Resources(Subject.STONE,  "50", 
											  Subject.TREE,   "25", 
											  Subject.MONEY,  "500",
											  Subject.IRON,   "5" , 
											  Subject.WATER,  "5" , 
											  Subject.ENERGY, "5"  );	
				return;
				
			case "small":
				this.residents = new Subject(Subject.RESIDENTS, "0", "10");
				this.name = "Small House";
				this.buildTime = new Timer(Timer.SECOND * 5, "Start");
				this.incomeTime = new Timer(Timer.SECOND * 10, "Claim");
				this.income = new Resources(Subject.RESIDENTS, "3", Subject.MONEY, "25");
				this.expenses = new Resources(Subject.STONE,  "12", 
											  Subject.TREE,   "6", 
											  Subject.MONEY,  "125",
											  Subject.IRON,   "1" , 
											  Subject.WATER,  "1", 
											  Subject.ENERGY, "1"  );
				return;
		}
	}
	
	public void build() {
		buildTime.start();
	}
	
	public void startWork() {
		incomeTime.start();
	}
	
	synchronized public String getStatus() {
//		if (buildTime.toString().equals("End Work")) {
//			return "Start";
//		} 
		return incomeTime.toString();
	}
	
	private void setStatus(String status) {
		this.status = status;
	}
	
	public Subject claim() {
		incomeTime.start();
		return this.residents;
	}
}
