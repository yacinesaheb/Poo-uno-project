package poo_uno;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	
	// Attributes of the Deck class
	
    private ArrayList<Card> cards;      // ArrayList of Card
    private int numberOfCards;          // Actual number of cards in the deck
	
	
    // Constructor; when no argument is passed, initialize a whole deck with 108 cards
    
    public Deck () { 
        numberOfCards = 108;
        cards = new ArrayList<Card>(numberOfCards);
        
        // ALL COLORS AND NUMBERS AVAILABLE
        final String[] colors = { "R", "B", "G", "Y"}; // We took only the initials to make the display better.
        final int[] numbers = {0,1,2,3,4,5,6,7,8,9};
        
        // iterate through all the colors
        for (int i=0; i<4; i++) {

            // Adding zero cards
            cards.add(i*25, new RegularCard(colors[i],0)); 
            
            // Adding numbered cards
            for (int j=1; j<19; j+=2) { 
                cards.add(i*25+j , new RegularCard(colors[i], numbers[j/2]) ) ;
                cards.add(i*25+j+1 , new RegularCard(colors[i], numbers[j/2]) );
            }
            
            // Adding action cards
            cards.add( 19+i*25, new DrawTwoCard(colors[i]) );
            cards.add( 20+i*25, new DrawTwoCard(colors[i]) );
            cards.add( 21+i*25, new ReverseCard (colors[i]) );
            cards.add( 22+i*25, new ReverseCard (colors[i]) );
            cards.add( 23+i*25, new SkipCard (colors[i]) );
            cards.add( 24+i*25, new SkipCard (colors[i]) );
        }

        // Adding special cards
        for (int i=100; i<104; i++) {  
            cards.add( i, new WildCard () );
        }
        for (int i=104; i<108; i++) {  
            cards.add( i, new WildDrawFour () );
        }
    }

    public int getNumberOfCards() {
    	return numberOfCards;
    }
	
    
    
    // Shuffle randomly the cards of the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }
   
    // Returns the top card of the deck and removing it.
    public Card drawDeckCard() {
        if (numberOfCards > 0) {
            numberOfCards--;
            return cards.remove(cards.size() - 1);
        }
        return null;
    }
    

    // Returns the top card of the deck (without removing it)
    public Card getTopCard() {     
            return cards.get(cards.size() - 1);
    }
	
    // Adding a card to the deck (dunno why this is here neither)
    public void addCard(Card card) {
        if (cards.size() < numberOfCards) {
            cards.add(card);
            numberOfCards++;
        }
    }
    
    public void displayDeck() {
        System.out.println("Deck contains " + cards.size() + " cards:");
        for (int i = 0; i < cards.size(); i++) {
            System.out.println((i + 1) + ": " + cards.get(i)); // Assumes Card class has a meaningful `toString` method
        }
    }
	
}
