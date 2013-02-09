package begin;

import java.io.IOException;
import java.util.ArrayList;

import net.GameClient;
import net.Network;
import net.GameServer;

import crew.Member;

import ships.Ship;
import tools.Coordinate;

public class Setup {
	
	public GameClient client;
	GameServer server;

	int shipIndex = 0;
	int crewIndex = 0;
	public ArrayList<Ship> shipList = new ArrayList<Ship>();
	public ArrayList<Member> crewList = new ArrayList<Member>();

	public Setup(int mode) throws IOException{

		switch(mode){
		case 0:
			System.out.println("Running Single Player Server");
			server = new GameServer();
			client = new GameClient();
			
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
	
	/*
	
	public void setupTestData(){
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

	}
	
	
	*/
	
}

