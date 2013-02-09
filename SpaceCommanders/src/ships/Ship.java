package ships;

import tools.Coordinate;

/**
 * Coolant can be distributed throughout the ship to components.
 * A ship's components and crew are attached to the unique shipID.
 * The shipID MUST be unique, or horrible shit will happen.
 */

public class Ship {

	int shipID, availableCoolant;
	boolean isShipOn;
	Coordinate location;
	Weapon shipWeapon;
	Reactor shipReactor;
	public String shipName;
	float shipHealth; // this is a temp testing variable

	public Ship(int id, String name, Coordinate loc) {

		shipWeapon = new Weapon(id);
		shipReactor = new Reactor(id);
		availableCoolant = 100;
		shipHealth = 100;
		location = loc;
		shipID = id;
		shipName = name;

	}	
	
	public void firedAt(float damage){ // temp method, please refine....
		shipHealth = shipHealth - damage;
	}

	public boolean togglePower(){ // Turning ship on enables auxiliary power.
		boolean success = false;
		if(isShipOn){
			boolean checkout = shipReactor.decreaseUsage(5);
			if(checkout){
				isShipOn = false;
				success = true;
			}
		} else {
			boolean checkout = shipReactor.increaseUsage(5);
			if(checkout){ // if the power is off, the ship is less likely to be detected
						  // if ship heat average is under 20, it is even less likely
				isShipOn = true;
				success = true;
			}
		}
		return success;
	}

	public boolean isShipOn(){ // checks if ship is actually powered.
		return isShipOn;
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

	// DEBUG AND TESTING METHODS

	public void printAllShipInfo(){
		System.out.println();
		System.out.println("Name: " + getShipName());
		System.out.println("Current coordinates: " + location.get3DCoordinateAsString());
		System.out.println();
		System.out.println("-- REACTOR INFO --");
		System.out.println("Current output: " + shipReactor.getUsage() + "%.");
		System.out.println("   DISTRIBUTION BREAKDOWN");
		//System.out.println("Auxiliary: " + shipReactor.getDistribution(0) + "%."); NEED TO MAKE THESE
		//System.out.println("Life support: " + shipReactor.getDistribution(1) + "%."); NEED TO MAKE THESE
		//System.out.println("Engine: " + shipReactor.getDistribution(2) + "%."); NEED TO MAKE THESE
		System.out.println("Weapon: " + shipWeapon.getPowerLevel() + "%.");
		System.out.println();
		System.out.println("-- WEAPON INFO --");
		System.out.println("Weapon status: " + shipWeapon.getWeaponStatus());
		System.out.println("Weapon configuration: " + shipWeapon.getWeaponConfiguration());
	}

}
