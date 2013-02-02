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
		
		availableCoolant = 100;
		location = loc;
		shipID = id;
		shipName = name;

	}
	
	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public Coordinate getLocation(){
		return this.location;
	}
	
	public void setLocation(Coordinate location) {
		this.location = location;
	}

	public int getAvailableCoolant(){
		return this.availableCoolant;
	}
	
	public boolean canReleaseCoolant(){
		boolean canRelease = false;
		if(getAvailableCoolant() > 0){
			canRelease = true;
		}
		return canRelease;
	}
	
	public boolean canReceiveCoolant(){
		boolean canReceive = false;
		if(getAvailableCoolant() < 100){
			canReceive = true;
		}
		return canReceive;
	}
	
	public boolean releaseCoolant(){
		boolean success = false; 
		if(canReleaseCoolant()){
			availableCoolant = availableCoolant - 5; 
		}
		return success;
	}
	
	public boolean receiveCoolant(){
		boolean success = false; 
		if(canReceiveCoolant()){
			availableCoolant = availableCoolant + 5; 
		}
		return success;
	}
	
}
