package uk.co.jakestanley.sc.states;

import org.newdawn.slick.GameContainer;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState {

	Image scLogo;
	
	String multiplayerGameOption = "Multiplayer.";
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
		scLogo = new Image("res/img/mainLogoTemp.png");

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		g.setBackground(new Color(127, 127, 127));
		scLogo.draw(50, 50);
		g.drawString(singlePlayerOption, 50, 140);
		g.drawRect(45, 135, 135, 30);
		g.drawString(multiplayerGameOption, 50, 190);
		g.drawRect(45, 185, 120, 30);
		
//		g.drawString(mousePosition, 250, 10);
//		g.drawString(mouseClickedOn, 400, 200);
		

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
				if(xPos >= 45 && xPos <= 180 && yPos >= 315 && yPos <= 345){
					mouseClickedOn = "Clicked on " + singlePlayerOption;
					//sbg.enterState(1);
				} else if(xPos >= 45 && xPos <= 150 && yPos >= 265 && yPos <= 295) {
					//mouseClickedOn = "Clicked on " + multiplayerGameOption;
					sbg.enterState(2);
				} else {
					//mouseClickedOn = "Clicked on nothing.";
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