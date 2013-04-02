package uk.co.jakestanley.sc.net;

import java.io.IOException;
import java.util.ArrayList;

import uk.co.jakestanley.sc.begin.Game;
import uk.co.jakestanley.sc.crew.Member;
import uk.co.jakestanley.sc.net.Packet.*;
import uk.co.jakestanley.sc.ships.Ship;
import uk.co.jakestanley.sc.tools.Coordinate;



import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;


public class GameServer {
	
	public ArrayList<Ship> shipList = new ArrayList<Ship>();;
	public ArrayList<Member> crewList = new ArrayList<Member>();;
	
	public boolean serverStarted;

	private Server server;
	
	public GameServer() throws IOException{
		serverStarted = false;
		server = new Server();
		registerPackets();
		server.addListener(new ServerListener());
		// server.bind(Game.port);
	}
	
	public void startServer() throws IOException{
		if(!serverStarted){
		server.bind(Game.port);	
		System.out.println("SERVER> Starting server on port " + Game.port);
		server.start();
		serverStarted = true;
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
	
	public void setupSession(LoginPacket packet){
		shipList.add(new Ship(packet.sessionID, packet.shipName, packet.playerName, new Coordinate(0,0,0)));		
		System.out.println("SERVER> Just created new ship " + packet.shipName + ", piloted by " + packet.playerName);
	}
	
	public InitShipInfoRequest requestInitShipInfoRequest(int id){
		System.out.println("SERVER> Processing init request for sesh id " + id);
		InitShipInfoRequest init = new InitShipInfoRequest();
		int shipIndex = getShipIndexBySessionID(id);
		init.availableCoolant = shipList.get(shipIndex).getAvailableCoolant();
		System.out.println("SERVER> getting avail cool for ship " + shipList.get(shipIndex).availableCoolant);
		init.isShipOn = shipList.get(shipIndex).isShipOn();
		init.shipHealth = shipList.get(shipIndex).shipHealth;
		init.shipName = shipList.get(shipIndex).shipName;
		init.playerName = shipList.get(shipIndex).playerName;
		return init;
		
	}
	
	public void basicAttack(BasicAttack ba){
		Game.out("SERVER> Doing basic attack");
		int target = getShipIndexBySessionID(ba.target);
		shipList.get(target).shipHealth--;
		ShipHealthPacket shp = new ShipHealthPacket();
		shp.shipHealth = shipList.get(target).shipHealth;
		Game.out("SERVER> " + shipList.get(target).getShipID() + " health is now " + shipList.get(target).getShipHealth());
		server.sendToTCP(ba.target, shp);
		
	}
	
	public int getShipIndexBySessionID(int id){
		for(int i = 0; i < shipList.size(); i++){
			if(shipList.get(i).getShipID() == id){
				return i;
			}
		}
		return -1;
	}
	
}

// Need to thank NeoSilkyFTW from YouTube for his help with this.