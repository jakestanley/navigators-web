package begin;
import java.util.Random;

public class NumberGets {

	//this class will be filled with methods that will be used to generate random integers, booleans, etc for various uses.
	
	Random random = new Random();
		
	public NumberGets(){
		
	}
	
	public boolean getRandomBoolean() {
	    return random.nextBoolean();
	}
	
	public int getRandomInt() {
		return random.nextInt();
	}
	
	public int getRandom0to5() {
		return random.nextInt(5);
	}
	
	public boolean getOneInSixChance() {
		int hit;
		int result;
		hit = 3;
		result = random.nextInt();
		if(hit == result){
			return true;
		}
		else {
			return false;
		}	
	}
	
	public int getRandom1to1000000() {
		return (random.nextInt(1000000) + 1);
	}
	
}
