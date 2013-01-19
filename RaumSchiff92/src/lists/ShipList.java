package lists;

import java.util.ArrayList;
import lists.ChamberList;

import java.util.Scanner;

import classes.Ship;

public class ShipList extends ArrayList {

	public static ArrayList<Ship> shiplist = new ArrayList<Ship>();
	public static ChamberList chamberlist = new ChamberList();
	int shipID;


	public ShipList(){

		shipID = 0;

	}

	// make this better and neater and shit. it looks ugly as fuck at the moment
	public void createPlayerShip() {
		String name = null;
		int size = 0;
		System.out.println("Creating player ship...");
		Scanner namescan = new Scanner(System.in);
		System.out.println("Please enter a ship name: ");
		name = namescan.nextLine();
		System.out.println("There are two starter ships: ");
		System.out.println("1: Small fighter");
		System.out.println("2: Small transport");
		// the starting ship can be a fighter ship, a small transport ship
		// ship classes are currently meaningless - 23.9.2012
		// when buildShip command is expanded upon, different ships will be created based on this choice
		Scanner sizescan = new Scanner(System.in);
		do {
			System.out.print("Please enter a number: ");
			if(sizescan.hasNextInt()) size = sizescan.nextInt();
			else sizescan.next();
		} while (size < 1 || size > 2);
		// ship will start with a balance 100,000 i don't know how much shit will cost right now - 23.9.12
		if(size == 1) {
			System.out.println("Building small fighter ship...");
			shiplist.add(shipID, new Ship(shipID, name, 1, true, false, 0, 0, false, true, false, 100, 100000, false, false, false, false, true, false, false, true));		
			chamberlist.setupShipChambers(shipID, 1, 100, 100, 2, 100, 1000, 100000, 10, 20, 100, 10, 2, 2000, 2, 2000, 1, 30, 2); // dual 30 power type 1 guns
		}
		else if(size == 2) {
			System.out.println("Building small transport ship...");
			// also has a weapon room, but the weapon has half the strength of the fighter ship's weapon
			shiplist.add(shipID, new Ship(shipID, name, 1, true, false, 0, 0, false, true, false, 100, 100000, true, false, false, false, true, false, false, true));
			chamberlist.setupShipChambers(shipID, 1, 100, 500, 2, 100, 1000, 100000, 10, 20, 100, 10, 2, 2000, 2, 2000, 1, 20, 1); // single 20 power type 1 gun
		}
		printDetailedShipInfo(shipID);
		shipID++;

	}

	// need a way to search ships by ship name.
	// in multiplayer, each ship MUST have a UNIQUE name

	// cash could be made viewable to player only
	// or could just make cash not viewable at all
	// through the printShipInfo method
	// less information will be displayed if 'hostile' is true
	// duhh

	// public void printDetailedShipInfo will be available to the player

	public void printShipInfo(int id) {
		System.out.println("Printing available ship information...");
		System.out.println("Ship name: " + shiplist.get(id).shipName);
		System.out.println("Ship size: " + shiplist.get(id).shipSize);
		System.out.println("Ship is in sector " + shiplist.get(id).shipSectorLocation);

		// TODO change the ship hull level thingy so it reads "?/100" if the ship has 
		// been encountered, but it's current hull health is unknown
		// if the probing ship is near the probee, then the current hull 
		// level will be visible

		System.out.println("Ship hull level: " + shiplist.get(id).hullLevel + "/" + shiplist.get(id).maxHull);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

	}

	// TODO remove unnecessary shit

	public void printDetailedShipInfo(int id) {
		System.out.println("Printing available ship information...");
		System.out.println("Ship name: " + shiplist.get(id).shipName);
		System.out.println("Ship size: " + shiplist.get(id).shipSize);
		getShipLocation(id, true);
		System.out.println("Ship hull level: " + shiplist.get(id).hullLevel + "/" + shiplist.get(id).maxHull);
		getShieldInformation(id);
		getCargoInformation(id);
		getCryoInformation(id);
		getMedicalInformation(id);
		getTeleportersInformation(id);
		getWarpRoomInformation(id);
		getWeaponRoomInformation(id);

	}

	// TODO put these in some kind of order

	public void getShipLocation(int id, boolean detailed){
		if(detailed == false){
		System.out.println("Ship is in sector " + shiplist.get(id).shipSectorLocation);
		}
		else if(detailed == true){
			System.out.println("Ship is in sector " + shiplist.get(id).shipSectorLocation);
			getDetailedShipLocation(id, shiplist.get(id).shipPlanetLocation);
		}
	}
	
	private void getWeaponRoomInformation(int id) {
		if(shiplist.get(id).hasWeaponRoom = true){
			System.out.println("Ship is armed with " + ChamberList.weaponroomlist.get(id).weaponAmount 
					+ " type " + ChamberList.weaponroomlist.get(id).weaponType + 
					", strength " + ChamberList.weaponroomlist.get(id).weaponStrength + 
					" weapon(s)");
		}
	}

	private void getWarpRoomInformation(int id) {
		if(shiplist.get(id).hasWarpRoom = true){
			System.out.println("Ship has a warp drive with a range of " 
					+ ChamberList.warproomlist.get(id).warpRange + " and uses " + 
					ChamberList.warproomlist.get(id).warpUsage + " fuel");
		}
	}

	private void getTeleportersInformation(int id) {
		if(shiplist.get(id).hasTeleporters = true){
			System.out.println("Ship teleporter has a range of " 
					+ ChamberList.teleporterslist.get(id).teleporterRange 
					+ " and can transport up to " 
					+ ChamberList.teleporterslist.get(id).teleporterCapacity 
					+ " crew members at once");
		}
	}

	private void getMedicalInformation(int id) {
		if(shiplist.get(id).hasMedicalBay = true){
			System.out.println("Ship has a medical bay");
		}
	}

	private void getCryoInformation(int id) {
		if(shiplist.get(id).hasCryo = true){
			System.out.println("Ship has " + ChamberList.cryolist.get(id).availableChambers + "/" + ChamberList.cryolist.get(id).cryoCapacity);
		}
	}

	private void getCargoInformation(int id) {
		if(shiplist.get(id).hasCargoHold = true){
			System.out.println("Cargo hold: " + 
					ChamberList.cargoholdlist.get(id).availableCargoSpace 
					+ "/" + ChamberList.cargoholdlist.get(id).maxCargoSize);
		}
	}

	public void getDetailedShipLocation(int id, int planet) {
		if(shiplist.get(id).isInOrbit = true){
			System.out.println("Ship is in orbit around planet " + planet);
		}
		else if(shiplist.get(id).isLanded = true){
			System.out.println("Ship is landed on planet " + planet);
		}
		else if(shiplist.get(id).isNear = true){
			// soon it will say the distance
			System.out.println("Ship is near planet " + planet);
		}
	}

	public void getShieldInformation(int id){
		// shield generator display stuff
		if(shiplist.get(id).hasShieldGenerator = true){
			System.out.println("Ship shield level: " + ChamberList.shieldgeneratorlist.get(id).shieldLevel + "/" + ChamberList.shieldgeneratorlist.get(id).shieldMax);
			System.out.println("Shield recharge rate: " + ChamberList.shieldgeneratorlist.get(id).shieldStrength);
			System.out.println("Shield strength: " + ChamberList.shieldgeneratorlist.get(id).regenerationRate);
		}
	}
	
	
	}





