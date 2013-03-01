package uk.co.jakestanley.sc.net;

import java.io.IOException;
import java.util.ArrayList;

import uk.co.jakestanley.sc.begin.Game;
import uk.co.jakestanley.sc.crew.Member;
import uk.co.jakestanley.sc.net.Packet.*;
import uk.co.jakestanley.sc.ships.Ship;
import uk.co.jakestanley.sc.tools.Coordinate;


import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;


public class GameClient {
	
	// Game Client gets ship info on joining and 
	// creates a local instance of the Ship 
	// class along with relevant components
	// Game Client is in charge of requesting 
	// all the relevant info from the server
	
	public Client client;
	//public String host = "";
	public ClientListener listener;
	public ArrayList<Ship> localShipList = new ArrayList<Ship>();
	public ArrayList<Member> localCrewList = new ArrayList<Member>(); // iterate through ship list to get ship based on id?
	public Ship localShip;
	
	public GameClient() {
		client = new Client();
		registerPackets();
		listener = new ClientListener(client);
		client.addListener(listener);
	}
	
	public boolean connectToServer(){
		client.start();
		boolean success = false; 
		try {
			System.out.println("CLIENT> Connecting.");
			client.connect(5000, Game.host, Game.port);
			success = true;
		} catch (IOException e) {
			System.out.println("CLIENT> Couldn't connect.");
			e.printStackTrace();
			client.stop();
		}
		return success;
	}
	
	// this works for initial join and later joins if disconnects
	
	
	public void instantiateLocalShip(InitShipInfoRequest init){
		localShip = new Ship(init.sessionID, init.playerName, init.shipName, new Coordinate(0,0,0));
		localShip.availableCoolant = init.availableCoolant;
		localShip.shipHealth = init.shipHealth;
		
	}
	
	private void registerPackets(){
		Kryo kryo = client.getKryo();
		kryo.register(LoginPacket.class);
		kryo.register(ShipHealthPacket.class);
		kryo.register(InitShipInfoRequest.class);
		kryo.register(BasicAttack.class);
	}
	
	public void basicAttack(int id){
		BasicAttack basic = new BasicAttack();
		basic.prop = Game.sessionID;
		basic.target = 1;
		client.sendTCP(basic);
	}
	
	public void requestShipHealth(int id){
		ShipHealthPacket shp = new ShipHealthPacket();
		shp.sessionID = id;
		client.sendTCP(shp);
	}
}
