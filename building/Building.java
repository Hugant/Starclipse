package starclipse.building;

public interface Building {
	String name = "";
	
	starclipse.common.Timer buildTime = null;
	starclipse.common.Timer incomeTime = null;
	
	Resources expenses = null;
	
	int residents = 0;
	int maxResidents = 0;
	
	public void build();
	
	public void startWork();
	
	public starclipse.common.Subject claim();
	
}
