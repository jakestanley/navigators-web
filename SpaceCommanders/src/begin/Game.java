package begin;

import java.io.IOException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public class Game extends BasicGame{
	
	public static Setup setup;
	public Game(String title) {
		super("Space Commanders");
	}
	
	public static void main(String[] args) throws SlickException {
			
		AppGameContainer game = new AppGameContainer(new Game("Space Commanders"));
		game.setDisplayMode(800, 600, false);
		game.setTargetFrameRate(60);
		try {
			setup = new Setup(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//game.start();
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.drawString(setup.client.getClientStatus(), 100, 100);
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
