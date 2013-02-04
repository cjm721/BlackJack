
public class Card {
	public static boolean debug = false;
	
	private String name;
	private int id;
	private int value;
	private String uniName;
	
	public Card(int i){
		id = i;
		name = number_Value(i) + " of " + suit(i);
		uniName = number_Value2(i) + uniSuit(i);
	}
	
	private String suit(int i){
		String suit;
		id = i;
		int b = i/13;
		if(b < 1){
			suit = "Hearts";
		}else if (b < 2){
			suit = "Clubs";
		}else if (b < 3){
			suit = "Spades";
		}else if (b < 4){
			suit = "Diamond";
		}else{
			suit = "Unknown";
		}
		return suit;
	}
	
	private String uniSuit(int i){
		String suit;
		int b = i/13;
		if(b < 1){
			suit = "\u2665";
		}else if (b < 2){
			suit = "\u2663";
		}else if (b < 3){
			suit = "\u2660";
		}else if (b < 4){
			suit = "\u2666";
		}else{
			suit = "?";
		}
		return suit;
	}
	
	private String number_Value(int i){
		//0 1 2 3 4 5 6 7 8 9  10 11 12
		//A 2 3 4 5 6 7 8 9 10 J  Q  K
		String num; 
		int b = i%13;
		if(b == 0){
			num = "Ace";
			value = 11;
		}else if(b >9){
			if(debug)System.out.println("Entering Named suits with b value: " + b);
			if( b == 10){
				num = "Jack";
			}
			else if( b == 11){
				num = "Queen";
			}
			else if( b == 12){
				num = "King";
			}else{	
				num = "Unknown";
			}
			value = 10;
			
		}else{
			num = "" + (b +1);
		}
		return num;	
	}
	
	private String number_Value2(int i){
		//0 1 2 3 4 5 6 7 8 9  10 11 12
		//A 2 3 4 5 6 7 8 9 10 J  Q  K
		String num; 
		int b = i%13;
		if(b == 0){
			num = "A";
			value = 11;
		}else if(b >9){
			if(debug)System.out.println("Entering Named suits with b value: " + b);
			if( b == 10){
				num = "J";
			}
			else if( b == 11){
				num = "Q";
			}
			else if( b == 12){
				num = "K";
			}else{	
				num = "U";
			}
			value = 10;
			
		}else{
			num = "" + (b +1);
		}
		return num;	
	}
	
	@Override
	public String toString (){
		return name;
	}
	
	public String toUniString(){
		return uniName;
	}
	
	public int getValue(){
		return value;
	}
	
	public int getId(){
		return id;
	}
	
	public String twoDCard(){
		String temp = 	" ___________\n" +
						"|          |\n" + 
						"|          |\n" +
						"|    " + uniName + "    |\n" +
						"|          |\n" + 
						"|__________|\n";
		return temp;
	}
}
