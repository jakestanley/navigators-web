package net;

import java.io.IOException;
import net.Packet.*;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;

public class GameServer {

	private Server server;
	
	public GameServer() throws IOException{
		server = new Server();
		registerPackets();
		server.addListener(new ServerListener());
		server.bind(Network.port);
		server.start();
	}
	
	private void registerPackets(){ // Register classes in the right order.
		Kryo kryo = server.getKryo();
		kryo.register(PacketLoginRequest.class);
		kryo.register(PacketLoginAnswer.class);
		kryo.register(PacketMessage.class);
	}
}

// Need to thank NeoSilkyFTW from YouTube for his help with this.