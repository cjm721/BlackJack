import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;


public class Game {
	
	private Player[] players;
	static PrintStream out;
	private int playerCount;
	private Deck deck;
	public boolean debug = false;
	private boolean[] bust;
	

	public void runGame() throws UnsupportedEncodingException{
		out = new PrintStream(System.out, true, "UTF-8");
		deck = new Deck();
		deck.shuffle();
		System.out.println("Welcome to CJ's BlackJack Table");
		setPlayers();
		while(true) {
			deal();
			for(int i = 0; i < players.length; i++){
				choice(players[i]);
			}
			
			
			
			for(int i = 0; i < players.length; i++){
				players[i].clearHand();
			}
		}
	}
	
	private void setPlayers(){
		Scanner kb = new Scanner(System.in);
		System.out.println("How many players are there?");
		boolean goodinput;
		String input;
		do{
			goodinput = true;
			input = kb.nextLine();
			for(int i = 0; i < input.length(); i++){
				if(!Character.isDigit(input.charAt(i))){
					goodinput = false;
				}
			}
			if(goodinput)break;
			System.out.println("Not a number. Please input number of players");
		}while(!goodinput);
		
		
		playerCount = Integer.parseInt(input);
		players = new Player[playerCount];
		for(int i = 0; i < playerCount; i++){
			System.out.println("Please enter name of player " + (i+1));
			String temp = kb.nextLine();
			Player p = new Player(temp);
			if(debug)System.out.println("Initializing player: " + p.toString());
			players[i] = p;
			if(debug)System.out.println("Testing array: " + players[i]);
		}
		kb.close();
	}
	
	private void deal(){
		for(int i = 0; i < players.length; i++){
			if(debug){
				System.out.println("Dealing to player: " + players[i]);
				System.out.println("Throwing out card to test");
				deck.deal();
				System.out.println("Thrown Card");
			}
			players[i].addHand(deck.deal());
			players[i].addHand(deck.deal());
		}
	}
	
	private void choice(Player p){
		Scanner kb = new Scanner(System.in);
		System.out.println(p.toString()+ " enter your move (Hit, Pass, Split).");
		boolean done = true;
		while(!done){
			String temp = kb.nextLine();
			int uC = userChoice(temp);
			switch (uC){
			case -1:
				System.out.println("Invalid entry. Enter Hit, Pass, or Split");
				break;
			case 0:
				p.addHand(deck.deal());
				done = true;
				break;
			case 1:
				done = true;
				break;
			case 2:
				done = true;
				break;						//NEED SPLIT CODE!!!
			}
		}
		kb.close();
	}
	/*
	 * 0 = hit
	 * 1 = pass
	 * -1 = invalid
	 */
	private int userChoice(String s){
		char temp = s.charAt(0);
		if(debug) System.out.println("userChoice - temp: " + temp);
		
		if(temp == 'h'){ 			//Hit
			return 0;
		}else if ( temp == 'p'){	//Pass
			return 1;
		}else if ( temp == 's'){	// Split
			return 2;
		}else {
			return -1;
		}
	}
	
	private boolean allBusted(){
		bust = new boolean[players.length];
		for(int i = 0; i < players.length; i++){
			if (handValue(players[i]) > 21){
				bust[i] = true;
			}
		}
		
		boolean allbust = false;
		for(int i = 0; i < bust.length; i++){
			if(bust[i] = false){
				allbust = false;
				break;
			}
			allbust = bust[i];
		}
		return allbust;
	}
	
	private int handValue(Player p){
		int value =0;
		Card[] temp = p.currentHand();
		for(int i = 0; i < temp.length; i++){
			value += temp[i].getValue();
		}
		return value;
	}
	
}