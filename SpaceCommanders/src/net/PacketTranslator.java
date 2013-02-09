package net;

import begin.Player;
import net.Packet.*;

public class PacketTranslator {
	
	public PlayerPacket playerToPacket(Player p){
		
		PlayerPacket pp = new PlayerPacket();
		pp.nickname = p.getNickname();
		pp.shipName = p.getShipName();
		return pp;
	}
	
	public Player packetToPlayer(PlayerPacket pp){
		Player player = new Player(pp.nickname, pp.shipName);
		return player;
	}
	
	public ShipIDPacket idToPacket(int i){
		ShipIDPacket idPacket = new ShipIDPacket();
		idPacket.id = i;
		return idPacket;
	}
}
