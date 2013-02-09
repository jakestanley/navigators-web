package net;

import java.util.Scanner;

import begin.Game;

import net.Packet.*;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class ClientListener extends Listener {

	Client client;
	Scanner scanner = new Scanner(System.in);
	
	
	public ClientListener(Client c) {
		client = c;
	}
	public void connected(Connection arg0){
		System.out.println("CLIENT> Authenticating connection.");
		client.sendTCP(new PacketLoginRequest());
	}
	
	public void disconnected(Connection arg0){
		System.out.println("CLIENT> Disconnected.");
	}
	
	public void received(Connection c, Object o){
		if(o instanceof PacketLoginAnswer){
			if(((PacketLoginAnswer) o).accepted = true){
			System.out.println("CLIENT> Connected.");
				scanner = new Scanner(System.in);
			} else {
				System.out.println("CLIENT> Client login request denied.");
				c.close();
			}
		} else if(o instanceof PacketMessage){
			String message = ((PacketMessage)o).message;
			System.out.println("User: " + message);
		} else if(o instanceof ShipIDPacket){
			Game.setup.client.player.setShipID(((ShipIDPacket) o).id);
			System.out.println("CLIENT> Received ship id " + Game.setup.client.player.getShipID());
		}
	}

}
