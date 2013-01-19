package chambers;

public class EquipmentRoom extends Chamber{

	private int amountOxygenTanks;
	private int amountSuits;
	private int amountTools;
	private int amountLaserRifles;
	private int amountLaserBatteries;
	private int amountToolBatteries;
	private int amountExtinguisher;
	
	public EquipmentRoom(int size) {
		super(size);
		// TODO Auto-generated constructor stub
		
		amountOxygenTanks = 20;
		amountSuits = 4;
		amountTools = 2;
		amountLaserRifles = 2;
		amountLaserBatteries = 8;
		amountToolBatteries = 8;
		amountExtinguisher = 20;
		
	}

}
