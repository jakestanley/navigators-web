package uk.co.jakestanley.sc.ships;

/**
 * Reactor capacity can be distributed to the various systems of the ship. Integral ship components such as life support must 
 * have constant power to keep the ship atmosphere livable for the crew. Without life support left unpowered, ship living 
 * conditions will deteriorate to the point where the everything living dies.
 * 
 * Auxiliary distribution is used for minor ship functions such as automatic doors, lights, screens, interfaces, etc. 
 * When reducing the auxiliary distribution, the bridge functions will be the last to go. Auxiliary power is controlled by 
 * a switch on the commander's chair. It is locked at 5% distribution and is required for starting and restarting the ship.
 * 
 * Weapon distribution affects the weapon's recharge rate, engine distribution affects speed and manoeuvrability.
 * Missile/torpedo systems will not load and weapons will not charge unless weapon distribution is at least 5%.  
 * 
 */

public class Reactor extends Component{
	
	float usage, weaponDistribution, engineDistribution, lifeDistribution, auxDistribution;
	
	public Reactor(int sessionID){
		super(sessionID);
		this.usage = 0;		
	}
	
	public float getUsage() {
		return this.usage;
	}
	
	/** 
	 * Only on returning true, will the method accessing the 
	 * Reactor class update its values. That way Reactor usage 
	 * should never be out of the 0.0 to 100.0 inclusive range. 
	 * 
	 * The same applies for the decreaseUsage() method.
	 */
	
	public boolean increaseUsage(float request) {
		boolean success = false;
		if((this.usage + request) > 100){
			// Do nothing for now... TODO
		} else {
			this.usage = this.usage + request;
			success = true;
		}
		return success;
		
	}
	
	public boolean decreaseUsage(float request){
		boolean success = false;
		if((this.usage - request) < 0){
			// Do nothing for now... TODO
		} else {
			this.usage = this.usage - request;
			success = true;
		}
		return success;
	}

}
