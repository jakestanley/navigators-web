package uk.co.jakestanley.sc.states;

import java.awt.Font;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.TrueTypeFont;


import uk.co.jakestanley.sc.begin.Game;


public class HostClientState extends BasicGameState implements MouseListener {

	int stateID;
	String mousePosition = "No mouse input";
	String mouseClickedOn = "No mouse clicks yet";
//	String connectionStatus = "";
	Font loadFont;
	TrueTypeFont inputFont;
	TextField serverNameField;
	Input input;

	public HostClientState(int state) {
		
		stateID = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
			input = gc.getInput();			
			// init fonts - below was nicked from some dude on stack overflow
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub

//		serverNameField.render(gc, g);
//		serverNameField.setFocus(true);
		g.drawString("Multiplayer.", 50, 50);
		g.drawString("Host Game", 50, 100);
		g.drawRect(45, 95, 100, 30);
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
		mousePosition = ("Mouse position is: " +xPos + ", " + yPos);
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			if(sbg.getCurrentStateID() == this.stateID){
				if(xPos >= 45 && xPos <= 145 && yPos >= 55 && yPos <= 85){
					sbg.enterState(0);
				} else if(xPos >= 45 && xPos <= 145 && yPos >= 355 && yPos <= 385){
					try {
						Game.server.startServer();
					} catch(Exception e) {
						Game.out("GAME> Could not start server. There may be a port or IP address conflict.");
					}
				} else if(xPos >= 45 && xPos <= 145 && yPos >= 305 && yPos <= 335){
					if(Game.client.connectToServer()){
						sbg.enterState(3);
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
