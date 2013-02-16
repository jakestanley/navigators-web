package net;

import java.io.IOException;
import java.util.ArrayList;

import ships.Ship;
import tools.Coordinate;

import net.Packet.*;

import begin.Game;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;

import crew.Member;

public class GameServer {
	
	public ArrayList<Ship> shipList = new ArrayList<Ship>();;
	public ArrayList<Member> crewList = new ArrayList<Member>();;
	
	int sessionIndex = 0;
	
	public boolean serverStarted;

	private Server server;
	
	public GameServer() throws IOException{
		serverStarted = false;
		server = new Server();
		registerPackets();
		server.addListener(new ServerListener());
		server.bind(Game.port);
	}
	
	public void startServer(){
		if(!serverStarted){
		System.out.println("SERVER> Starting server.");
		serverStarted = true;
		server.start();
		} else {
			System.out.println("SERVER> Server is already running.");
		}
	}
	
	public void stopServer(){
		server.stop();
	}
	
	private void registerPackets(){ // Register classes in the right order.
		Kryo kryo = server.getKryo();
		kryo.register(LoginPacket.class);
		kryo.register(ShipHealthPacket.class);
		kryo.register(InitShipInfoRequest.class);
		kryo.register(BasicAttack.class);
	}
	
	public int assignSessionID(LoginPacket packet){
		System.out.println("SERVER> Assigning id: " + sessionIndex + " to " + packet.playerName);
		shipList.add(sessionIndex, new Ship(sessionIndex, packet.shipName, packet.playerName, new Coordinate(0,0,0)));		
		System.out.println("SERVER> Just created new ship " + shipList.get(sessionIndex).shipName + ", piloted by " + shipList.get(sessionIndex).playerName);
		sessionIndex++;
		
		return sessionIndex - 1;
	}
	
	public InitShipInfoRequest requestInitShipInfoRequest(int id){
		System.out.println("SERVER> Processing init request for sesh id " + id);
		InitShipInfoRequest init = new InitShipInfoRequest();
		init.availableCoolant = shipList.get(id).getAvailableCoolant();
		System.out.println("SERVER> getting avail cool for ship " + shipList.get(id).availableCoolant);
		init.isShipOn = shipList.get(id).isShipOn();
		init.shipHealth = shipList.get(id).shipHealth;
		init.shipName = shipList.get(id).shipName;		
		init.playerName = shipList.get(id).playerName;
		return init;
		
	}
	
	public void basicAttack(BasicAttack ba){
		System.out.println("SERVER> Ship " + shipList.get(ba.prop).shipName + " hit " + shipList.get(ba.target).shipName);
		shipList.get(ba.target).shipHealth--;
	} 
	
}

// Need to thank NeoSilkyFTW from YouTube for his help with this.