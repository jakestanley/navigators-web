package net;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.minlog.Log;

import net.Packet.*;

public class ServerListener extends Listener {

	public void connected(Connection arg0){
		Log.info("SERVER> A client has connected.");
	}
	
	public void disconnected(Connection arg0){
		Log.info("SERVER> A client has disconnected.");
	}
	
	public void received(Connection c, Object o){
		if(o instanceof PacketLoginRequest){
			System.out.println("SERVER> Client login request received.");
				PacketLoginAnswer loginAnswer = new PacketLoginAnswer();
				loginAnswer.accepted = true;
				c.sendTCP(loginAnswer);
		} else if(o instanceof PacketMessage){
			String message = ((PacketMessage)o).message;
			System.out.println("User: " + message);
		}
	}

}
