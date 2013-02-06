package begin;

import java.util.ArrayList;
import java.util.Random;

import crew.Member;

import ships.Ship;
import tools.Coordinate;

public class Setup {

	int shipIndex = 0;
	int crewIndex = 0;
	public ArrayList<Ship> shipList = new ArrayList<Ship>();
	public ArrayList<Member> crewList = new ArrayList<Member>();

	public Setup(int mode, boolean test){

		switch(mode){
		case 0:
			System.out.println("Running Single Player");
			if(test == true){	

				// make the server control this stuff...
				// single player is local server
				
				shipList.add(shipIndex, new Ship(shipIndex, "Thunderchild", new Coordinate(0, 0, 0)));
				shipList.get(shipIndex).printAllShipInfo();

				System.out.println("");
				System.out.println("-- CREW INFO --");
				crewList.add(crewIndex, new Member("Jake", "Stanley", shipIndex, crewIndex, 0));
				crewList.get(crewIndex).promote();
				crewList.get(crewIndex).promote();
				crewList.get(crewIndex).promote();
				crewList.get(crewIndex).printAllMemberInfo();
				crewIndex++;
				crewList.add(crewIndex, new Member("Jamie", "Hall", shipIndex, crewIndex, 1));
				crewList.get(crewIndex).promote();
				crewList.get(crewIndex).promote();
				crewList.get(crewIndex).printAllMemberInfo();
				crewIndex++;
				crewList.add(crewIndex, new Member("Hank", "Scott", shipIndex, crewIndex, 0));
				crewList.get(crewIndex).promote();
				crewList.get(crewIndex).printAllMemberInfo();
				crewIndex++;
				crewList.add(crewIndex, new Member("Jon", "Sterling", shipIndex, crewIndex, 0));
				crewList.get(crewIndex).promote();
				crewList.get(crewIndex).printAllMemberInfo();
				crewIndex++;
				crewList.add(crewIndex, new Member("Alex", "Stanley", shipIndex, crewIndex, 0));
				crewList.get(crewIndex).printAllMemberInfo();
				crewIndex++;
				crewList.add(crewIndex, new Member("Yvonne", "Jenkinson", shipIndex, crewIndex, 1));
				crewList.get(crewIndex).printAllMemberInfo();
				crewIndex++;

				shipIndex++; // only increment shipIndex after generating starting crew, otherwise your crew will be assigned to a different ship!!

			} else {
				// do single player stuff
			}
			break;
		case 1:
			System.out.println("Running Multiplayer Listen Server");
			// do multiplayer listen server stuff
			// this does things a little bit differently
			break;
		case 2:
			System.out.println("Running Multiplayer Dedicated Server");
			// do... you get the picture
			break;
		case 3: 
			System.out.println("Running Connect To Multiplayer Session");
			// do
			break;
		}
	}
}

