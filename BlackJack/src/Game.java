import java.io.PrintStream;
import java.io.UnsupportedEncodingException;


public class Game {
	
	public static void main(String[] args){
		printCard(1);
	}
	
	private static String[] cards = {"1","2","3","4","5","6"};
	private static int[] pullOrder = new int[cards.length];
	private static final int limit = 10000;
	private static int currentDraw = 0;
	static PrintStream out;
	
	
	public static boolean debug = false;
	
	public static void shuffle(){
		for(int i = 0; i < pullOrder.length; i++) pullOrder[i] = i;
		currentDraw = 0;
		
		for(int i = 0; i < limit; i++){
			int a = (int)(Math.random()*pullOrder.length);
			int b = (int)(Math.random()*pullOrder.length);
			int temp = pullOrder[b];
			pullOrder[b] = pullOrder[a];
			pullOrder[a] = temp;
		}
	}
	
	public static String draw(){
		if(debug) System.out.println("Entering Draw, currentDraw = " + currentDraw);
			
		String temp = cards[pullOrder[currentDraw]];
		if(currentDraw >= cards.length-1){
			shuffle();
			currentDraw = 0;
			if(debug)System.out.println("Shuffle + setting currentDraw to 0");
		}
		else {
			currentDraw++;
			if(debug)System.out.println("Incrementing currentDraw to: " + currentDraw);
		}
		return temp;
	}
	
	public static void printVals(){
		System.out.println("currentDraw: " + currentDraw);
		System.out.println("Length of pullOrder: " + pullOrder.length);
		System.out.println("Length of cards: " + cards.length);
	}
	
	public static void runGame() throws UnsupportedEncodingException{
		out = new PrintStream(System.out, true, "UTF-8");
		shuffle();
		
	}
	
	/*
	 * 0 = hit
	 * 1 = pass
	 * -1 = invalid
	 */
	private static int userChoice(String s){
		char temp = s.charAt(0);
		if(debug) System.out.println("userChoice - temp: " + temp);
		
		if(temp == 'h'){
			return 0;
		}else if ( temp == 'p'){
			return 1;
		}else
		return -1;
	}
	
	private static void printCard(int i){
		System.out.println("-----------");
		System.out.println("-         -");
		System.out.println("-         -");
		System.out.println("-   4?    -");
		System.out.println("-         -");
		System.out.println("-         -");
		System.out.println("-----------");
	}
	
}