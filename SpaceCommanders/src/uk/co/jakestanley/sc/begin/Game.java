package uk.co.jakestanley.sc.begin;

import java.io.IOException;


import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import uk.co.jakestanley.sc.net.GameClient;
import uk.co.jakestanley.sc.net.GameServer;
import uk.co.jakestanley.sc.states.DedicatedServerState;
import uk.co.jakestanley.sc.states.HostClientState;
import uk.co.jakestanley.sc.states.JoinClientState;
import uk.co.jakestanley.sc.states.MainMenuState;
import uk.co.jakestanley.sc.states.PlayState;
import uk.co.jakestanley.sc.states.SPClientState;

public class Game extends StateBasedGame{

	public static final String gameTitle = "Space Commanders";
	public static final int menu = 0;
	public static final int joinClient = 1;
	public static final int hostClient = 2;
	public static final int dedServer = 3;
	public static final int spClient = 4;
	public static final int play = 5;
	
	static public int port = 4321;
	
	public static String playerName = "Jake";
	public static String shipName = "Thunderchild";
	public static int sessionID;
	
	public static GameServer server;
	public static GameClient client;

	public Game(String title) {
		
		super(gameTitle);
		// initialise, but don't start server
		try {
			server = new GameServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		// initialise, but don't start client
		client = new GameClient();
		
		this.addState(new MainMenuState(menu));
		this.addState(new JoinClientState(joinClient));
		this.addState(new HostClientState(hostClient));
		this.addState(new DedicatedServerState(dedServer));
		this.addState(new SPClientState(spClient));
		this.addState(new PlayState(play));
	}

	public void initStatesList(GameContainer gc) throws SlickException {

		this.getState(menu).init(gc, this); // get states
		this.getState(joinClient).init(gc, this);
		this.getState(hostClient).init(gc, this);
		this.getState(dedServer).init(gc, this);
		this.getState(spClient).init(gc, this);
		this.getState(play).init(gc, this);
		this.enterState(menu);
	}


	public static void main(String[] args) throws SlickException {
		
		AppGameContainer gameWindow = new AppGameContainer(new Game(gameTitle));
		gameWindow.setDisplayMode(720, 480, false); // last variable is whether game is full screen or not
		gameWindow.setTargetFrameRate(60);
		gameWindow.start();
		
	}
}
