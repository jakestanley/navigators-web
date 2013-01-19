package ships;

import java.util.ArrayList;
import ships.Weapon;

public class Ship {
	
	// this class creates a ship as per the passed type parameter
	
	int shipID;
	
	String shipName;
	ArrayList<Weapon> weaponslist = new ArrayList<Weapon>();
	
	int shipType; // ship size is 1:2 width to length (for now) - effects amount of possible chambers
	int shieldType;
	int engineType;
	int generatorType;
	int powerRegenRate;
	int shieldDrainRate;
	int weaponHardPoints;
	
	boolean sheildOn;
	
	double maxWeight; // weight measured in metric tons
	double stockWeight = 0;
	double currentWeight;
	
	public Ship(int id, String name, int type) {
		
		shipID = id;
		shipName = name;
		
		if(type == 0) {
		// small ship
		stockWeight = 3000;
		maxWeight = 4500;
			
		} else if (type == 1) {
		// medium ship	
		stockWeight = 15000;
		maxWeight = 22500;
		
		} else if (type == 2) {
		// large ship
		stockWeight = 50000;
		maxWeight = 75000;
		}
		
		currentWeight = stockWeight;
			
	} 
	
	public String returnShipStats() {
		String stats;
		stats = "Ship name: " + shipName + ", ";
		stats += Integer.toString(shipID);
		stats += " ship stock weight: " + stockWeight + ", ";
		stats += " ship max weight: " + maxWeight + ", ";
		stats += "max weapon hardpoints: ?" + weaponslist.size(); // TODO
		
		return stats;
		// TODO for testing purposes only
		
		
	}
	
	
	
	public String getShipType() {
		String type = "Unknown";
		if(shipType == 0) {
			type = "Small";
		} else if(shipType == 1) {
			type = "Medium";
		} else if(shipType == 2) {
			type = "Large";
		}
		
		return type;
		
	}

	
}
