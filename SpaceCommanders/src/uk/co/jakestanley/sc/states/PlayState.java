package uk.co.jakestanley.sc.states;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import uk.co.jakestanley.sc.begin.Game;
import uk.co.jakestanley.sc.ships.Ship;


public class PlayState extends BasicGameState {

	private int stateID;
	private float shipHealth;
	private String shipName, playerName;
	int xPos, yPos;
	Input input;
	
	public PlayState(int state){
		stateID = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		// TODO Auto-generated method stub
		input = gc.getInput();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		// initially draw strings and images here
		g.drawString("Ship Name: " + shipName, 50, 50);
		g.drawString("Pilot name: " + playerName, 50, 100);
		g.drawString("Ship Health: " + shipHealth, 50, 150);
		g.drawString("FIRE @ 0", 50, 400);
		g.drawRect(45, 395, 100, 30);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		// update strings and images here
		// gets ship information from local Ship instance
		
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		
		try {
			shipName = Game.client.localShip.shipName;
		} catch(Exception e){
			shipName = "null";
		}
		try {
			playerName = Game.client.localShip.playerName;
		} catch(Exception e) {
			playerName = "null";
		} 
		try {
			shipHealth = Game.client.localShip.shipHealth;
		} catch(Exception e){
			shipHealth = 0;
		}
		
		
		
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			if(sbg.getCurrentStateID() == this.stateID){
				if(xPos >= 45 && xPos <= 145 && yPos >= 55 && yPos <= 85){
					Game.client.basicAttack(0);
					// need to handle quitting the game
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
