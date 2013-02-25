package uk.co.jakestanley.sc.tools;

/**
 * Coordinates have no collision detection. 
 * Collision detection will have to be checked by the classes that make use of coordinates.
 * 
 * @author Jake Stanley
 */

public class Coordinate {
	
	float pointX, pointY, pointZ;
	
	public Coordinate(float x, float y, float z){
		
		this.pointX = x;
		this.pointY = y;
		this.pointZ = z;
		
	}
	
	public void setCoordinate(float x, float y, float z){
		this.pointX = x;
		this.pointY = y;
		this.pointZ = z;
	}
	
	public void moveX(float x){
		pointX = pointX + x; 
	}
	
	public void moveY(float y){
		pointY = pointY + y; 
	}
	
	public void moveZ(float z){
		pointZ = pointZ + z;
	}
	
	public float getX(){
		return this.pointX;
	}
	
	public float getY(){
		return this.pointY;
	}
	
	public float getZ(){
		return this.pointZ;
	}
	
	public String get2DCoordinateAsString(){
		String coordString;
		coordString = (getX() + ", " + getY());
		return coordString;
	}
	
	public String get3DCoordinateAsString(){
		String coordString;
		coordString = (getX() + ", " + getY() + ", " + getZ());
		return coordString;
	}
	
}
