package chambers;

public class CargoHold extends Chamber{

	public int maxCargoSize;
	public int availableCargoSpace;
	
	public CargoHold(int size, int maxCargo) {
		super(size);
		
		maxCargoSize = maxCargo;
		availableCargoSpace = maxCargo;
		
	}

}
