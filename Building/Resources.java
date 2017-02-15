package Starclipse.Building;

import Starclipse.Subject;
import java.util.ArrayList;

public class Resources {
	private Subject tree = new Subject("tree", "0");
	private Subject iron = new Subject("iron", "0");
	private Subject gold = new Subject("gold", "0");
	private Subject energy = new Subject("energy", "0");
	private Subject water = new Subject("water", "0");
	private Subject oxygen = new Subject("oxygen", "0");
	private Subject coal = new Subject("coal", "0");
	private Subject stone = new Subject("stone", "0");
	private Subject food = new Subject("food", "0");
	private Subject money = new Subject("money", "0");
	
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	//building time 
	//
	
	public Resources(String volume, String... res) {
		for(String i : res) { 
			for(Subject subject : subjects) {
				if(subject.getName().equals(i)) {
					subject.setMaxValue(subject.getMaxValue())
				}
			}
		}
		
		for(String i : res) {
			if(!subjects.contains(i)) {
				subjects.add(new Subject(i, "0", volume));
			} else {
				Subject a = subjects.get(subjects.indexOf(i));
				a.add(volume);
				subjects.set(subjects.indexOf(i), a);
			}
		}
		for(String i : res) {
			this.addStorage(i.toLowerCase(), volume);
		}
	}
	
	public Resources(String... res) {
		if(res.length % 2 != 0) {
			throw new IllegalArgumentException("The number of array elements must be even");
		} else {
			for(int i = 0; i < res.length; i += 2) {
				this.expenses(res[i].toLowerCase(), res[i + 1]);
			}
		}
		
	}
	
	private void addStorage(String res, int volume) {
		switch(res) {
			case "tree":
				this.tree.setMaxValue(Integer.parseInt(this.tree.getMaxValue().toString()) + volume); 
				break;
			case "iron":
				this.iron.setMaxValue(Integer.parseInt(this.iron.getMaxValue().toString()) + volume); 
				break;
			case "gold":
				this.gold.setMaxValue(Integer.parseInt(this.gold.getMaxValue().toString()) + volume); 
				break;
			case "energy":
				this.energy.setMaxValue(Integer.parseInt(this.energy.getMaxValue().toString()) + volume); 
				break;			
			case "water":
				this.water.setMaxValue(Integer.parseInt(this.water.getMaxValue().toString()) + volume); 
				break;
			case "oxygen":
				this.oxygen.setMaxValue(Integer.parseInt(this.oxygen.getMaxValue().toString()) + volume); 
				break;
			case "coal":
				this.coal.setMaxValue(Integer.parseInt(this.coal.getMaxValue().toString()) + volume); 
				break;
			case "stone":
				this.stone.setMaxValue(Integer.parseInt(this.stone.getMaxValue().toString()) + volume); 
				break;
			case "food":
				this.food.setMaxValue(Integer.parseInt(this.food.getMaxValue().toString()) + volume); 
				break;
			case "money":
				this.money.setMaxValue(Integer.parseInt(this.money.getMaxValue().toString()) + volume); 
				break;
			default:
				throw new UnsupportedOperationException("Such a resource does not exist");
		}
	}
	
	public String get(String res) {
		switch(res) {
			case "tree":   return this.tree.getNumber();
			case "iron":   return this.iron.getNumber();
			case "gold":   return this.gold.getNumber();
			case "energy": return this.energy.getNumber();
			case "water":  return this.water.getNumber();
			case "oxygen": return this.oxygen.getNumber();
			case "coal":   return this.coal.getNumber();	
			case "stone":  return this.stone.getNumber();
			case "food":   return this.food.getNumber();
			case "money":  return this.money.getNumber();
			default:
				throw new UnsupportedOperationException("Such a resource does not exist");
		}
	}
	
	/*public int addResource(String res, int volume) {
		switch(res) {
			case "tree":   return tree;
			case "iron":   return iron;
			case "gold":   return gold;
			case "energy": return energy;
			case "water":  return water;
			case "oxygen": return oxygen;
			case "coal":   return coal;	
			case "stone":  return stone;
			case "food":   return food;
			case "money":  return money;
			default:
				throw new UnsupportedOperationException("Such a resource does not exist");
		}
	}*/
	
	private void expenses(String res, String volume) {
		switch(res) {
			case "tree":   this.tree.add(volume);   break;
			case "iron":   this.iron.add(volume);   break;
			case "gold":   this.gold.add(volume);   break;
			case "energy": this.energy.add(volume); break;
			case "water":  this.water.add(volume);  break;
			case "oxygen": this.oxygen.add(volume); break;
			case "coal":   this.coal.add(volume);   break;	
			case "stone":  this.stone.add(volume);  break;
			case "food":   this.food.add(volume);   break;
			case "money":  this.food.add(volume);   break;
			default:
				throw new UnsupportedOperationException("Such a resource does not exist");
		}
	}
	
	/*public void get() {
		System.out.println("t = " + this.sTree);
		System.out.println("i = " + this.sIron);
		System.out.println("g = " + this.sGold);
		System.out.println("e = " + this.sEnergy);
		System.out.println("w = " + this.sWater);
		System.out.println("o = " + this.sOxygen);
		System.out.println("c = " + this.sCoal);
		System.out.println("s = " + this.sStone);
		System.out.println("f = " + this.sFood);
		System.out.println("m = " + this.sMoney);
	}*/
}
