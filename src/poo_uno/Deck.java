package poo_uno;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	// Initialize the attributes
	
	
    private ArrayList<Card> cards;      // List of cards of the deck
    private int numberOfCards;          // Actual number of cards of the deck
	
	
    // Constructor of the class Deck. When no argument is passed, initialize a whole deck with 108 cards.
    
     public Deck () { 
    	
        numberOfCards = 108;
        cards = new ArrayList<Card>(numberOfCards);

        String[] colors = { "RED", "BLUE", "GREEN", "YELLOW"}; 
        String[] numbers = { "ZERO", "ONE", "TWO", "THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"};
        
        // iterate through all the colors
        for (int i=0; i<4; i++) {

            // Adding Zero cards
            cards.add( i*25 , new RegularCard(colors[i], "ZERO" ) ); 
            
            
            // Adding cards from 0 to 9 (without their color)
            for (int j=1; j<19; j+=2) { 
                cards.add(i*25+j , new RegularCard(colors[i], numbers[j/2]) ) ;
                cards.add(i*25+j+1 , new RegularCard(colors[i], numbers[j/2]) );
            }
            
            // Adding action cards for every color 
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
}
	
	