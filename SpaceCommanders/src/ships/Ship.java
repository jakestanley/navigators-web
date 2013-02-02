package ships;

import tools.Coordinate;

/**
 * Coolant can be distributed throughout the ship to components.
 * A ship's components and crew are attached to the unique shipID.
 * The shipID MUST be unique, or horrible shit will happen.
 */

public class Ship {
	
	// use a system similar to that of the Reactor power distribution system to distribute coolant
	
	int shipID, availableCoolant;
	Coordinate location;
	
	String shipName;
	
	public Ship(int id, String name, int type, Coordinate loc) {
		
		location = loc;
		shipID = id;
		shipName = name;

	}
	
	public Coordinate getLocation(){
		return this.location;
	}
	
}
