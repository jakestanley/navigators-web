package uk.co.jakestanley.sc.states;

import org.newdawn.slick.GameContainer;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState {

	String gameTitleLabel = "Space Commanders.";
	//String joinGameOption = "Join Game.";
	String multiplayerGameOption = "Multiplayer.";
	//String hostDedGameOption = "Host Dedicated Game.";
	String singlePlayerOption = "Single Player.";
	String mousePosition = "No mouse input";
	String mouseClickedOn = "No mouse clicks yet";
	Input input;
	
	
	int stateID;

	public MainMenuState(int state) {
		stateID = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		input = gc.getInput();
		// start GameClient from here
		// TODO Auto-generated method stub

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub

		g.drawString(gameTitleLabel, 50, 50);
		g.drawString(multiplayerGameOption, 50, 150);
		g.drawRect(45, 145, 120, 30);
		g.drawString(singlePlayerOption, 50, 100);
		g.drawRect(45, 95, 135, 30);
		g.drawString(mousePosition, 250, 10);
		g.drawString(mouseClickedOn, 400, 200);


	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
		// TODO Auto-generated method stub
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		
		// idea: right clicking gets info (in a context menu thing) about a unit etc
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			if(sbg.getCurrentStateID() == this.stateID){
				if(xPos >= 45 && xPos <= 180 && yPos >= 355 && yPos <= 385){
					mouseClickedOn = "Clicked on " + singlePlayerOption;
					sbg.enterState(1);
				} else if(xPos >= 45 && xPos <= 150 && yPos >= 305 && yPos <= 335) {
					mouseClickedOn = "Clicked on " + multiplayerGameOption;
					sbg.enterState(2);
				} else {
					mouseClickedOn = "Clicked on nothing.";
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

// many thanks to thenewboston for help with this