package starclipse.building;

public class Building {
	String name = "";
	private String name = "";
	
	private starclipse.common.Timer buildTimer = null;
	private starclipse.common.Timer incomeTimer = null;
	
	private starclipse.common.Subject residents = null;
	
	private Resources income = null;
	private Resources expenses = null;
	
	private boolean start = false;
	
	public void build() {
		buildTimer.start();
		start = true;
	}
	
	public void startWork() {
		incomeTimer.start();
	}
	
	public Resources claim() {
		incomeTimer.start();
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
