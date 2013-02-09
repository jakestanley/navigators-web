package net;

import java.io.IOException;
import java.util.Scanner;

import net.Packet.*;

import begin.Player;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.minlog.Log;

public class GameClient {
	
	public Client client;
	public Scanner scanner;
	public String host = "";
	public Player player;
	public ClientListener listener;
	
	public GameClient(Player p) {
		player = p;
		Log.set(Log.LEVEL_DEBUG);
		scanner = new Scanner(System.in);
		client = new Client();
		registerPackets();
		listener = new ClientListener(client);
		client.addListener(listener);
		client.start();
		connectToServer();
			
	}
	
	private void connectToServer(){
		
		try {
			System.out.println("CLIENT> Trying to connect.");
			client.connect(5000, host, Network.port); // need a keepalive so doesn't timeout
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("CLIENT> Couldn't connect.");
			e.printStackTrace();
			client.stop();
		}
	}
	
	private void registerPackets(){
		Kryo kryo = client.getKryo();
		kryo.register(PacketLoginRequest.class);
		kryo.register(PacketLoginAnswer.class);
		kryo.register(PacketMessage.class);
		kryo.register(PlayerPacket.class);
	}

}
