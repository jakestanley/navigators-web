package ships;

/**
 * Coolant can be distributed throughout the ship to components.
 * A ship's components and crew are attached to the unique shipID.
 * The shipID MUST be unique, or horrible shit will happen.
 */

import java.util.ArrayList;
import ships.Weapon;

// arraylist of ships needs to be made

public class Ship {
	
	int shipID, coolant;
	
	String shipName;
	
	int shipType; // ship size is 1:2 width to length (for now) - effects amount of possible chambers
	int shieldType;
	int engineType;
	int generatorType;
	int powerRegenRate;
	int shieldDrainRate;
	int weaponHardPoints;
	int yearLaunched;
	float shipX, shipY, shipZ;
	
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
