import java.util.ArrayList;


public class Player {
	private String name;
	private ArrayList<Card> hand =  new ArrayList<Card>();
	
	public Player(String s){
		name = s;
	}
	
	public Card[] currentHand(){
		Card[] temp = new Card[hand.size()];
		for(int i = 0; i < hand.size(); i++){
			temp[i] = hand.get(i);
		}
		return temp;
	}
	
	public void addHand(Card c){
		hand.add(c);
	}
	
	public void clearHand(){
		hand.clear();
	}
	@Override
	public String toString(){
		return name;
	}
}
