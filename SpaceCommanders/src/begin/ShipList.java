package begin;

import java.util.ArrayList;

import ships.Ship;

public class ShipList extends ArrayList {
	
	public ArrayList<Ship> shiplist = new ArrayList<Ship>();
	public int shipIndex = 0;
	
	public ShipList() { 
		
	}
	
	public void newShip(String name, int type) {
		
		shiplist.add(shipIndex, new Ship(shipIndex, name, type));
		shipIndex++;
		
	}

}
