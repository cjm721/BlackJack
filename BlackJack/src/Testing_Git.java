
public class Testing_Git {
	public static void main(String [] args){
		Deck d = new Deck();
		d.printDeck();
	}
	
	
	public static void printBox()
	{
	    for (int i=0x0000;i<=0x0500;i++)
	    {
	        System.out.printf("0x%x : %c\n",i,(char)i);
	    }
	}
}
