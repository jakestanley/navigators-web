package uk.co.jakestanley.sc.crew;

import java.util.Random;

/**
 * All crew member types inherit from this class.
 * Genders: 0 = male, 1 = female
 * Rank: 0 = private, 1 = corporal, 2 = sergeant, 3 = captain, 4 = brigadier
 * Instead of creating separate classes, I'll just have type.
 * Crew ID will be a pseudo primary key. It cannot be changed.
 * ShipID can be changed if a crew member defers.
 * High skill crew member is more likely to defer at low morale.
 */

public class Member {

	// New skill types: 

	int rank, shipID, crewID, gender, morale, age, dest, where; 
	int engSkill, fightSkill, helmSkill;
	String firstName, lastName;

	public Member(String fName, String lName, int sID, int cID, int sex){
		Random rand = new Random();
		this.age = rand.nextInt(50 - 18 + 1) + 18;
		this.firstName = fName; this.lastName = lName;
		this.rank = 0; 
		this.engSkill = 0; this.fightSkill = 0; this.helmSkill = 0; 
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

	public int getSkill(int skillType) {
		int skill;
		switch(skillType){
		case 0:
			skill = this.engSkill;
			break;
		case 1:
			skill = this.fightSkill;
			break;
		case 2:
			skill = this.helmSkill;
			break;
		default:
			skill = -99; // If this is returned, the caller should know what to do.
			break;
		}
		return skill;
	}

	public boolean improveSkill(int skillType) { // If less than max skill, improves skill and returns true
		boolean success = false;
		switch(skillType){
		case 0:
			if(this.engSkill < 100){
				this.engSkill = engSkill++;
				success = true;
			}
			break;
		case 1:
			if(this.fightSkill < 100){
				this.fightSkill = fightSkill++;
				success = true;
			}
			break;
		case 2:
			if(this.helmSkill < 100){
				this.helmSkill = helmSkill++;
				success = true;
			}
			break;
		}
		return success;
	}

	public boolean reduceSkill(int skillType) {
		boolean success = false;
		switch(skillType){
		case 0:
			if(this.engSkill > -20){
				this.engSkill = engSkill--;
				success = true;
			}
			break;
		case 1:
			if(this.fightSkill > -20){
				this.fightSkill = fightSkill--;
				success = true;
			}
			break;
		case 2:
			if(this.helmSkill > -20){
				this.helmSkill = helmSkill--;
				success = true;
			}
			break;
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

	// DEV & TESTING METHODS BELOW

	public String getRankAsString(){
		String rankString = "";
		switch (rank) {
		case 0: rankString = "private";
		break;
		case 1: rankString = "corporal";
		break;
		case 2: rankString = "sergeant";
		break;
		case 3: rankString = "brigadier";
		}


		return rankString;
	}

	public String getSexAsString(){
		String sex = "";
		switch (gender) {
		case 0: 	sex = "male";
		break;
		case 1: 	sex = "female";
		break;
		default:	sex = "gender ambiguous";
		break;
		}
		return sex;	
	}
	
	public void printAllMemberInfo(){
		System.out.println("Crew ID: " + this.crewID + ", " + getFirstName() + " " + getLastName());
		System.out.println("Gender: " + this.getSexAsString() + ", Age: " + this.age);
		System.out.println("Rank: " + this.getRankAsString());
		System.out.println("Crewmember serves duties onboard ship id: " + getShipID()); // it will say position instead of crew member later, also fabulous will become 'wrecked' at some point if the ship is knackered etc

	}

}
