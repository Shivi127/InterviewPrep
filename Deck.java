// To design a generic Deck of Cards.
// Generic - 52 cards deck.

// We know that the deck has 4 Suits hence make an enum

public enum Suit{
	// enum inherits from java.lang.Enum; so it cannot inherit from other classes
	// it can implement other classes
	// cannot have abstract methods

	Club(1),
	Diamond(2),
	Hearts(3),
	Spade(4);

	private int val;

	// Private Constructor
	private Suit(int val){
		this.val=val
	}

	// Other Methods like GetValue and GetSuit can be implemented
	public int GetValue(Suit s){
		return this.val
	}
	
}


public class Card{
	// has a value and a Suit
	int value;
	Suit s;
	public Card(int v, Suit s){
		this.s=s;
		value=v;
	}

	public int getValue(Card c){
		return this.value
	}
}


public class Deck{
	// creating a deck of Cards
	ArrayList<Card> deck= new ArrayList<Card>;
	// Suit.values returns an array of the values
	for(Suit s: Suit.values()){
		for(int i=1;<=13;i++){
			// Instantiating 13 Cards for each suit
			deck.add(new Card(i,s));
		}
	}

	public void shuffle(Deck d){

		Random r= new Random();
		int max=51;
		int min=0;

		for(int i=0;i<52;i++){
			// swap at random index;
			// Math.random returns a value between 0 and 1
			int randomIndex= r.nextInt((max-min)+1)+min;
			Card temp= d[i];
			d[i]=d[randomIndex];
			d[randomIndex]=temp;

		}
	}
}

// Subclass the structure to implement BlackJack
// Dont really understand BlackJack as of now. NEED TO WORK ON THIS

class BlackJack extends Card{
	public BlackJack(int v, Suit s){
		// call constructor of card 
			super(v,s);
	}

	public boolean isAce(Card c){
		return(c.getValue==1); 

	}


}