package uk.co.jakestanley.sc.states;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.gui.*;


import uk.co.jakestanley.sc.begin.Game;


public class HostClientState extends BasicGameState implements MouseListener {

	int stateID;
	String mousePosition = "No mouse input";
	String mouseClickedOn = "No mouse clicks yet";
	TextField serverNameField;
	TextField playerNameField;
	TextField shipNameField;
	Input input;

	public HostClientState(int state) {
		
		stateID = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
			input = gc.getInput();			
			// init fonts - below was nicked from some dude on stack overflow
			//font = new UnicodeFont(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.ITALIC, 26));
			
		    serverNameField = new TextField(gc, gc.getDefaultFont(), 300, 100, 300, 25);
		    serverNameField.setText(Game.serverName); // TODO load this and ship and player name from xml later on
		    serverNameField.setFocus(true);
		    serverNameField.setAcceptingInput(true);
		    
		    playerNameField = new TextField(gc, gc.getDefaultFont(), 300, 150, 300, 25);
		    playerNameField.setText(Game.playerName); // TODO load this and ship and player name from xml later on
		    
		    shipNameField = new TextField(gc, gc.getDefaultFont(), 300, 200, 300, 25);
		    shipNameField.setText(Game.shipName); // TODO load this and ship and player name from xml later on
		    
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
		g.drawString("Server Name: ", 175, 100);
		g.drawString("Join Game", 50, 150);
		g.drawString("Player name: ", 175, 150);
		g.drawString("Ship name: ", 175, 200);
		g.drawRect(45, 145, 100, 30);
		g.drawString("Main Menu.", 50, 400);
		g.drawRect(45, 395, 100, 30);
		g.drawString(mousePosition, 250, 10);
		serverNameField.render(gc, g);
		playerNameField.render(gc, g);
		shipNameField.render(gc, g);
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
						Game.serverName = serverNameField.getText();
						Game.server.startServer();
						serverNameField.setAcceptingInput(false); // TODO closing server allows this to be edited again
					} catch(Exception e) {
						Game.out("GAME> Could not start server. There may be a port or IP address conflict.");
					}
				} else if(xPos >= 45 && xPos <= 145 && yPos >= 305 && yPos <= 335){
					Game.playerName = playerNameField.getText();
					Game.shipName = shipNameField.getText();
					if(Game.client.connectToServer()){
						sbg.enterState(3);
					}
				}
			}
		}
		
		if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
			if(xPos >= 300 && xPos <= 600 && yPos >= 355 && yPos <= 380){
				serverNameField.setFocus(true);
				//playerNameField.setFocus(false);
				//shipNameField.setFocus(false);
			} else if(xPos >= 300 && xPos <= 600 && yPos >= 305 && yPos <= 330){
				//serverNameField.setFocus(true);
				playerNameField.setFocus(true);
				//shipNameField.setFocus(false);
			} else if(xPos >= 300 && xPos <= 600 && yPos >= 255 && yPos <= 280){
				//serverNameField.setFocus(true);
				//playerNameField.setFocus(false);
				shipNameField.setFocus(true);
			}
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return stateID;
	}
	
}
