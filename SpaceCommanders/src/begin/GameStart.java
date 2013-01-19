package begin;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import ships.Ship;
import ships.ShipUpgrader;
import begin.ShipList;

public class GameStart {

	public GameStart() {
		
	}

	public ShipList shiplist;
	public ShipUpgrader upgrader;
	public static boolean gameRunning = false;
	
	public static void main(String[] args) throws InterruptedException, SlickException {
			
		AppGameContainer game = new AppGameContainer(new Game("Space Commanders"));
		game.setDisplayMode(800, 600, false);
		game.start();
		
		//setupGame();
		//startGame();
		
	}

	/*	
	private static void setupGame() {
		// TODO do all the prepare the game world and objects withiny stuff here
		ShipList shiplist = new ShipList();
		ShipUpgrader upgrader = new ShipUpgrader();
		gameRunning = true;
	}
	
	private static void startGame() throws InterruptedException {
		// TODO do all the game starty stuff here
		int i = 0;
		while(gameRunning == true) {
			// System.out.println(i);
			Thread.sleep(100);
			// i++;
		}
	}*/
}
