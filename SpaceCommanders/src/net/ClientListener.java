package net;

import begin.Game;

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
				InitShipInfoRequest infPacket = new InitShipInfoRequest();
				infPacket.sessionID = Game.sessionID;
				client.sendTCP(infPacket);
			} else {
				System.out.println("CLIENT> Join game request denied");
				c.close();
			}
		} else if(o instanceof ShipHealthPacket) {
			Game.client.localShip.shipHealth = ((ShipHealthPacket) o).shipHealth;
		} else if(o instanceof InitShipInfoRequest) {
			Game.client.instantiateLocalShip((InitShipInfoRequest) o);
		}
	}

}
