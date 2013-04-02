package chambers;

public class WarpRoom extends Chamber {

	public int heatLevel;
	public int warpRange;
	public int warpUsage;
	
	public WarpRoom(int size, int range, int usage) {
		super(size);
		// TODO Auto-generated constructor stub
		
		heatLevel = 0;
		warpRange = range;
		warpUsage = usage;
		
	}

}
