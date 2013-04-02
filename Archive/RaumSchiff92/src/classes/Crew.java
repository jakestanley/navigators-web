package classes;

public class Crew {
	
	private String crewName;
	private String crewType;
	private int healthLevel;
	private int armourLevel;
	private int oxygenLevel;
	private int ammunition;
	private int proficiency;
	private int morale;
	private boolean hasTank;
	private boolean hasRepairTool;
	private boolean hasGun;
	private boolean isHealing;
	private boolean isOutside;
	private boolean isEngineer;
	private boolean isSoldier;
	private boolean isMedic;
	private boolean isHostile;
	
	public Crew(String name, String type, int health, int armour, int oxygen, int ammo, int prof, int mor, boolean tank, boolean tool, boolean gun, 
			boolean healing, boolean outside, boolean engineer, boolean soldier, boolean medic, boolean hostile){
		crewName = name;
		crewType = type;
		healthLevel = health;
		armourLevel = armour;
		oxygenLevel = oxygen;
		ammunition = ammo;
		proficiency = prof;
		morale = mor;
		hasTank = tank;
		hasRepairTool = tool;
		hasGun = gun;
		isHealing = healing;
		isOutside = outside;
		isEngineer = engineer;
		isSoldier = soldier;
		isMedic = medic;
		isHostile = hostile;
	}

}
