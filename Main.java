package Starclipse;

import java.math.BigDecimal;
import Starclipse.Building.StarshipsFactory.*;
import Starclipse.LimitlessNumber;
import Starclipse.Building.Resources;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

public class Main{
	public static void main(String args[]) {
		//Resources a = new Resources(new LimitlessNumber("100M"), "iron", "gold", "coal", "gold");
//		Resources a = new Resources("stone",  "100", 
//								    "tree",   "50", 
//								    "money",  "1000", 
//								    "iron",   "10",  
//								    "water",  "10", 
//								    "energy", "10"  );
//		a.add(new Subject("iron", "100B"));
//		System.out.println(a.get("iron"));
		
//		Calendar start = new GregorianCalendar();
//		Calendar buildingTime = new GregorianCalendar(0, 0, 1, 0, 10, 10);
//		
//		System.out.println(buildingTime.getTime());
//		System.out.println(start.getTime());
//		
//		start.add(Calendar.DAY_OF_MONTH, buildingTime.get(Calendar.DAY_OF_MONTH));
//		start.add(Calendar.HOUR_OF_DAY, buildingTime.get(Calendar.HOUR_OF_DAY));
//		start.add(Calendar.MINUTE, buildingTime.get(Calendar.MINUTE));
//		start.add(Calendar.SECOND, buildingTime.get(Calendar.SECOND));
//		
//		Calendar end = new GregorianCalendar(0, 0, start.get(Calendar.MONTH), start.get(Calendar.HOUR_OF_DAY), start.get(Calendar.MINUTE), start.get(Calendar.SECOND));
//		
//		System.out.println(end.getTime());
		
		Date a = new Date();
		Date b = new Date(10000);
		
		long end = a.getTime() + b.getTime();
		Date c = new Date(end);
		System.out.println(b.toString());
		System.out.println(a.toString());
		System.out.println(c.toString());
		
		
	}
}