package starclipse.building;

import starclipse.common.Resources;

/**
 * 
 * @author Hugant MD
 *
 * @see starclipse.common.Timer
 * @see starclipse.common.Subject
 * @see starclipse.common.Resources
 * @see starclipse.building.House
 */
public class Building {
	private String name = "";
	
	private starclipse.common.Timer buildTimer = null;
	private starclipse.common.Timer incomeTimer = null;
	
	private starclipse.common.Subject residents = null;
	
	private Resources income = null;
	private Resources expenses = null;
	
	private boolean start = false;
	
	/**
	 * Begins to build the <b>Building</b>.
	 */
	public void build() {
		buildTimer.start();
	}
	
	/**
	 * Starts work in the <b>Building</b>.
	 */
	public void startWork() {
		incomeTimer.start();
		start = true;
	}
	
	
	/**
	 * Return the <b>Resources</b> which was extracted.
	 * @return income is <b>Resources</b> which was extracted
	 */
	public Resources claim() {
		incomeTimer.start();
		return income;
	}
	
	/**
	 * Return name of <b>Building</b>.
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Return the <b>Resources</b> which are necessary for the
	 * construction of this <b>Building</b>.
	 * @return expenses is a <b>Resources</b> which which are necessary for the
	 * construction
	 */
	public Resources getExpenses() {
		return expenses;
	}
	
	/**
	 * Return the maximum number of residents.
	 * @return maxResidents is <b>String</b>
	 */
	public String getMaxResidents() {
		return residents.getMaxValue();
	}
	
	/**
	 * Return the current number of residents.
	 * @return residents id <b>String</b>
	 */
	public String getResidents() {
		return residents.getNumber();
	}
	
	/**
	 * Return status of the timer. If timer is work, then 
	 * will return time. Otherwise return <b>String</b> "Start" or "Claim".
	 * @return time or "Start" or "Claim"
	 * 
	 * @see starclipse.common.Timer
	 */
	public String getStatus() {
		if (((buildTimer.isWork() || incomeTimer.isWork()) || !incomeTimer.isWork()) && start) {
			return incomeTimer.toString();
		}
		return buildTimer.toString();
	}
	
	
	/**
	 * Sets the name of <b>Building</b>.
	 * @param name is <b>String</b>
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the build <b>Timer</b> of <b>Building</b>.
	 * @param buildTime is <b>Timer</b>
	 */
	public void setBuildTimer(starclipse.common.Timer buildTime) {
		this.buildTimer = buildTime;
	}

	/**
	 * Sets the income <b>Timer</b> of <b>Building</b>.
	 * @param incomeTime is <b>Timer</b>
	 */
	public void setIncomeTimer(starclipse.common.Timer incomeTime) {
		this.incomeTimer = incomeTime;
	}

	/**
	 * Sets the number of residents.
	 * @param residents is <b>Subject</b>
	 */
	public void setResidents(starclipse.common.Subject residents) {
		this.residents = residents;
	}

	/**
	 * Sets the income <b>Resources</b>.
	 * @param income is <b>Resources</b>
	 */
	public void setIncome(Resources income) {
		this.income = income;
	}

	/**
	 * Sets the expenses which are necessary for the
	 * construction of this <b>Building</b>.
	 * @param expenses is <b>Resources</b>
	 */
	public void setExpenses(Resources expenses) {
		this.expenses = expenses;
	}
	
	
}
