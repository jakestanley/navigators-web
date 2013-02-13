package net;

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

}
