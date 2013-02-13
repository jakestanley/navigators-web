package net;

import java.io.IOException;

import net.Packet.*;
import begin.Game;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;

public class GameClient {
	
	public Client client;
	public String host = "";
	public ClientListener listener;
	
	
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
			// TODO Auto-generated catch block
			System.out.println("CLIENT> Couldn't connect.");
			e.printStackTrace();
			client.stop();
		}
		return success;
	}
	
	private void registerPackets(){
		Kryo kryo = client.getKryo();
		kryo.register(LoginPacket.class);
		kryo.register(ShipHealthPacket.class);
	}

}
