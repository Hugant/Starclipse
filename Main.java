package starclipse;

import java.math.BigDecimal;

import starclipse.common.ScaleNumber;
import starclipse.common.Resources;
import starclipse.common.Timer;
import starclipse.building.industry.Starship;
import starclipse.building.House;
import starclipse.building.Warehouse;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import starclipse.common.Subject;

public class Main{
	public static void main(String args[]) {
		
		ScaleNumber a = new ScaleNumber("1M");
		System.out.println(a.divide("10K"));
//		while(true) {
//			try {
//				System.out.println(a.multiply("1K"));
//				Thread.sleep(100);
//			} catch(Exception e) {}
//		}
//		Resources a = new Resources(Subject.GOLD, "100", Subject.IRON, "40");
//		System.out.println(a.divide("10").get(Subject.GOLD));
//		System.out.println(a.get(Subject.IRON));
//		Subject a = new Subject(Subject.GOLD, "100", "200");
//		Subject b = new Subject(Subject.GOLD, "2.5");
//		System.out.println(a.multiply(b).getNumber());
		//System.out.println(Subject.TREE.substring(0, 1).toUpperCase() + Subject.TREE.substring(1) + " Factory");
//		Starship a = new Starship("Hugant", new Resources(new ScaleNumber("2K"), "gold", "gold", "oxygen", "water", "stone"), "damage", "speed", "damage", "passenger", "storage");
//		System.out.println(Arrays.asList(a.getExpenses().asTypeArray()));
//		System.out.println(a.getExpenses().get("iron"));
//		System.out.println(a.getExpenses().get("energy"));
//		System.out.println(a.getExpenses().get("oxygen"));
//		System.out.println(a.getExpenses().get("food"));
//		ScaleNumber a = new ScaleNumber("1M");
//		a.divide("0.1");
//		System.out.println(a);
//		
//		Resources a = new Resources();
//		Resources b = new Resources();
//		System.out.println(a.hashCode());
//		System.out.println(b.hashCode());
//		Subject a = new Subject("gold", "10");
//		System.out.println(a);
//		a.fill();
//		System.out.println(a);
//		System.out.println("Test");
//		Building a = new House("small");
//		a.build();
//		
//		
//		String c = "";
//		while(true) {
//			c = a.getStatus();
//			System.out.println(c);
//			if (c.equals("Start")) {
//				a.startWork();
//			}
//			if(c.equals("Claim")) {
//				//new java.util.Scanner(System.in).nextLine();
//				a.claim();
//			}
//			try {
//				Thread.sleep(1000);
//			} catch(Exception e) {}
//			for(int i = 0; i < 10; i++) {
//				System.out.println();
//			}
//		}
//		
//		Resources a = new Resources(new LimitlessNumber("100"), "gold", "oxygen", "gold");
//		Starship b = new Starship("Hugant", a);
		//System.out.println(Arrays.asList(a.asTypeArray()));
		
//		Starship a = new Starship("", new Resources(new LimitlessNumber("100M"), "gold", "iron", "oxygen", "coal", "energy"), 
//				"damage","speed", "storage", "speed", "damage");
//		
////		Starship a = new Starship("Hugant", null, "speed", "speed", "damage", "damage", "passenger");
//		
//		System.out.println(a.getName());
//		System.out.println("damage: " + a.getDamage());
//		System.out.println("speed: " + a.getSpeed());
//		System.out.println("passenger: " + a.getPassenger());
	}
}