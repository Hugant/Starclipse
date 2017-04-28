package Starclipse;

import Starclipse.building.House;
import Starclipse.common.Resources;
import Starclipse.common.Timer;
import Starclipse.common.Subject;

/**
 * This is class the parents for buildings:
 * House, Warehouse, ResourcesFactory, StarshipFactory
 * 
 * @author Hugant MD
 *
 * @see Starclipse.common.Timer
 * @see Starclipse.common.Subject
 * @see Starclipse.common.Resources
 * @see Starclipse.building.House
 */
public class Building {
	private String name = "";
	private String status = "";
	
	private Timer buildTimer = null;
	private Timer incomeTimer = null;
	
	private Subject residents = null;
	private int level = 0;
	private float k = 0.0f;
	
	private Resources income = null;
	private Resources expenses = null;
	
	private boolean start = false;
	
	/**
	 * Begins to build the <b>Building</b>.
	 */
	public void build() {
		if (buildTimer != null) {
			buildTimer.start();
		}
	}
	
	/**
	 * Starts work in the <b>Building</b>.
	 */
	public void startWork() {
		if (incomeTimer != null) {
			incomeTimer.start();
			start = true;
		}
	}
	
	
	/**
	 * Return the <b>Resources</b> which was extracted.
	 * @return income is <b>Resources</b> which was extracted
	 */
	public Resources claim() {
		if (incomeTimer != null) {
			incomeTimer.start();
		}
		return income;
	}
	
	public void upgrade() {
		this.residents.addToMaxValue("");
		this.expenses = expenses.multiply("");
		this.income = income.multiply(level * k + "");
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
	 * @return expenses is a <b>Resources</b> which are necessary for the
	 * construction
	 */
	public Resources getExpenses() {
		return expenses;
	}
	
	/**
	 * Return the maximum number of residents.
	 * @return maxResidents is maximum number of residents
	 */
	public String getMaxResidents() {
		return residents.getMaxValue();
	}
	
	/**
	 * Return the current number of residents.
	 * @return residents is number of residents
	 */
	public String getResidents() {
		return residents.getNumber();
	}
	
	/**
	 * Return status of the timer. If timer is work, then 
	 * will return time. Otherwise return <b>String</b> "Start" or "Claim".
	 * @return time or "Start" or "Claim"
	 * 
	 * @see Starclipse.common.Timer
	 */
	public String getStatus() {
		if (buildTimer != null && incomeTimer != null) {
			if (((buildTimer.isWork() || incomeTimer.isWork()) || !incomeTimer.isWork()) && start) {
				return incomeTimer.toString();
			}
			return buildTimer.toString();
		}
		return "";
	}
	
	
	/**
	 * Sets the name of <b>Building</b>.
	 * @param name is name of <b>Building</b>
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the build <b>Timer</b> of <b>Building</b>.
	 * @param buildTime is the <b>Timer</b> for which the 
	 * <b>Building</b> will be build.
	 */
	public void setBuildTimer(Timer buildTime) {
		this.buildTimer = buildTime;
	}

	/**
	 * Sets the build <b>Timer</b> of <b>Building</b>.
	 * @param duration is duration of timer
	 * @param phrase is phrase which will return
	 */
	public void setBuildTimer(Long duration, String phrase) {
		this.buildTimer = new Timer(duration, phrase);
	}
	
	/**
	 * Sets the income <b>Timer</b> of <b>Building</b>.
	 * @param incomeTime is the <b>Timer</b> for which will be
	 * received income
	 */
	public void setIncomeTimer(Timer incomeTime) {
		this.incomeTimer = incomeTime;
	}
	
	/**
	 * Sets the build <b>Timer</b> of <b>Building</b>.
	 * @param duration is duration of timer
	 * @param phrase is phrase which will return
	 */
	public void setIncomeTimer(Long duration, String phrase) {
		this.incomeTimer = new Timer(duration, phrase);
	}

	/**
	 * Sets the number of residents.
	 * @param residents is number of residents
	 */
	public void setResidents(String currentResidents, String maximalResidents) {
		this.residents = new Subject(Subject.RESIDENTS, currentResidents, maximalResidents);
	}

	/**
	 * Sets the income <b>Resources</b>.
	 * @param income is <b>Resources</b> which will be obtained
	 */
	public void setIncome(Resources income) {
		this.income = income;
	}

	/**
	 * Sets the expenses which are necessary for the
	 * construction of this <b>Building</b>.
	 * @param expenses is <b>Resources</b> which are necessary for the
	 * construction of this <b>Building</b>
	 */
	public void setExpenses(Resources expenses) {
		this.expenses = expenses;
	}
}
