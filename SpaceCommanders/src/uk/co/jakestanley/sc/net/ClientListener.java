package uk.co.jakestanley.sc.net;

import uk.co.jakestanley.sc.begin.Game;
import uk.co.jakestanley.sc.net.Packet.*;


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
				Game.out("CLIENT LISTENER> Server gave session id: " + Game.sessionID);
				InitShipInfoRequest infPacket = new InitShipInfoRequest();
				infPacket.sessionID = Game.sessionID;
				client.sendTCP(infPacket);
			} else {
				System.out.println("CLIENT> Join game request denied");
				c.close();
			}
		} else if(o instanceof ShipHealthPacket) {
			Game.out("CLIENT LISTENER> " + Game.sessionID + " received a ShipHealthPacket. It says " + ((ShipHealthPacket) o).shipHealth);
			Game.client.localShip.setShipHealth(((ShipHealthPacket) o).shipHealth);
		} else if(o instanceof InitShipInfoRequest) {
			Game.client.instantiateLocalShip((InitShipInfoRequest) o);
		}
	}

}
