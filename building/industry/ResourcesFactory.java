package starclipse.building.industry;

import starclipse.common.Resources;
import starclipse.common.Subject;
import starclipse.common.Timer;
import starclipse.common.ScaleNumber;

public class ResourcesFactory extends starclipse.building.Building {
	final private static String[] NAMES = {Subject.TREE, Subject.STONE, Subject.COAL, Subject.IRON, 
			Subject.GOLD, Subject.ENERGY, Subject.WATER, Subject.OXYGEN, Subject.FOOD, Subject.SOIL};
	
	private Resources expenses = new Resources();
	
	public ResourcesFactory(String... cells) {
		if (cells.length == 5) {
			for (String i : cells) {
				switch (i) {
					case Subject.TREE:
						expenses.add(new Resources(	Subject.SOIL, 	"",
													Subject.WATER, 	"",
													Subject.OXYGEN, "",
													Subject.MONEY, 	""));
						super.setIncome(new Resources(Subject.TREE,	""));
						break;
					
					case Subject.STONE:
						expenses.add(new Resources(	Subject.SOIL,	"",
													Subject.TREE,	"",
													Subject.MONEY,	""));
						break;
						
					case Subject.COAL:
						expenses.add(new Resources(	Subject.STONE,	"",
													Subject.WATER,	"",
													Subject.MONEY,	""));
						break;
						
					case Subject.IRON:
						expenses.add(new Resources(	Subject.STONE,	"",
													Subject.MONEY,	""));
						break;
						
					case Subject.GOLD:
						expenses.add(new Resources());
						break;
						
					case Subject.ENERGY:
						expenses.add(new Resources());
						break;
						
					case Subject.WATER:
						expenses.add(new Resources());
						break;
						
					case Subject.OXYGEN:
						expenses.add(new Resources());
						break;
						
					case Subject.FOOD:
						expenses.add(new Resources());
						break;
						
					case Subject.SOIL:
						expenses.add(new Resources(	Subject.STONE, 	"",
													Subject.WATER,	"",
													Subject.OXYGEN,	"",
													Subject.MONEY,	""));
						break;
						
					default:
						throw new IllegalArgumentException("Such a resource does not exist");
				}
				
				super.setName(i.substring(0, 1).toUpperCase() + i.substring(1).toLowerCase() + " Factory");
			}
		} else {
			throw new IllegalArgumentException("The amount of cells must equal 5");
		}
	}
}
