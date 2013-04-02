package chambers;

public class WeaponRoom extends Chamber {
	
	public int heatLevel;
	public int weaponType;
	public int weaponStrength;
	public int weaponAmount;
	
	public WeaponRoom(int size, int wType, int wStrength, int wAmount) {
		super(size);
		
		heatLevel = 0;
		weaponType = wType;
		weaponStrength = wStrength;
		weaponAmount = wAmount;
		
	}

}
