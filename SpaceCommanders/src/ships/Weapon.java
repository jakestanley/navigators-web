package ships;

import begin.Game;

/**
 * If the weapon loses power, the charged energy is lost.
 * Engaged means slightly different things for rapid fire
 * and charged shots. When charged shots are engaged, the 
 * weapon is charging (if charge time is set). Charged 
 * shots can be fired manually or set to 'fireWhenReady' 
 * When rapid fire is engaged, the weapon fires 
 * automatically, regardless.
 * 
 * Engaged could be summed up as 'powered'
 * Power usage could be set to a constant and the power is returned 
 * when the weapon is disengaged.
 * 
 * Rapid fire needs time to warm up. You must disengage the 
 * weapons before changing the settings. Lock settings when 
 * weapon is engaged. Weapon screens on bridge are powered by 
 * auxiliary power. You can change weapon settings with no power 
 * to weapons.
 * 
 * @author Jake Stanley
 */

public class Weapon extends Component {

	float powerLevel, savedPowerLevel; // savedPowerLevel is for saving powerLevel when disengaging, so it doesn't have to be set when re-engaging
									   // if there is not enough available power on re-engage, the Weapon will default to 0% or something like that
	float strength, concentrate, chargeTime, fireRate;
	boolean isCharged, isRapid, isEngaged, fireWhenReady;

	public Weapon(int shipID){
		super(shipID);
		powerLevel = 0; // HOW MUCH POWER THE WEAPON HAS FROM THE REACTOR
		isEngaged = false;
		isCharged = false;
		fireWhenReady = false;
		strength = -1; // THIS IS HOW POWERFUL THE LASER WILL BE
		concentrate = -1;
		chargeTime = -1;
		fireRate = -1;
	}
	
	public boolean setPowerLevel(float newPowerLevel){
		// TODO check if this works properly. test vigorously.
		boolean success = false;
		boolean checkout;
		if(newPowerLevel != powerLevel){
			if(newPowerLevel > powerLevel){
				float powerRequest = newPowerLevel - powerLevel;
				checkout = Game.setup.shipList.get(shipID).shipReactor.increaseUsage(powerRequest);
				if(checkout){
					powerLevel = newPowerLevel;
					success = true;
				}
			} else {
				float powerRequest = powerLevel - newPowerLevel;
				checkout = Game.setup.shipList.get(shipID).shipReactor.decreaseUsage(powerRequest);
				if(checkout){
					powerLevel = newPowerLevel;
					success = true;
				}
			}		
		}
		if(!success){
			System.out.println("Setting power was unsuccessful.");
		}
		return success;
	}
	
	public float getPowerLevel(){
		return this.powerLevel;
	}

	
	
	public boolean calculate(){
		// TODO need to work out and calculate an estimated accuracy for distance. random roll for whether it hits or not?
		boolean success = false;
		if(isRapid){
			// TODO calculate for rapid fire
			// success is only true if correct values are able to be calculated.
		} else {
			// TODO calculate for single shot
		}
		return success;
	}

	public void togglefireWhenReady(){
		if(this.fireWhenReady){
			this.fireWhenReady = false;
		} else {
			this.fireWhenReady = true;
		}
	}
	
	public void fire(){
		// TODO - manual weapon firing?
	}
	
	public boolean engage(){ // Small chance of failure on engage at low Weapon health?
		boolean success = false;
		if(!isEngaged){
			isEngaged = true;
			isCharged = false; // Just in case something went wrong and Weapon disengaged without discharging, or was initiated charged.
			if(calculate()){ // Calculates. If calculate is not successful, the method will return false and I'll find a cool way of letting the player know 
				success = true; // then start charging weapon or rapid firing. call fire method
				fire(); // probably not as easy as this.
			} else {
				disengage(); // Disengages if calculate returned false.
			}
		}
		return success; // When returning true, weapon boots and starts charging (and autofiring if enabled) or rapid firing, depending on the fire mode.
	}
	
	public boolean disengage(){
		boolean success = false;
		if(isEngaged){
			isEngaged = false; 
			isCharged = false; // The charge gets flushed. Maybe I should request the user fire at something? It's destructive energy, so it's gotta go somewhere. 
			success = true;
		}
		return success;
	}
	
	public boolean setStrength(float strn){
		boolean success = false;
		if(strn >= 0 && strn <= 100){
			this.strength = strn;
			success = true;
		}
		return success;
	}

	public boolean setConcentrate(float conc){
		boolean success = false;
		if(conc >= 0 && conc <= 100){
			this.concentrate = conc;
			success = true;
		}
		return success;
	}
	
	public void unsetAll(){ // Restores weapon to 'factory settings'
		powerLevel = 0;
		isEngaged = false;
		isCharged = false;
		fireWhenReady = false;
		strength = -1;
		concentrate = -1;
		chargeTime = -1;
		fireRate = -1;
	}
	
	// DEBUGGING/TESTING METHODS BELOW...
	
	public String getWeaponStatus(){
		String firingMode = "";
		if(isRapid){
			firingMode = "RAPID FIRE, ";
		} else if(!isRapid){
			firingMode = "SINGLE SHOT, ";
			if(isCharged){
				firingMode += "CHARGED, ";
			} else {
				firingMode += "NOT CHARGED, ";
			}
		}
		if(isEngaged){
			firingMode += "ENGAGED";
		} else {
			firingMode += "DISENGAGED";
		}
		if(!isRapid){
			if(fireWhenReady){
				firingMode += ", FIRING WHEN READY";
			} else {
				firingMode += ", MANUAL FIRE";
			}
		}
		return firingMode;
	}
	
	public String getWeaponConfiguration(){

		// TODO
		// SINGLE SHOT: SS/CC Charge time: Ct
		// RAPID FIRE: SS/CC Rate of fire: RoF
		// NS = not set

		String settings = ("");
		if(this.strength > 0){
			settings += (this.strength + "/");
		} else {
			settings += ("NS/");
		}
		if(this.concentrate > 0){
			settings += (this.concentrate + ", ");
		} else {
			settings += ("NS, ");
		}
		if(isRapid){
			settings += ("Fire Rate => ");
			if(fireRate > 0){
				settings += (this.fireRate + "spm");
			} else {
				settings += ("NOT SET");
			}
		} else {
			settings += ("Charge Time => ");
			if(this.chargeTime > 0){
				settings += (this.chargeTime + "s");
			} else {
				settings += ("NOT SET");
			}
		}
		return settings;
	}
}
