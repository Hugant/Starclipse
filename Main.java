package starclipse;

import java.math.BigDecimal;

import starclipse.common.LimitlessNumber;
import starclipse.common.Timer;
import starclipse.building.house.House;
import starclipse.building.industry.Starship;
import starclipse.building.Resources;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import starclipse.common.Subject;

public class Main{
	public static void main(String args[]) {
		String [] mas = {""};
		House a = new House("small");
		a.startWork();
		String c = "";
		while(true) {
			c = a.getStatus();
			System.out.println(c);
			if(c.equals("End Work")) {
				//new java.util.Scanner(System.in).nextLine();
				a.claim();
			}
			try {
				Thread.sleep(500);
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