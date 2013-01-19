package chambers;

public class Engine extends Chamber{

	private int engineEfficiency;
	private int engineSpeed;
	private int engineMax;
	private int heatLevel;
	
	public Engine(int size, int efficiency, int max) {
		super(size);
		// TODO Auto-generated constructor stub
		
		engineEfficiency = efficiency;	
		engineSpeed = max;
		engineMax = max;
		heatLevel = 0;
		
	}

}
