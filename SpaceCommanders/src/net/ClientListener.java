package net;

import java.util.Scanner;

import begin.Game;

import net.Packet.*;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class ClientListener extends Listener {

	Client client;
	Scanner scanner;
	
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
				
				
				
				while(true){
					if(Game.setup.client.scanner.hasNext()){
						PacketMessage msg = new PacketMessage();
						msg.message = Game.setup.client.scanner.nextLine();
						client.sendTCP(msg);
					}
				}
				
				
				/*
				
				
				try {
					client.sendTCP(new PlayerPacket(Game.setup.client.player.getNickname(), Game.setup.client.player.getShipName()));
				} catch (Exception e){
					System.out.println("CLIENT> I had trouble passing a Player object");
					e.printStackTrace();
				}
				
				*/
				
			} else {
				System.out.println("CLIENT> Client login request denied.");
				c.close();
			}
		} else if(o instanceof PacketMessage){
			String message = ((PacketMessage)o).message;
			System.out.println("User: " + message);
		}
	}

}
