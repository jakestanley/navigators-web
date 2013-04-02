package chambers;

public class Teleporters extends Chamber {

	public int teleporterCapacity;
	public int teleporterRange;	
	
	// variables like range, recharge speed, etc
	
	public Teleporters(int size, int capacity, int range) {
		super(size);
		// TODO Auto-generated constructor stub
		
		teleporterCapacity = capacity;
		teleporterRange = range;
		
	}

}
