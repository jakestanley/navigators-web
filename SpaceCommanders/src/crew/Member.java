package crew;

/**
 * All crew member types inherit from this class.
 * Genders: 0 = male, 1 = female
 * Rank: 0 = private, 1 = corporal, 2 = sergeant, 3 = captain, 4 = brigadier
 * Crew ID will be a pseudo primary key. It cannot be changed.
 * ShipID can be changed if a crew member defers.
 * High skill crew member is more likely to defer at low morale.
 */

public class Member {
	
	int rank, shipID, crewID, skill, gender, morale;
	String firstName, lastName;
	
	public Member(String fName, String lName, int sID, int cID, int sex){
		this.firstName = fName; this.lastName = lName;
		this.rank = 0; this.skill = 0;
		this.shipID = sID; this.crewID = cID;
		this.morale = 0; this.gender = sex;
	}
	
	public void setShipID(int shipID) {
		// if statement against ships, to make sure the target ship is actually in the list of ships 
		this.shipID = shipID;
	}
	
	public int getShipID() {
		return this.shipID;
	}
	
	public int getMorale() {
		return morale;
	}

	public boolean raiseMorale(int by) {
		boolean success = false;
		if((this.morale + by) >= 50){
			this.morale = 50;
			success = true;
		} else if((this.morale + by) < 50){
			this.morale = this.morale + by;
			success = true;
		}
		return success;
	}
	
	public boolean lowerMorale(int by) {
		boolean success = false;
		if((this.morale - by) <= -49){
			this.morale = -49;
			success = true;
		} else if((this.morale - by) > -49){
			this.morale = this.morale - by;
			success = true;
		}
		return success;
	}

	public int getSkill() {
		return this.skill;
	}

	public boolean improveSkill() {
		// If less than max skill, improves skill and returns true
		boolean success = false;
		if(this.skill < 100){
			this.skill = skill++;
			success = true;
		} 
		return success;
	}
	
	public boolean reduceSkill() {
		// If more than min skill, decreases kill and returns true
		boolean success = false;
		if(this.skill > -20){
			this.skill = skill--;
			success = true;
		} 
		return success;
	}

	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public int getGender() {
		return this.gender;
	}

	public int getRank(){
		return this.rank;
	}
	
	public int getCrewID(){
		return this.crewID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void switchGender(){
		if(this.gender == 0){
			this.gender = 1;
		} else {
			this.gender = 0;
		}		
	}
	
	public boolean promote(){
		boolean success = false;
		if(rank < 4){
		rank++;
		success = true;
		}
		return success;
	}
	
	public boolean demote(){
		boolean success = false;
		if(rank > 0){
			rank--;
			success = true;
		}
		return success;
	}
	
}
