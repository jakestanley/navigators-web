package chambers;

public class Chamber {

	// shipID is used to attach a chamber to a ship - unnecessary as i can use the shipID with getElementAt!
	//private int shipID;
		
	// short description of the chamber, but i will put this in a 
	// central class that can be called later on rather than put the 
	// same description in each instance of a chamber. i can save 
	// more space later..
	
	public boolean isOnFire, isUnderRepair;
	public int chamberSize, o2Level, chamberDamage;

	public Chamber(int size){
		
		chamberSize = size;
		isOnFire = false;
		isUnderRepair = false;
		o2Level = 100;
		chamberDamage = 0;
	}
}

// there are fifteen types of chamber
// of these fifteen types, there are seven MANDATORY chambers that a ship must have:- 
// bridge, life support, reactor chamber, equipment room, docking, fuel tank and an engine room
// the rest of the chambers are optional