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
	
	public String getStatus() {
		if (!buildTimer.isWork() && start && incomeTimer.isWork()) {
			return incomeTimer.toString();
		}
		return buildTimer.toString();
	}
	
	
	public void setName(String name) {
		this.name = name;
	}

	public void setBuildTimer(starclipse.common.Timer buildTime) {
		this.buildTimer = buildTime;
	}

	public void setIncomeTimer(starclipse.common.Timer incomeTime) {
		this.incomeTimer = incomeTime;
	}

	public void setResidents(starclipse.common.Subject residents) {
		this.residents = residents;
	}

	public void setIncome(Resources income) {
		this.income = income;
	}

	public void setExpenses(Resources expenses) {
		this.expenses = expenses;
	}
	
	
}
