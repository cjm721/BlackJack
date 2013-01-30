import java.util.*;
public class Driver {

	public static void main (String [] args){
		Scanner kb = new Scanner(System.in);
		Game.shuffle();
		while(true){
			kb.nextLine();
			//Game.printVals();
			System.out.println(Game.draw());
			
		}
		
	}
	
}
