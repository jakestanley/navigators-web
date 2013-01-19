package chambers;

public class Cryo extends Chamber{
	
	public int cryoCapacity;
	public int availableChambers;

	public Cryo(int size, int capacity) {
		super(size);
		
		cryoCapacity = capacity;
		availableChambers = capacity;
		
	}

}
