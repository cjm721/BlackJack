
public class Deck {
	public final static int limit = 50000;
	public static boolean debug = false;
	
	private int currentDraw;
	private Card[] deck = new Card[52];
	private int[] pullOrder = new int[deck.length];
	
	public Deck(){
		for(int i = 0; i < deck.length; i++){
			deck[i]= new Card(i);
		}
	}
	
	public void shuffle(){
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
	
	public void deal(Player p){
		if(debug) System.out.println("Entering Draw, currentDraw = " + currentDraw);
			
		Card temp = deck[pullOrder[currentDraw]];
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
		p.addHand(temp);
	}
}
