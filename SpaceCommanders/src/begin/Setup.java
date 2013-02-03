package begin;

import java.util.ArrayList;

import ships.Reactor;
import ships.Ship;
import ships.Weapon;
import tools.Coordinate;

public class Setup {
	
	int shipIndex = 0;
	public ArrayList<Ship> shipList = new ArrayList<Ship>();

	public Setup(boolean test){
		if(test == true){
			
			shipList.add(shipIndex, new Ship(shipIndex, "Interstellar 5555", new Coordinate(0, 0, 0)));
			shipList.get(shipIndex).printAllShipInfo();
			shipIndex++;
			
			
		} else {
			// run usual game stuff
		}
		
	}
	
}
