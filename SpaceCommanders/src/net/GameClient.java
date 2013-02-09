package net;

import java.io.IOException;
import java.util.Scanner;

import net.Packet.PacketLoginAnswer;
import net.Packet.PacketLoginRequest;
import net.Packet.PacketMessage;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.minlog.Log;

public class GameClient {
	
	public Client client;
	public Scanner scanner;
	public String host = "";
	
	public GameClient() {
		Log.set(Log.LEVEL_DEBUG);
		scanner = new Scanner(System.in);
		client = new Client();
		registerPackets();
		ClientListener listener = new ClientListener(client);
		client.addListener(listener);
		client.start();
		try {
			client.connect(5000, host, Network.port); // need a keepalive so doesn't timeout
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			client.stop();
		}
	}
	
	private void registerPackets(){
		Kryo kryo = client.getKryo();
		kryo.register(PacketLoginRequest.class);
		kryo.register(PacketLoginAnswer.class);
		kryo.register(PacketMessage.class);
	}

}
