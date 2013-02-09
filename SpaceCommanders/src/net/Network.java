package net;

import ships.Ship;

import begin.Player;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

public class Network {

	static public final int port = 1337;
	
	static public void register(EndPoint endPoint) {
		Kryo kryo = endPoint.getKryo();
		kryo.register(Ship.class);
		kryo.register(Player.class);
		kryo.register(Register.class);
	}
	
	static public class Register {
		int id;
		public Register(int id){
			this.id = id;
		}
		public int getShipID(){
			return this.id;
		}
		
	}
	
	/*
	
	static public class ShipNet {
		int shipID, availableCoolant;
		boolean isShipOn;
		Coordinate location;
		Weapon shipWeapon;
		Reactor shipReactor;
		public String shipName;
		float shipHealth;
	}
	
	static public class AddShip {
		public ShipNet ship;
	}
	
	static public class RemoveShip {
		public int id;
	}
	
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
