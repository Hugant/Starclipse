package starclipse;

import java.util.ArrayList;
import starclipse.building.*;
import starclipse.common.ScaleNumber;
import starclipse.common.Subject;

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
