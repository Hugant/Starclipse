package starclipse.building;

public class Building {
	String name = "";
	
	starclipse.common.Timer buildTime = null;
	starclipse.common.Timer incomeTime = null;
	
	starclipse.common.Subject residents = null;
	
	Resources income = null;
	Resources expenses = null;
	
	public void build() {
		buildTime.start();
	}
	
	public void startWork() {
		incomeTime.start();
	}
	
	public Resources claim() {
		incomeTime.start();
		return income;
	}
	
	public String getName() {
		return name;
	}
	
	public Resources getExpenses() {
		return expenses;
	}
	
	public String getMaxResidents() {
		return residents.getMaxValue();
	}
	
	public String getResidents() {
		return residents.getNumber();
	}
	
}
