package starclipse.building.industry;

import starclipse.building.Resources;

public class ResourcesFactory {
	final private static String[] NAMES = new String[]{"tree", "stone", "coal", "iron", "gold", "energy", "water",
													   "oxygen", "food"};
	private String name = "";
	private Resources expenses = null;
	
	public ResourcesFactory(String name) {
		for(String i : NAMES) {
			if(i.equals(name)) {
				this.name = name;
				break;
			}
		}
		
		if(this.name.equals("")) {
			//throw "FUCK";
		}
	}
}