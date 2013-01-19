package lists;

import java.util.ArrayList;

import classes.Sector;
import begin.NumberGets;

public class SectorList extends ArrayList {

	private int setupVariable;

	NumberGets generator = new NumberGets();
	final static ArrayList<Sector> sectorlist = new ArrayList<Sector>();
	long time1;
	long time2;
	String time3;

	public SectorList() {

	}

	public void setup() {
		{
			System.out.println("Generating sectors...");
			time1 = System.currentTimeMillis();
			setupVariable = 0;
			//the bit of code below sets up the home sector, where the player character ship starts. this is always friendly and always
			//has a medium size and heat sun. for now, size works like this: 1 = very small, 2 = small, 3 = 
			//medium, 4 = large, 5 = very large
			sectorlist.add(new Sector(setupVariable, true, true, 3, 3));
			setupVariable++;
			// the next bit creates fifteen more sectors using random number generation
			// the setup variable can be changed to generate moar sectors;
			while(setupVariable <= 15) {
				sectorlist.add(new Sector(setupVariable, generator.getRandomBoolean(), generator.getRandomBoolean(), 
						generator.getRandom0to5(), generator.getRandom0to5()));
						setupVariable++;
			}

			for(int i = 0; i < sectorlist.size(); i++) {
				if(sectorlist.get(i).getHasSun() == true){
					System.out.println("Sector " + sectorlist.get(i).getSectorID() + " has a sun");
				}
				else {
					System.out.println("Sector " + sectorlist.get(i).getSectorID() + " does not have a sun");
				}
				
			}
			time2 = System.currentTimeMillis();
			time3 = String.valueOf(time2 - time1);
			System.out.println("Sector generation took " + time3 + " milliseconds...");
		}
	}
	
	// the method just below (getSectorListSize) may be redundant

	public static int getSectorListSize() {
		return sectorlist.size();
	}

	public boolean doesSectorHaveSun(int i){
		boolean o;
		o = sectorlist.get(i).getHasSun();
		return o;
	}

}

