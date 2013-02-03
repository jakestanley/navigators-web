package begin;

import java.util.ArrayList;

import ships.Reactor;
import ships.Ship;
import ships.Weapon;
import tools.Coordinate;


public class Setup {
	
	int shipIndex = 0;
	ArrayList<Ship> shipList = new ArrayList<Ship>();
	ArrayList<Weapon> weaponList= new ArrayList<Weapon>();
	ArrayList<Reactor> reactorList = new ArrayList<Reactor>();	

	public Setup(boolean test){
		if(test == true){
			shipList.add(shipIndex, new Ship(shipIndex, "Interstellar 5555", new Coordinate(0, 0, 0)));
			reactorList.add(shipIndex, new Reactor());
			weaponList.add(shipIndex, new Weapon());
			
			shipList.get(shipIndex).printAllShipInfo();
		} else {
			// run usual game stuff
		}
		
	}
	
}
