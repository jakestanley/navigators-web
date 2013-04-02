package chambers;

public class ShieldGenerator extends Chamber {
	
	public boolean isShieldOn;
	public int shieldStrength;
	public int shieldLevel;
	public int shieldMax;
	public int regenerationRate;

	
	// as in the fuel tank class, shield generators are created fully charged
	public ShieldGenerator(int size, int strength, int regen) {
		super(size);
		// TODO Auto-generated constructor stub
		
		isShieldOn = true;
		shieldStrength = strength;
		shieldLevel = 100;
		shieldMax = 100;
	// the shield always goes up to 100 percent
	// level increasing affects strength (resistance) 
	//	and regen rate
		regenerationRate = regen;
		
	}
	

}
