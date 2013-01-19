package chambers;

public class FuelTank extends Chamber {

	private int fuelLevel;
	private int fuelCapacity;
	
	
	// fuel tank when created has a full tank
	public FuelTank(int size, int capacity) {
		super(size);
		// TODO Auto-generated constructor stub
		
		fuelLevel = capacity;
		fuelCapacity = capacity;
		
	}

}
