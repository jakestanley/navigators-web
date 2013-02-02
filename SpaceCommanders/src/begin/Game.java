package begin;

import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import ships.Reactor;
import ships.Ship;
import ships.Weapon;

public class Game extends BasicGame{

	ArrayList<Ship> shipList = new ArrayList<Ship>();
	ArrayList<Weapon> weaponList= new ArrayList<Weapon>();
	ArrayList<Reactor> reactorList = new ArrayList<Reactor>();
	
	public Game(String title) {
		super("Space Commanders");
	}
	
	public static void main(String[] args) throws SlickException {
			
		AppGameContainer game = new AppGameContainer(new Game("Space Commanders"));
		game.setDisplayMode(800, 600, false);
		game.start();
		
		//setupGame();
		//startGame();
		
	}
	
	@Override
	public void render(GameContainer gc, Graphics arg1) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		// TODO Auto-generated method stub
	}
}
