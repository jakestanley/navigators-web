package chambers;

public class ComputerRoom extends Chamber{

	private int yottaFLOPS;
	private int heatLevel;
	
	// processing power of the ship's computer is measured in teraFLOPS. 100 teraFLOPS is the stock speed
	// the computer room serves as a way of increasing the ship's computational capability
	// all bridges are fitted with a standard, basic ship computer
	
	public ComputerRoom(int size, int speed) {
		super(size);
		// TODO Auto-generated constructor stub
		
		yottaFLOPS = speed;
		heatLevel = 0;
		
	}

}
