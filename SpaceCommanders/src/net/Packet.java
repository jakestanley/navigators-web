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
	
	public static class PlayerPacket {
		
		String nickname;
		String shipName;
		public PlayerPacket(String arg0, String arg1){
			
			nickname = arg0;
			shipName = arg1;
			
		}
	}

}
