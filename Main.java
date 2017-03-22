package starclipse;

import java.math.BigDecimal;

import starclipse.common.LimitlessNumber;
import starclipse.common.Resources;
import starclipse.common.Timer;
import starclipse.building.industry.Starship;
import starclipse.building.House;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import starclipse.common.Subject;

public class Main{
	public static void main(String args[]) {
		House a = new House("big");
		a.build();
		String c = "";
		while(true) {
			c = a.getStatus();
			System.out.println(c);
			if (c.equals("Start")) {
				a.startWork();
			}
			if(c.equals("Claim")) {
				//new java.util.Scanner(System.in).nextLine();
				a.claim();
			}
			try {
				Thread.sleep(1000);
			} catch(Exception e) {}
		}
		
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