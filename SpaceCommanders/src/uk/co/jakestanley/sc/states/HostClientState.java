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
	TextField serverPortField;
	TextField hostAddressField;
	TextField hostPortField;
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
			
		    serverNameField = new TextField(gc, gc.getDefaultFont(), 300, 100, 175, 25);
		    serverNameField.setText(Game.serverName); // TODO load this and ship and player name from xml later on
		    serverNameField.setAcceptingInput(true);
		    
		    serverPortField = new TextField(gc, gc.getDefaultFont(), 550, 100, 100, 25);
		    serverPortField.setText(Integer.toString(Game.port));
		    serverPortField.setAcceptingInput(true);
		    
		    hostAddressField = new TextField(gc, gc.getDefaultFont(), 300, 150, 175, 25);
		    hostAddressField.setText(Game.host);
		    
		    hostPortField = new TextField(gc, gc.getDefaultFont(), 550, 150, 100, 25);
		    hostPortField.setText(Integer.toString(Game.port));
		    
		    playerNameField = new TextField(gc, gc.getDefaultFont(), 300, 200, 300, 25);
		    playerNameField.setText(Game.playerName); // TODO load this and ship and player name from xml later on
		    
		    shipNameField = new TextField(gc, gc.getDefaultFont(), 300, 250, 300, 25);
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
		g.drawString("Port: ", 490, 100);
		g.drawString("Join Game", 50, 150);
		g.drawString("Host address: ", 175, 150);
		g.drawString("Port: ", 490, 150);
		g.drawString("Player name: ", 175, 200);
		g.drawString("Ship name: ", 175, 250);
		g.drawRect(45, 145, 100, 30);
		g.drawString("Main Menu.", 50, 400);
		g.drawRect(45, 395, 100, 30);
		g.drawString(mousePosition, 250, 10);
		serverNameField.render(gc, g);
		serverPortField.render(gc, g);
		hostAddressField.render(gc, g);
		hostPortField.render(gc, g);
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
						Game.port = Integer.parseInt(serverPortField.getText()); // TODO need a try catch here also
						Game.server.startServer();
						serverNameField.setAcceptingInput(false); // TODO closing server allows this to be edited again
						serverPortField.setAcceptingInput(false);
					} catch(Exception e) {
						Game.out("GAME> Could not start server. There may be a port or IP address conflict.");
					}
				} else if(xPos >= 45 && xPos <= 145 && yPos >= 305 && yPos <= 335){
					Game.playerName = playerNameField.getText(); // TODO check there are no name conflicts
					Game.shipName = shipNameField.getText(); // TODO check there are no name conflicts
					Game.host = hostAddressField.getText();
					Game.port = Integer.parseInt(hostPortField.getText()); // TODO try catch here
					if(Game.client.connectToServer()){
						sbg.enterState(3); 
					}
				}
			}
		}
		if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
			if(xPos >= 300 && xPos <= 500 && yPos >= 355 && yPos <= 380){
				serverNameField.setFocus(true);
			} else if(xPos >= 550 && xPos <= 650 && yPos >= 355 && yPos <= 380) {
				serverPortField.setFocus(true);
			} else if(xPos >= 300 && xPos <= 475 && yPos >= 305 && yPos <= 330){
				hostAddressField.setFocus(true);
			} else if(xPos >= 550 && xPos <= 650 && yPos >= 305 && yPos <= 330) {
				hostPortField.setFocus(true);
			} else if(xPos >= 300 && xPos <= 600 && yPos >= 255 && yPos <= 280){
				playerNameField.setFocus(true);
			} else if(xPos >= 300 && xPos <= 600 && yPos >= 205 && yPos <= 230){
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
