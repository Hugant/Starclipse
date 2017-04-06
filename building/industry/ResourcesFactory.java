package starclipse.building.industry;

import starclipse.common.Resources;
import starclipse.common.Subject;

public class ResourcesFactory extends starclipse.building.Building {
	final private static String[] NAMES = {Subject.TREE, Subject.STONE, Subject.COAL, Subject.IRON, 
			Subject.GOLD, Subject.ENERGY, Subject.WATER, Subject.OXYGEN, Subject.FOOD, Subject.SOIL};
	
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
