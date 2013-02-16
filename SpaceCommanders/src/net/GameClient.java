package net;

import java.io.IOException;
import java.util.ArrayList;

import ships.Ship;
import tools.Coordinate;

import net.Packet.*;
import begin.Game;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;

import crew.Member;

public class GameClient {
	
	// Game Client gets ship info on joining and 
	// creates a local instance of the Ship 
	// class along with relevant components
	// Game Client is in charge of requesting 
	// all the relevant info from the server
	
	public Client client;
	public String host = "";
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
			client.connect(5000, host, Game.port);
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
		basic.target = 0;
	
		client.sendTCP(basic);
	}
}
