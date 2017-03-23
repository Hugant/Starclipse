package starclipse;

import java.math.BigDecimal;

import starclipse.common.LimitlessNumber;
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
		Resources a = new Resources(new LimitlessNumber("100M"), "gold", "oxygen", "money", "people");
		System.out.println(a.get("gold"));
		System.out.println(a.get("oxygen"));
		System.out.println(a.get("money"));
		System.out.println(a.get("people"));
		a.fillToMax();
		System.out.println(a.get("gold"));
		System.out.println(a.get("oxygen"));
		System.out.println(a.get("money"));
		System.out.println(a.get("people"));
//		Subject a = new Subject("gold", "10");
//		System.out.println(a);
//		a.fill();
//		System.out.println(a);
//		House a = new House("small");
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