package begin;

import java.io.IOException;

import net.GameClient;
import net.GameServer;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import states.DedicatedServerState;
import states.HostClientState;
import states.MainMenuState;
import states.JoinClientState;
import states.PlayState;
import states.SPClientState;

public class Game extends StateBasedGame{

	public static final String gameTitle = "Space Commanders";
	public static final int menu = 0;
	public static final int joinClient = 1;
	public static final int hostClient = 2;
	public static final int dedServer = 3;
	public static final int spClient = 4;
	public static final int play = 5;
	
	public static boolean mouseClicked;
	
	public static int currentState;
	
	public static GameServer server;
	public static GameClient client;

	public Game(String title) {
		
		super(gameTitle);
		
		mouseClicked = false;
		
		// initialise, but don't start server
		try {
			server = new GameServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		// initialise, but don't start client
		client = new GameClient(new Player("Jake", "Thunderchild"));
		
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
		currentState = 0;
		// takes id of a state - what do i want to show the user?
	}


	public static void main(String[] args) throws SlickException {
		
		AppGameContainer gameWindow = new AppGameContainer(new Game(gameTitle));
		gameWindow.setDisplayMode(720, 480, false); // last variable is whether game is full screen or not
		gameWindow.setTargetFrameRate(60);
		gameWindow.start();
		
	}
}
