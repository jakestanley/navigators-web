package states;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import begin.Game;
import begin.Player;

public class HostClientState extends BasicGameState {

	int stateID;
	String mousePosition = "No mouse input";
	String mouseClickedOn = "No mouse clicks yet";
	
	String connectionStatus = "";
	
	public HostClientState(int state) {
		stateID = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
		Game.server.startServer();
		
		Game.client.startClient();


		// need to tidy this up LOTSSSS!!!!!
		
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		
		g.drawString("Host Game.", 50, 50);
		g.drawString(connectionStatus, 50, 100);
		g.drawString("Main Menu.", 50, 400);
		g.drawString(mousePosition, 250, 10);
		g.drawRect(45, 395, 100, 30);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		//connectionStatus = client.getConnectedStatus();
		// need to get client connection status from Game.server etc...
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		mousePosition = ("Mouse position is: " +xPos + ", " + yPos);
		if(Mouse.isButtonDown(Input.MOUSE_LEFT_BUTTON)){
			if(xPos >= 45 && xPos <= 145 && yPos >= 55 && yPos <= 85){
				
				sbg.enterState(0);
			} else {
				
			}
			
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return stateID;
	}

}
