package net;

import begin.Game;
import begin.Player;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import net.Packet.*;
import net.Packet.PlayerPacket;
import net.PacketTranslator;

public class ServerListener extends Listener {
	
	PacketTranslator pt = new PacketTranslator();

	public void connected(Connection arg0){
		System.out.println("SERVER> A client has connected.");
	}
	
	public void disconnected(Connection arg0){
		System.out.println("SERVER> A client has disconnected.");
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
		} else if(o instanceof PlayerPacket){
			System.out.println("SERVER> Thanks for the PlayerPacket object");
			Player player = pt.packetToPlayer((PlayerPacket) o);
			System.out.println("SERVER> " + player.getNickname() + " connected. " +
					"He is the commander of the good ship " + player.getShipName());
			//c.sendTCP(pt.idToPacket(Game.server.assignShipID((PlayerPacket) o)));
		}
	}
}
