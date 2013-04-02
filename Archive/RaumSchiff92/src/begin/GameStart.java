package begin;

import gui.GUI;

import java.util.Date;
import changers.DamageShip;
import lists.ShipList;
import classes.Ship;

public class GameStart {
	
	//just below is the version information; i.e boring bollocks...
	
	public static String version;

	public static void main (String[] args) {
		
		// need to implement a GUI
				// need to implement a load and save function
				// need to implement options, etc
				
				// when the main method is initiated, the universe generator generates the universe (surprise, surprise)
				// then the ship is spawned
		
		version = "0.05";
		newGame(); // now the universe generation and player ship spawning is done via the 'newGame' method
						
	}

	public static void newGame(){
		System.out.println("Running RaumSchiff92 by Jake Stanley @ Boundary, " + "INSERT DATE HERE");
		UniverseGenerator makeuniverse = new UniverseGenerator();
		DamageShip damageship = new DamageShip();
		makeuniverse.generateUniverse();
		GUI gooey = new GUI();
		
		//above is all the pre-gui stuff for starting a new game, followed by the gui code, which i haven't made yet 
		
		}
}