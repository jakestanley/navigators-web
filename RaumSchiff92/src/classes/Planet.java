package classes;

public class Planet {

	public int sectorID;
	public int planetID;
	public int planetSize;
	public int planetPopulation;
	public int maxPopulation;
	public int numberOfMoons;

	//factors and technology which allow increase of max population
	//need to balance the planet's economy, i.e enough food and water

	//need things like gases, i.e nitrogen, hydrogen, oxygen in atmosphere
	//what kind of materials can be mined from a planet
	//lower chance of generating a planet where diamonds can be mined
	//or make it expensive/difficult to mine for certain materials

	public boolean isInhabited;
	public boolean isMinable;
	public boolean isHarvestable;
	public boolean isPlayerControlled;
	public boolean isPopulaceHostile;


	public Planet(int secID, int planID, boolean inhabited, int size, int pop) {

		//when the universe is generated, the sector ID represents what sector the planet is in

		sectorID = secID;
		planetID = planID;
		isInhabited = inhabited;
		planetSize = size;
		planetPopulation = pop;
		//  sort out max population later
		//	maxPopulation = maxpop;

	}
	
}


//populace will be hostile if the planet is in a hostile sector
//is the planet hostile, or is the government hostile?
//could the populace be rebellious??

// public boolean isPopulaceRebellious	

