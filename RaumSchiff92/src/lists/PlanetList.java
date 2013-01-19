package lists;

import java.util.ArrayList;
import lists.SectorList;

import classes.Planet;
import begin.NumberGets;

public class PlanetList extends ArrayList {

	private int planetID;
	private int sectorID;
	boolean inhabit = false;
	long time1;
	long time2;
	String time3;
	
	NumberGets generator = new NumberGets();
	
	public ArrayList<Planet> planetlist = new ArrayList<Planet>();

	public PlanetList(){

	}

	public void setup() {

		System.out.println("Generating and populating planets...");
		time1 = System.currentTimeMillis();
		sectorID = 0;
		planetID = 0;		
		
		// this part of the code creates the home world that the player starts landed on
		// need to change the 'getRandom0to5' code, so it generates a number from one to five for the planet
		// perhaps an if statement that makes a new random number if it hits a zero??
		
		inhabit = true;
		planetlist.add(new classes.Planet(0, 0, true, generator.getRandom0to5(), setPopulation()));
		planetID++;	
		
		for(int i = 1; i < SectorList.sectorlist.size(); i++) {
			
			// if the sector has a sun, then run the commands to generate a random amount of planets
			// else increment the sector ID and repeat until there are no more sectors to work with		
			
			if(SectorList.sectorlist.get(sectorID).getHasSun() == true){
				//  fix this lazy programming later. please don't hate me :P
				
				// this first if statements grants a one in two chance that a planet will be generated
				if (generator.getRandomBoolean() == true){
					// the inhabit variable needs to be reset to false, in case a previous generation set it to true
					inhabit = false;
					// this second if statement grants a one in two chance that the planet will be inhabited
					if(generator.getRandomBoolean() == true){
						// if the planet is inhabitable, then inhabit is set to true
						inhabit = true;
					}
					planetlist.add(new classes.Planet(sectorID, planetID, inhabit, generator.getRandom0to5(), setPopulation()));
					//System.out.println(planetlist.get(planetID).planetPopulation);
					planetID++;
				}
				// this first if statements grants a one in two chance that a planet will be generated
				if (generator.getRandomBoolean() == true){
					// the inhabit variable needs to be reset to false, in case a previous generation set it to true
					inhabit = false;
					// this second if statement grants a one in two chance that the planet will be inhabited
					if(generator.getRandomBoolean() == true){
						// if the planet is inhabitable, then inhabit is set to true
						inhabit = true;
					}
					planetlist.add(new classes.Planet(sectorID, planetID, inhabit, generator.getRandom0to5(), setPopulation()));
					//System.out.println(planetlist.get(planetID).planetPopulation);
					planetID++;
				}
				// this first if statements grants a one in two chance that a planet will be generated
				if (generator.getRandomBoolean() == true){
					// the inhabit variable needs to be reset to false, in case a previous generation set it to true
					inhabit = false;
					// this second if statement grants a one in two chance that the planet will be inhabited
					if(generator.getRandomBoolean() == true){
						// if the planet is inhabitable, then inhabit is set to true
						inhabit = true;
					}
					planetlist.add(new classes.Planet(sectorID, planetID, inhabit, generator.getRandom0to5(), setPopulation()));
					//System.out.println(planetlist.get(planetID).planetPopulation);
					planetID++;
				}
				// this first if statements grants a one in two chance that a planet will be generated
				if (generator.getRandomBoolean() == true){
					// the inhabit variable needs to be reset to false, in case a previous generation set it to true
					inhabit = false;
					// this second if statement grants a one in two chance that the planet will be inhabited
					if(generator.getRandomBoolean() == true){
						// if the planet is inhabitable, then inhabit is set to true
						inhabit = true;
					}
					planetlist.add(new classes.Planet(sectorID, planetID, inhabit, generator.getRandom0to5(), setPopulation()));
					//System.out.println(planetlist.get(planetID).planetPopulation);
					planetID++;
				}
				// this first if statements grants a one in two chance that a planet will be generated
				if (generator.getRandomBoolean() == true){
					// the inhabit variable needs to be reset to false, in case a previous generation set it to true
					inhabit = false;
					// this second if statement grants a one in two chance that the planet will be inhabited
					if(generator.getRandomBoolean() == true){
						// if the planet is inhabitable, then inhabit is set to true
						inhabit = true;
					}
					planetlist.add(new classes.Planet(sectorID, planetID, inhabit, generator.getRandom0to5(), setPopulation()));
					//System.out.println(planetlist.get(planetID).planetPopulation);
					planetID++;
				}
				// this first if statements grants a one in two chance that a planet will be generated
				if (generator.getRandomBoolean() == true){
					// the inhabit variable needs to be reset to false, in case a previous generation set it to true
					inhabit = false;
					// this second if statement grants a one in two chance that the planet will be inhabited
					if(generator.getRandomBoolean() == true){
						// if the planet is inhabitable, then inhabit is set to true
						inhabit = true;
					}
					planetlist.add(new classes.Planet(sectorID, planetID, inhabit, generator.getRandom0to5(), setPopulation()));
					//System.out.println(planetlist.get(planetID).planetPopulation);
					planetID++;
				}
				sectorID++;
			}
			else {
				sectorID++;
			}
			
		}
		for(int i = 0; i < planetlist.size(); i++) {
			if(planetlist.get(i).isInhabited == true){
				System.out.println("Planet " + planetlist.get(i).planetID + " is in sector " + planetlist.get(i).sectorID + " and is inhabited by " + planetlist.get(i).planetPopulation + " citizens.");
			}
			else{
				System.out.println("Planet " + planetlist.get(i).planetID + " is in sector " + planetlist.get(i).sectorID + " and is uninhabited.");
			}
		}
		time2 = System.currentTimeMillis();
		time3 = String.valueOf(time2 - time1);
		System.out.println("Planet generation and population took " + time3 + " milliseconds...");
	}
	public int setPopulation() {
		int population;
		population = 0;
		if (inhabit == true) {
			population = generator.getRandom1to1000000();
		}
		return population;
	}
	// after making the planets, run some random number generators to determine harvestable, 
	// mineable, etc planets
	
	// bug exists where an inhabited planet can possibly have zero citizens, as the setPopulation method calculates a random
	// number between 0 and 1000, as opposed to 1 and 1000 - FIXED!
	
	// need a field for planet military strength, faction allegiance, etc
	// a planet with poor connections and/or poor military will be easy to control, for example.
	
	
}