package classes;

public class Sector {
	
	private int sectorID;
	private boolean isFriendly;
	private boolean hasSun;
	private int sizeOfSun;
	private int heatOfSun;
	
	public Sector(int sector, boolean friendly, boolean sun, int sunSize, int sunHeat) {
		
		setSectorID(sector);
		setFriendly(friendly);
		setHasSun(sun);
		setSizeOfSun(sunSize);
		setHeatOfSun(sunHeat);
		
	}

	public int getSectorID() {
		return sectorID;
	}

	public void setSectorID(int sectorID) {
		this.sectorID = sectorID;
	}

	public boolean isFriendly() {
		return isFriendly;
	}

	public void setFriendly(boolean isFriendly) {
		this.isFriendly = isFriendly;
	}

	public boolean getHasSun() {
		return hasSun;
	}

	public void setHasSun(boolean hasSun) {
		this.hasSun = hasSun;
	}

	public int getSizeOfSun() {
		return sizeOfSun;
	}

	public void setSizeOfSun(int sizeOfSun) {
		this.sizeOfSun = sizeOfSun;
	}

	public int getHeatOfSun() {
		return heatOfSun;
	}

	public void setHeatOfSun(int heatOfSun) {
		this.heatOfSun = heatOfSun;
	}

}
