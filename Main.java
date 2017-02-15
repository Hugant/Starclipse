package Starclipse;

import java.math.BigDecimal;
import Starclipse.Building.StarshipsFactory.*;
import Starclipse.LimitlessNumber;

public class Main{
	public static void main(String args[]) {
		//Starship a = new Starship("Hugant Starship", new Cost("tree", "stone", "money", "oxygen", "gold"),
		//						  "damage", "damage", "speed", "passenger", "cost");
		
		/*Subject b = new Subject("", "");
		System.out.println("number: " + b.getNumber());
		System.out.println("maxValue: " + b.getMaxValue());
		System.out.println("name: " + b.getName());*/
		//b.minus("100K");
		//b.add("1230.1");
		//b.add("213GaT");
		//b.minus("100.1200GaJ");
		//System.out.println(100.123 - 100.12);
		//BigDecimal a = new BigDecimal("123.100001");
		//BigDecimal b = new BigDecimal("123.100000");

		//System.out.println(a.subtract(b).toString());
		
		//a.add("1.123GaV");
		Subject b = new Subject("a", "121B", "100T");
		Subject c = new Subject("a", "100B", "100T");
		b.add(c);
		
		System.out.println(b.getNumber());
		System.out.println(c.getNumber());
	}
}