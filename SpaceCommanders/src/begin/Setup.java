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

	public Setup(boolean test){
		if(test == true){
			
			Random rand = new Random();
			System.out.println("Oh shit son here come some random numbers...");
			System.out.println("");
			for(int i = 0; i < 20; i++){
			System.out.print((rand.nextInt(50 - 18 + 1) + 18) + " ");
			}
			
			
			shipList.add(shipIndex, new Ship(shipIndex, "Interstellar 5555", new Coordinate(0, 0, 0)));
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
			crewList.add(crewIndex, new Member("Lisa", "Eastwood", shipIndex, crewIndex, 1));
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
			// run usual game stuff
		}
		
	}
	
}
