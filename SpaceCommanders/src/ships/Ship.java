package ships;

import begin.Game;
import tools.Coordinate;

/**
 * Coolant can be distributed throughout the ship to components.
 * A ship's components and crew are attached to the unique shipID.
 * The shipID MUST be unique, or horrible shit will happen.
 */

public class Ship {
	
	int shipID, availableCoolant;
	Coordinate location;
	Weapon shipWeapon;
	Reactor shipReactor;
	
	String shipName;
	
	public Ship(int id, String name, Coordinate loc) {
		
		shipWeapon = new Weapon();
		shipReactor = new Reactor();
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
			success =  true;
		}
		return success;
	}
	
	public boolean receiveCoolant(){
		boolean success = false; 
		if(canReceiveCoolant()){
			availableCoolant = availableCoolant + 5;
			success =  true;
		}
		return success;
	}
	
	public int getShipID(){
		return this.shipID;
	}
	
	public void printAllShipInfo(){
		System.out.println("Name: " + getShipName());
		System.out.println("Location: " + location.get3DCoordinateAsString());
		System.out.println(shipReactor.getUsage());
	}
	
}
