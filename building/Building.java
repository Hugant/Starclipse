package starclipse.building;

public interface Building {
	String name = "";
	
	starclipse.common.Timer buildTime = null;
	starclipse.common.Timer incomeTime = null;
	
	starclipse.common.Subject residents = null;
	
	Resources expenses = null;
	
	public void build();
	
	public void startWork();
	
	public starclipse.common.Subject claim();
	
}
