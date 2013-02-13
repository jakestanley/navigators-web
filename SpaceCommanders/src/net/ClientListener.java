package net;

import begin.Game;

import net.Packet.LoginPacket;
import net.Packet.*;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class ClientListener extends Listener {

	Client client;

	public ClientListener(Client c) {
		client = c;
	}
	public void connected(Connection c){
		LoginPacket packet = new LoginPacket();
		packet.playerName = Game.playerName;
		packet.shipName = Game.shipName;
		client.sendTCP(packet);
	}

	public void disconnected(Connection c){
		System.out.println("CLIENT> Disconnected.");
	}

	public void received(Connection c, Object o){
		if(o instanceof LoginPacket){
			LoginPacket packet = (LoginPacket) o;
			if(packet.sessionID != -1){
				System.out.println("CLIENT> Server gave session ID " + packet.sessionID);
				Game.sessionID = packet.sessionID;
			} else {
				System.out.println("CLIENT> Login request denied");
				c.close();
			}
		} else if(o instanceof ShipHealthPacket){
			//Game.setup.client.player.setShipID(((ShipIDPacket) o).id);
			//System.out.println("CLIENT> Received ship id " + Game.setup.client.player.getShipID());
		}
	}

}
