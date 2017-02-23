package Starclipse;

import java.math.BigDecimal;
import Starclipse.Building.StarshipsFactory.*;
import Starclipse.LimitlessNumber;
import Starclipse.Building.Resources;

public class Main{
	public static void main(String args[]) {
		Resources a = new Resources(new LimitlessNumber("100M"), "iron", "gold", "coal", "gold");
//		Resources a = new Resources("stone",  "100", 
//								    "tree",   "50", 
//								    "money",  "1000", 
//								    "iron",   "10",  
//								    "water",  "10", 
//								    "energy", "10"  );
		a.add(new Subject("iron", "100B"));
		a.get();
		a.minus(new Subject("gold", "1"));
		a.minus(new Subject("iron", "40M"));
		a.get();
	}
}