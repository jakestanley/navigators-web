package uk.co.jakestanley.sc.net;

import uk.co.jakestanley.sc.begin.Game;
import uk.co.jakestanley.sc.net.Packet.ShipHealthPacket;
import uk.co.jakestanley.sc.net.Packet.*;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;


public class ServerListener extends Listener {
	
	public void connected(Connection c){
		Game.out("SERVER> A client has connected.");
	}
	
	public void disconnected(Connection c){
		Game.out("SERVER> A client has disconnected.");
	}
	
	public void received(Connection c, Object o){
		if(o instanceof LoginPacket){
			Game.out("SERVER> Client login request received.");
			LoginPacket packet = ((LoginPacket)o);
			packet.sessionID = c.getID();
			Game.server.setupSession(packet);
			c.sendTCP(packet);
			Game.out("SERVER LISTENER> Player joined the game with connection ID: " + c.getID());
		} else if(o instanceof InitShipInfoRequest) {
			InitShipInfoRequest request = (InitShipInfoRequest) o;
			Game.out("SERVER> Received init request from session id " + request.sessionID);
			InitShipInfoRequest init = Game.server.requestInitShipInfoRequest(request.sessionID);
			c.sendTCP(init);
		} else if(o instanceof BasicAttack){
			Game.server.basicAttack((BasicAttack) o);
			Game.out("SERVER LISTENER> Just received an instance of BasicAttack");
		} else if(o instanceof ShipHealthPacket){
			ShipHealthPacket shp = (ShipHealthPacket) o;
			shp.shipHealth = Game.server.shipList.get(Game.server.getShipIndexBySessionID(shp.sessionID)).getShipHealth();
			c.sendTCP(shp);
		}
	}
}
