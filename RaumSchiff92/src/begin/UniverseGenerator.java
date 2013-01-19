package begin;

import lists.PlanetList;
import lists.SectorList;
import lists.ShipList;

public class UniverseGenerator {
	
	int shipID;

	public void generateUniverse() {
		System.out.println("Generating universe...");
		final SectorList sectorlist = new SectorList();
		final PlanetList planetlist = new PlanetList();
		final ShipList shiplist = new ShipList();
		sectorlist.setup();
		planetlist.setup();
		shiplist.createPlayerShip();
	}
	
}
