package ships;

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
	
	public Reactor(){
		super();
		this.usage = 0;
		this.weaponDistribution = 0; 
		this.engineDistribution = 0; 
		this.lifeDistribution = 0; 
		this.auxDistribution = 0;
		
	}
	
	public float getUsage() {
		System.out.println("Reactor at " + this.usage + "% capacity.");
		return this.usage;
	}
	
	public boolean canTakePower() {
		boolean canTakePower = false;
		if(getUsage() < 100){
			canTakePower = true;
		}
		return canTakePower;
	}
	
	public boolean canReturnPower() {
		boolean canReturnPower = false;
		if(getUsage() > 0){
			canReturnPower = true;
		}
		return canReturnPower;
	}

	public void increaseUsage() {
		if(this.usage < 100){
			this.usage = this.usage + 5;
		}
	}
	
	public void decreaseUsage(){
		if(this.usage > 0){
			this.usage = this.usage - 5;
		}
	}
	
	public float getDistribution(int type) {
		float dist = (Float) null;
		if(type == 0){
			dist = this.auxDistribution;
		}
		if(type == 1){
			dist = this.lifeDistribution;
		}
		if(type == 2){
			dist = this.engineDistribution;
		}
		if(type == 3){
			dist = this.weaponDistribution;
		}
		return dist;
	}
	
	public boolean increaseDistribution(int type) {
		boolean success = false;
		if(canTakePower()){
			if(type == 0){
				// should never be used, auxiliary power is fixed
				this.auxDistribution = this.auxDistribution + 5;
				success = true;
			} else if(type == 1){
				this.lifeDistribution = this.lifeDistribution + 5;
				success = true;
			} else if(type == 2){
				this.engineDistribution = this.engineDistribution + 5;
				success = true;
			} else if(type == 3){
				this.weaponDistribution = this.weaponDistribution + 5;
				success = true;
			}
			if(success == true){
				this.increaseUsage();
			}
		} else {
			System.out.println("Power output is " + getUsage() + "%. Reduce power usage elsewhere first.");
		}
		return success;
	}

	public boolean decreaseDistribution(int type) {
		boolean success = false;
		if(canReturnPower()){
			if(type == 0){
				// should never be used, auxiliary power is fixed
				// should only be changed by for enabling/disabling aux power
				this.auxDistribution = this.auxDistribution - 5;
				success = true;
			} else if(type == 1){
				this.lifeDistribution = this.lifeDistribution - 5;
				success = true;
			} else if(type == 2){
				this.engineDistribution = this.engineDistribution - 5;
				success = true;
			} else if(type == 3){
				this.weaponDistribution = this.weaponDistribution - 5;
				success = true;
			}
			if(success == true){
				this.decreaseUsage();
			}
		} else {
			System.out.println("Reactor at " + getUsage() + "% capacity.");
		}
		return success;
	}

}
