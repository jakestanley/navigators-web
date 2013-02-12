package states;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import begin.Game;

public class HostClientState extends BasicGameState implements MouseListener {

	int stateID;
	String mousePosition = "No mouse input";
	String mouseClickedOn = "No mouse clicks yet";
	String connectionStatus = "";
	
	Input input;

	public HostClientState(int state) {
		
		stateID = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		// need to tidy this up LOTSSSS!!!!!
		input = gc.getInput();

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub

		g.drawString("Host Game.", 50, 50);

		g.drawString("Start Server", 50, 100);
		g.drawRect(45, 95, 130, 30);
		g.drawString("Join Game", 50, 150);
		g.drawRect(45, 145, 100, 30);
		g.drawString("Main Menu.", 50, 400);
		g.drawRect(45, 395, 100, 30);
		g.drawString(mousePosition, 250, 10);


	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		//connectionStatus = client.getConnectedStatus();
		// need to get client connection status from Game.server etc...
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		mousePosition = ("Mouse position is: " +xPos + ", " + yPos + "Current state is: " + sbg.getCurrentStateID());
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			if(Game.currentState == this.stateID){
				if(xPos >= 45 && xPos <= 145 && yPos >= 55 && yPos <= 85){
					Game.currentState = 0;
					sbg.enterState(0);
				} else if(xPos >= 45 && xPos <= 145 && yPos >= 355 && yPos <= 385){
					Game.server.startServer();
				} else if(xPos >= 45 && xPos <= 145 && yPos >= 305 && yPos <= 335){
					Game.client.startClient();
					if(Game.client.connectToServer()){
						sbg.enterState(5);
					}
				}
			}
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return stateID;
	}

}
