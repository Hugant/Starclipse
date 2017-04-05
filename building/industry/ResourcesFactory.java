package starclipse.building.industry;

import starclipse.common.Resources;

public class ResourcesFactory {
	final private static String[] NAMES = new String[]{"tree", "stone", "coal", "iron", "gold", "energy", "water",
													   "oxygen", "food"};
	private String name = "";
	private Resources expenses = new Resources();
	
	public ResourcesFactory(String... cells) {
		if (cells.length == 5) {
			for (String i : cells) {
				expenses.add(res);
			}
		} else {
			//throw new Exception();
		}
	}
}
