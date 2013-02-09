package net;

public class Packet {

	public static class PacketLoginRequest {
		
	}
	
	public static class PacketLoginAnswer {
		boolean accepted = false;
	}
	
	public static class PacketMessage {
		String message;
	}
	
	

}
