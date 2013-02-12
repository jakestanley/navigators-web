package net;

import java.io.IOException;
import java.util.ArrayList;

import ships.Ship;
import tools.Coordinate;

import net.Packet.*;

import begin.Player;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;

import crew.Member;

public class GameServer {
	
	public ArrayList<Player> playerList = new ArrayList<Player>();
	public ArrayList<Ship> shipList = new ArrayList<Ship>();;
	public ArrayList<Member> crewList = new ArrayList<Member>();;
	
	int index = 0;

	private Server server;
	
	public GameServer() throws IOException{
		server = new Server();
		registerPackets();
		server.addListener(new ServerListener());
		server.bind(Network.port);
	}
	
	public void startServer(){
		server.start();
	}
	
	public void stopServer(){
		server.stop();
	}
	
	private void registerPackets(){ // Register classes in the right order.
		Kryo kryo = server.getKryo();
		kryo.register(PacketLoginRequest.class);
		kryo.register(PacketLoginAnswer.class);
		kryo.register(PacketMessage.class);
		kryo.register(PlayerPacket.class);
		kryo.register(ShipIDPacket.class);
	}
	
	public int assignShipID(PlayerPacket p){
		System.out.println("SERVER> Assigning id: " + index + " to " + p.nickname);
		playerList.add(index, new Player(p.nickname, p.shipName));
		shipList.add(index, new Ship(index, p.shipName, new Coordinate(0,0,0)));
		index++;
		return index - 1;
	}
	
}

// Need to thank NeoSilkyFTW from YouTube for his help with this.