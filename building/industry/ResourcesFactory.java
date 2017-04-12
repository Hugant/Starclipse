package starclipse.building.industry;

import starclipse.common.Resources;
import starclipse.common.Subject;
import starclipse.common.Timer;
import starclipse.common.ScaleNumber;

public class ResourcesFactory extends starclipse.Building {
	private static final ScaleNumber INCOME_PER_RESIDENT = new ScaleNumber("10");
	
	public ResourcesFactory(String type) {
		Resources expenses = new Resources();
		
		switch (type) {
			case Subject.TREE:
				expenses.add(new Resources(	Subject.SOIL, 	"",
											Subject.WATER, 	"",
											Subject.OXYGEN, "",
											Subject.MONEY, 	""));
				super.setIncome(new Resources(
					Subject.TREE, new ScaleNumber(super.getResidents()).multiply(INCOME_PER_RESIDENT).toString()));
				break;
			
			case Subject.STONE:
				expenses.add(new Resources(	Subject.SOIL,	"",
											Subject.TREE,	"",
											Subject.MONEY,	""));
				super.setIncome(new Resources(
						Subject.STONE, new ScaleNumber(super.getResidents()).multiply(INCOME_PER_RESIDENT).toString()));
				break;
				
			case Subject.COAL:
				expenses.add(new Resources(	Subject.STONE,	"",
											Subject.WATER,	"",
											Subject.MONEY,	""));
				super.setIncome(new Resources(
						Subject.COAL, new ScaleNumber(super.getResidents()).multiply(INCOME_PER_RESIDENT).toString()));
				break;
				
			case Subject.IRON:
				expenses.add(new Resources(	Subject.STONE,	"",
											Subject.MONEY,	""));
				super.setIncome(new Resources(
						Subject.IRON, new ScaleNumber(super.getResidents()).multiply(INCOME_PER_RESIDENT).toString()));
				break;
				
			case Subject.GOLD:
				expenses.add(new Resources( Subject.STONE,	"",
											Subject.IRON,	"",
											Subject.MONEY,	""));
				super.setIncome(new Resources(
						Subject.GOLD, new ScaleNumber(super.getResidents()).multiply(INCOME_PER_RESIDENT).toString()));
				break;
				
			case Subject.ENERGY:
				expenses.add(new Resources(	Subject.OXYGEN,	"",
											Subject.WATER,	"",
											Subject.FOOD,	"",
											Subject.MONEY,	""));
				super.setIncome(new Resources(
						Subject.ENERGY, new ScaleNumber(super.getResidents()).multiply(INCOME_PER_RESIDENT).toString()));
				break;
				
			case Subject.WATER:
				expenses.add(new Resources(	Subject.OXYGEN,	"",
											Subject.SOIL,	"",
											Subject.MONEY,	""));
				super.setIncome(new Resources(
						Subject.WATER, new ScaleNumber(super.getResidents()).multiply(INCOME_PER_RESIDENT).toString()));
				break;
				
			case Subject.OXYGEN:
				expenses.add(new Resources(	Subject.WATER,	"",
											Subject.MONEY,	""));
				super.setIncome(new Resources(
						Subject.OXYGEN, new ScaleNumber(super.getResidents()).multiply(INCOME_PER_RESIDENT).toString()));
				break;
				
			case Subject.FOOD:
				expenses.add(new Resources(	Subject.SOIL,	"",
											Subject.MONEY,	""));
				super.setIncome(new Resources(
						Subject.FOOD, new ScaleNumber(super.getResidents()).multiply(INCOME_PER_RESIDENT).toString()));
				break;
				
			case Subject.SOIL:
				expenses.add(new Resources(	Subject.STONE, 	"",
											Subject.WATER,	"",
											Subject.OXYGEN,	"",
											Subject.MONEY,	""));
				super.setIncome(new Resources(
						Subject.SOIL, new ScaleNumber(super.getResidents()).multiply(INCOME_PER_RESIDENT).toString()));
				break;
				
			default:
				throw new IllegalArgumentException("Such a resource does not exist");
		}
		
		super.setName(type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase() + " Factory");
		super.setBuildTimer(Timer.DAY * 4, "Start");
		super.setIncomeTimer(Timer.DAY, "Claim");
		super.setResidents("0", "1K");
		super.setExpenses(expenses);
	}
}
