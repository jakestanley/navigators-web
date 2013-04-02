package changers;

public class DamageShip {

	public int oldValue;
	public int modifier;
	public int newValue;

	// this will become more complex as the game develops

	public DamageShip(){

	}
	
	public int doDamage(int old, int mod){

		int newV;
		newV = old - mod;
		return newV;
	
	}

}
