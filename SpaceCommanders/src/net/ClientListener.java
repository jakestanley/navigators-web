package net;

import java.util.Scanner;

import begin.Game;
import begin.Setup;

import net.Packet.*;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.minlog.Log;

public class ClientListener extends Listener {

	Client client;
	Scanner scanner;
	
	public ClientListener(Client c) {
		client = c;
	}
	public void connected(Connection arg0){
		Log.info("CLIENT> Connected.");
		client.sendTCP(new PacketLoginRequest());
	}
	
	public void disconnected(Connection arg0){
		Log.info("CLIENT> Disconnected.");
	}
	
	public void received(Connection c, Object o){
		if(o instanceof PacketLoginAnswer){
			if(((PacketLoginAnswer) o).accepted = true){
			System.out.println("CLIENT> Client login request approved.");
				scanner = new Scanner(System.in);
				while(true){
					if(Game.setup.client.scanner.hasNext()){
						PacketMessage msg = new PacketMessage();
						msg.message = Game.setup.client.scanner.nextLine();
						client.sendTCP(msg);
					}
				}
				
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
