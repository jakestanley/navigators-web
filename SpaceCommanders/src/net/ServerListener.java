package net;

import begin.Game;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import net.Packet.*;

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
		} 
	}
}
