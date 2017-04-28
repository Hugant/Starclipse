package Starclipse;

import java.util.ArrayList;
import Starclipse.building.*;
import Starclipse.common.ScaleNumber;
import Starclipse.common.Subject;

public class Infrastructure {
	private ArrayList<Building> infrastructure;
	
	public Infrastructure() {
		infrastructure = new ArrayList<Building>();
	}
	
	public Building addBuilding(Building building) {
		this.infrastructure.add(building);
		return building;
	}
}
