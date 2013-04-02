package lists;

import java.util.ArrayList;

import chambers.*;

import lists.ShipList;

public class ChamberList extends ArrayList {

	public int shipID;

	public static ArrayList<BridgeRoom> bridgeroomlist = new ArrayList<BridgeRoom>();
	public static ArrayList<CargoHold> cargoholdlist = new ArrayList<CargoHold>();
	public static ArrayList<ComputerRoom> computerroomlist = new ArrayList<ComputerRoom>();
	public static ArrayList<Cryo> cryolist = new ArrayList<Cryo>();
	public static ArrayList<Docking> dockinglist = new ArrayList<Docking>();
	public static ArrayList<Engine> enginelist = new ArrayList<Engine>();
	public static ArrayList<EquipmentRoom> equipmentroomlist = new ArrayList<EquipmentRoom>();
	public static ArrayList<FuelTank> fueltanklist = new ArrayList<FuelTank>();
	public static ArrayList<LifeSupport> lifesupportlist = new ArrayList<LifeSupport>();
	public static ArrayList<MedicalBay> medicalbaylist = new ArrayList<MedicalBay>();
	public static ArrayList<ReactorChamber> reactorchamberlist = new ArrayList<ReactorChamber>();
	public static ArrayList<ShieldGenerator> shieldgeneratorlist = new ArrayList<ShieldGenerator>();
	public static ArrayList<Teleporters> teleporterslist = new ArrayList<Teleporters>();
	public static ArrayList<WarpRoom> warproomlist = new ArrayList<WarpRoom>();
	public static ArrayList<WeaponRoom> weaponroomlist = new ArrayList<WeaponRoom>();


	public ChamberList(){

	}

	// build ship takes arguments so that it knows what chambers to pre-build into each ship
	// program it to take ship class choice as an argument	
	
	// size is level
	
	public void setupShipChambers(int id, int size, int cargoHoldSize, 
			int computerSpeed, int cryoCapacity, int engineEfficiency, 
			int engineMax, int fuelCapacity, int lsCapacity, 
			int reactorCapacity, int shieldStrength, int regenRate, // percent per second
			int teleporterCapacity, int teleporterRange, int warpRange, // measured in sectors 
			int warpUsage, int weaponType, int weaponStrength,          // warp drive consumes a large amount of fuel and all reactor power - reactor needs to recover after a jump
			int weaponAmount){
		
		// engineEfficiency multiplied by engineSpeed = fuel consumption
		// what is engine speed measured in? default speed for start ship = 1000
		// lscapacity is how many crew members the life support can keep alive
		// this includes intruders. higher lscapacity than crew members means
		// oxygen returns faster, etc...increases effectiveness or whatever
		// 1 reactor output powers one part of the thingies
		
		shipID = id;
		// just worked out i can insert the new object at a specified point in the list, so i'll put it at shipID!!

		bridgeroomlist.add(shipID, (new BridgeRoom(size)));
		cargoholdlist.add(shipID, (new CargoHold(size, cargoHoldSize)));
		computerroomlist.add(shipID, (new ComputerRoom(size, computerSpeed)));
		cryolist.add(shipID, (new Cryo(size, cryoCapacity)));
		dockinglist.add(shipID, (new Docking(size)));
		enginelist.add(shipID, (new Engine(size, engineEfficiency, engineMax)));
		equipmentroomlist.add(shipID, (new EquipmentRoom(size)));
		fueltanklist.add(shipID, (new FuelTank(size, fuelCapacity)));
		lifesupportlist.add(shipID, (new LifeSupport(size, lsCapacity)));
		medicalbaylist.add(shipID, (new MedicalBay(size)));
		reactorchamberlist.add(shipID, (new ReactorChamber(size, reactorCapacity)));
		shieldgeneratorlist.add(shipID, (new ShieldGenerator(size, shieldStrength, regenRate)));
		teleporterslist.add(shipID, (new Teleporters(size, teleporterCapacity, teleporterRange)));
		warproomlist.add(shipID, (new WarpRoom(size, warpRange, warpUsage)));
		weaponroomlist.add(shipID, (new WeaponRoom(size, weaponType, weaponStrength, weaponAmount))); 
				
		// below is just for testing that the ship chamber has been added correctly and it works
		// it works. good night - 24.9.12-00.20


	}
}