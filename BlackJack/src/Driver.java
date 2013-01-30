import java.util.*;
import java.io.*;

public class Driver {
	
	public static void main (String [] args) throws IOException {
		PrintStream out = new PrintStream(System.out, true, "UTF-8");
		Scanner kb = new Scanner(System.in);
		for(int i = 0; i < 52; i++){
			Card c = new Card(i);
			out.println(c.toUniString());
		}
		
		while(true){
			int i = kb.nextInt();
			Card c = new Card(i);
			System.out.println(c.toUniString());
			
		}
		
	}
	
}
