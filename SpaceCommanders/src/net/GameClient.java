package net;

import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import net.Packet.*;

import begin.Game;
import begin.Player;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.minlog.Log;

public class GameClient {
	
	public Client client;
	public String host = "";
	public Player player;
	public ClientListener listener;
	PacketTranslator pt = new PacketTranslator();
	
	public GameClient(Player p) {
		player = p;
		Log.set(Log.LEVEL_DEBUG);
		client = new Client();
		registerPackets();
		listener = new ClientListener(client);
		client.addListener(listener);
		
	}
	
	public void startClient(){
		client.start();
		connectToServer();
		client.sendTCP(pt.playerToPacket(player));
	}
	
	public boolean connectToServer(){
		boolean success = false; 
		try {
			System.out.println("CLIENT> Trying to connect.");
			client.connect(5000, host, Network.port); // need a keepalive so doesn't timeout
			success = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("CLIENT> Couldn't connect.");
			e.printStackTrace();
			client.stop();
		}
		return success;
	}
	
	public String getConnectedStatus(){
		String status = "";
		if(client.isConnected()){
			status = "Connected";
		} else {
			status = "Not connected";
		}
		return status;
	}
	
	private void registerPackets(){
		Kryo kryo = client.getKryo();
		kryo.register(PacketLoginRequest.class);
		kryo.register(PacketLoginAnswer.class);
		kryo.register(PacketMessage.class);
		kryo.register(PlayerPacket.class);
		kryo.register(ShipIDPacket.class);
	}

}
