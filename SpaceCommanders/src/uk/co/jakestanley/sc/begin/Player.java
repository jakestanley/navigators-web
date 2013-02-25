package uk.co.jakestanley.sc.begin;

public class Player {

	/**
	 * I'd like to make it so Player gets information from a saved file.
	 * It will be possible to load profiles, which will contain customisations,
	 * etc. Player information is used to attach Ships to a client.
	 * Player is dynamically created based on save files and server config.
	 */
	
	public String nickname, shipName;
	public int shipID; // assigned by server
	
	public Player(String name, String ship) {
		nickname = name;
		shipName = ship;
	}
	
	public void setNickname(String nick){
		nickname = nick;
		// do XMLey or file reading stuff here
	}
	
	public String getNickname(){
		return nickname;
	}
	
	public void setShipName(String ship){
		shipName = ship;
	}
	
	public String getShipName(){
		return shipName;
	}
	
	public void setShipID(int id){
		shipID = id;
	}
	
	public int getShipID(){
		return shipID;
	}
	
}
