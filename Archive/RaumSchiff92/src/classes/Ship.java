package classes;

import lists.ShipList;

public class Ship {

	// ship identification information
	public int shipIdentifier;
	public String shipName;
	public int shipSize;
	public boolean isPlayerControlled;
	public boolean isHostile;

	// ship location variables below
	public int shipSectorLocation;
	public int shipPlanetLocation;
	public boolean isInOrbit;
	public boolean isLanded;
	public boolean isNear;

	// variables below are relative to ship status
	public int maxHull;
	public int hullLevel;
	public boolean isDestroyed;

	// optional chambers enabled in the ship object? these objects will be attached a ship object's shipID
	// or could they be disabled from within the chamber objects?
	/** they can be attached to a shipID and be invisible to the player if the 'hasXChamber' is false
	 this essentially renders them non-existent from the end user's point of view **/

	public boolean hasCargoHold; 
	public boolean hasComputerRoom; 
	public boolean hasCryo;
	public boolean hasMedicalBay; 
	public boolean hasShieldGenerator; 
	public boolean hasTeleporters; 
	public boolean hasWarpRoom;
	public boolean hasWeaponRoom;

	// miscellaneous
	private int balance;

	public Ship(int shipID, String name, int size, 
			boolean isPC, boolean hostile, int sector, 
			int planet, boolean orbit, boolean landed, 
			boolean near, int hull, int cash, 
			boolean cargoHold, boolean computerRoom, 
			boolean cryo, boolean medicalBay, 
			boolean shieldGenerator, boolean teleporters, 
			boolean warpRoom, boolean weaponRoom){

		shipIdentifier = shipID;
		shipName = name;
		shipSize = size;
		isPlayerControlled = isPC;
		isHostile = hostile;
		shipSectorLocation = sector;
		shipPlanetLocation = planet;
		isInOrbit = orbit;
		isLanded = landed;
		isNear = near;
		maxHull = hull;
		hullLevel = hull;
		isDestroyed = false;

		hasCargoHold = cargoHold; 
		hasComputerRoom = computerRoom; 
		hasCryo = cryo;
		hasMedicalBay = medicalBay; 
		hasShieldGenerator = shieldGenerator; 
		hasTeleporters = teleporters; 
		hasWarpRoom = warpRoom;
		hasWeaponRoom = weaponRoom;

		balance = cash;
	}
	public String getLandedStatus(){
		String stat = null;
		if(isLanded == true){
			stat = ("Landed on planet " + shipPlanetLocation);
		}
		else if(isInOrbit == true){
			stat = ("In Orbit around planet " + shipPlanetLocation);
		}
		else if(isNear == true){
			stat = ("Near planet " + shipPlanetLocation);
		}
		else{
			stat = "In Space";
		}
		return stat;
	}
	public void launchOrLandShip(){
		// TODO need something that checks that the ship can actually launch or land
		// if the engines are knackered for example, the ship cannot launch
		if(isLanded == true){
			isLanded = false;
			isInOrbit = true;
		}
		// before the below statement was just an 'if'. because they were both if statements, the bottom cancelled out the work of the top one
		// don't forget when it is and isn't appropriate to use else ifs in place of additional ifs
		else if(isInOrbit == true){
			isLanded = true;
			isInOrbit = false;
		}
	}
}
