package uk.co.jakestanley.sc.net;

import uk.co.jakestanley.sc.begin.Game;
import uk.co.jakestanley.sc.net.Packet.*;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;


public class ServerListener extends Listener {
	
	public void connected(Connection c){
		System.out.println("SERVER> A client has connected.");
	}
	
	public void disconnected(Connection c){
		System.out.println("SERVER> A client has disconnected.");
	}
	
	public void received(Connection c, Object o){
		if(o instanceof LoginPacket){
			System.out.println("SERVER> Client login request received.");
			LoginPacket packet = new LoginPacket();
			packet.sessionID = Game.server.assignSessionID((LoginPacket) o);
			c.sendTCP(packet);
		} else if(o instanceof InitShipInfoRequest) {
			
			InitShipInfoRequest request = (InitShipInfoRequest) o;
			System.out.println("SERVER> Received init request from session id " + request.sessionID);
			InitShipInfoRequest init = Game.server.requestInitShipInfoRequest(request.sessionID);
			c.sendTCP(init);
		} else if(o instanceof BasicAttack){
			Game.server.basicAttack((BasicAttack) o);
			ShipHealthPacket shp = new ShipHealthPacket();
			shp.shipHealth = Game.server.shipList.get(((BasicAttack) o).target).shipHealth;
			c.sendTCP(shp);
		}
	}
}
