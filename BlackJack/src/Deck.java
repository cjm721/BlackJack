public class Deck {
	
	public final static int limit = 50000;
	public static boolean debug = false;
	
	private int currentDraw;
	private Card[] deck = new Card[52];
	
	public Deck(){
		if(debug)System.out.println("Making new deck");
		for(int i = 0; i < deck.length; i++){
			deck[i]= new Card(i);
		}
	}
	
	public void shuffle(){
		if(debug)System.out.println("Shuffling " + this);
		currentDraw = 0;
		for(int i = 0; i < limit; i++){
			int a = (int)(Math.random()*deck.length);
			int b = (int)(Math.random()*deck.length);
			Card temp = deck[b];
			deck[b] = deck[a];
			deck[a] = temp;
		}
	}
	
	public Card deal(){
		if(debug) System.out.println("Entering Draw, currentDraw = " + currentDraw);
			
		Card temp = deck[currentDraw];
		if(currentDraw >= deck.length-1){
			shuffle();
			System.out.println("Shuffling");
			currentDraw = 0;
			if(debug)System.out.println("Shuffle + setting currentDraw to 0");
		}
		else {
			currentDraw++;
			if(debug)System.out.println("Incrementing currentDraw to: " + currentDraw);
		}
		return temp;
	}
	
	public void printDeck(){
		for(Card d: deck){
			System.out.println(d.toUniString());
		}
	}
}
