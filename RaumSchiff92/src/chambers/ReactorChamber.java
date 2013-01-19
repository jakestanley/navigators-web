package chambers;

public class ReactorChamber extends Chamber {

	private int maxPowerOutput;
	private int availablePower;
	private int heatLevel;
	
	
	// construct - do the thing where the available power equals inputted maximum power as well as the max power output
	public ReactorChamber(int size, int maxPower) {
		super(size);
		
		maxPowerOutput = maxPower;
		availablePower = maxPower;
		heatLevel = 0;
	}

}
