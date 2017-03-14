package starclipse;

import java.math.BigDecimal;

import starclipse.common.LimitlessNumber;
import starclipse.common.Timer;
import starclipse.building.house.House;
import starclipse.building.Resources;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import starclipse.common.Subject;

public class Main{
	public static void main(String args[]) {
			
		House a = new House("small");
		a.build();
		while(true) {
			if(a.getStatus().equals("Claim")) {
				a.claim();
				try {
					Thread.sleep(1000);
				} catch(Exception e) {}
			}
		}
	}
}