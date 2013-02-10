package states;

import org.newdawn.slick.GameContainer;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState {

	String gameTitleLabel = "Space Commanders.";
	String joinGameOption = "Join Game.";
	String hostGameOption = "Host Game.";
	String hostDedGameOption = "Host Dedicated Game.";
	String singlePlayerOption = "Single Player.";
	String mousePosition = "No mouse input";
	String mouseClickedOn = "No mouse clicks yet";
	
	int stateID;
	
	public MainMenuState(int state) {
		stateID = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
		// start GameClient from here
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		
		g.drawString(gameTitleLabel, 50, 50);
		g.drawString(joinGameOption, 50, 100);
		g.drawRect(45, 95, 105, 30);
		g.drawString(hostGameOption, 50, 150);
		g.drawRect(45, 145, 105, 30);
		g.drawString(hostDedGameOption, 50, 200);
		g.drawRect(45, 195, 190, 30);
		g.drawString(singlePlayerOption, 50, 250);
		g.drawRect(45, 245, 135, 30);
		g.drawString(mousePosition, 250, 10);
		g.drawString(mouseClickedOn, 400, 200);
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		mousePosition = ("Mouse position is: " +xPos + ", " + yPos);
		if(Mouse.isButtonDown(Input.MOUSE_LEFT_BUTTON)){
			if(xPos >= 45 && xPos <= 150 && yPos >= 355 && yPos <= 385){
				mouseClickedOn = "Clicked on " + joinGameOption;
				sbg.enterState(1);
			} else 
			if(xPos >= 45 && xPos <= 150 && yPos >= 305 && yPos <= 335) {
				mouseClickedOn = "Clicked on " + hostGameOption;
				sbg.enterState(1);
			} else 
			if(xPos >= 45 && xPos <= 235 && yPos >= 255 && yPos <= 285) {
					mouseClickedOn = "Clicked on " + hostDedGameOption;
			} else
			if(xPos >= 45 && xPos <= 180 && yPos >= 205 && yPos <= 235) {
					mouseClickedOn = "Clicked on " + singlePlayerOption;
			} else {
				mouseClickedOn = "Clicked on nothing.";
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