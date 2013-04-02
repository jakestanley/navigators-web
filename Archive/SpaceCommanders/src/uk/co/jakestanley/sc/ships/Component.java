package uk.co.jakestanley.sc.ships;

/**
 * All ship components inherit from this class. 
 * I need a method that continuously works out the heat level based on the heat constant.
 * At 100% plus heat, the component takes health damage at a rate which increases with the 
 * heat level. The component will cease to function at 20% health and will explode at 0% 
 * health. If the heat level hits 150%, the component violently explodes regardless of 
 * health level.  
 */


public class Component {

	int shipID;
	float heat, heatConstant, health, coolant;
	
	public Component(int id){
		this.heat = 0; this.heatConstant = 0;
		this.health = 100; this.shipID = id;
	}
	
	public void setDamage(float damage) {
		this.health = damage;
	}
	
	public void setHeat(float heat) {
		// improve to incorporate heat constant
		this.heat = heat;
	}
	
	public void setHeatConstant(float constant){
		this.heatConstant = constant;
	}

	public float getHeat() {
		return heat;
	}
	
	public float getDamage() {
		return health;
	}

}
