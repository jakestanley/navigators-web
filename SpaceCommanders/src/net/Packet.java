package net;

import tools.Coordinate;

public class Packet {

	public static class LoginPacket {
		String playerName;
		String shipName;
		int sessionID;
	}
	
	public static class ShipHealthPacket {
		int sessionID;
		float shipHealth;
	}
	
	public static class InitShipInfoRequest {
		boolean isShipOn;
		int sessionID;
		int availableCoolant;
		float shipHealth;
		String shipName, playerName;
		
	}
	
	public static class BasicAttack {
		int target;
		int prop;
	}
}
