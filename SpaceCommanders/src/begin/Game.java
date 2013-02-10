package begin;

import java.io.IOException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import states.GameClientState;
import states.MainMenuState;


public class Game extends StateBasedGame{
	
	public static final String gameTitle = "Space Commanders";
	public static final int menu = 0;
	public static final int client = 1;
			
	public static Setup setup;
	public Game(String title) {
		super(gameTitle);
		this.addState(new MainMenuState(menu));
	//	this.addState(new GameClientState(client));
	}
	
	public static void main(String[] args) throws SlickException {
			
		AppGameContainer gameWindow = new AppGameContainer(new Game(gameTitle));
		gameWindow.setDisplayMode(720, 480, false); // last variable is whether game is full screen or not
		gameWindow.setTargetFrameRate(60);
		gameWindow.start();
		try {
			setup = new Setup(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		this.getState(menu).init(gc, this); // get states
		//this.getState(client).init(gc, this);
		this.enterState(menu); // takes id of a state - what do i want to show the user?
	}
	
}
