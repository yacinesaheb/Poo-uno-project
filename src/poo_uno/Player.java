package poo_uno;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Player { 

	// The object's attributes
	
	private Card[] hand = new Card[108] ; // Player's hand (his cards)
	private int NbrCards=0; // Number of cards in the player's hand
	private String name; // Name of the player
	private boolean skip = false; // To apply the skip card on the player.
	
	// Setters and getters for out attributes
	
	public Player() {
        this.hand = new Card[108]; // Initialize the hand array
    }
	public int getNbrCards() { // number of cards getter
		return NbrCards;
	}
	public void setNbrCards(int NbrCards) { // number of cards setter
		this.NbrCards = NbrCards;
	}
	public Card[] getHand() { // Hand's getter
		return hand;
	}
	public void setHand(Card[] hand) { // Hand's setter
		this.hand = hand;
	}

	public String getName() { // Name's getter
		return name;
	}
	public void setName(String name) { // Name's setter
		this.name = name;
	}	
	
	public boolean getSkip() { // Skip's getter
		return skip;
	}
	public void setSkip(boolean skip) { // Skip's setter.
		this.skip = skip;
	}
	
	
	// Methods of the class Player
			
	public boolean playCard(int pos,Pile discardPile) { 
	    // Get the current cards array from discard pile
	    Card[] discardCards = discardPile.getCards();
	    int discardSize = discardPile.getNumberOfCards();
	    
	    // Add card to top of discard pile
	    discardCards[discardSize] = this.hand[pos];
	    discardPile.setNumberOfCards(discardSize + 1);
	    
	    // Shift remaining cards to fill the gap
	    for (int i = pos; i < this.NbrCards - 1; i++) {
	        this.hand[i] = this.hand[i + 1];
	    }
	    
	    // Clear the last position and decrement number of cards
	    this.hand[this.NbrCards - 1] = null;
	    this.NbrCards--;
	    
	    return true;
	}
	
	public boolean checkPlayableCards(Pile discardPile) { // This method is here to check whether there is at least one playable card.
		boolean playable = false; // There are no playable cards.
		int i;
		for (i = 0 ; i < this.NbrCards ; i++) {
			if (this.hand[i] instanceof RegularCard) { // If the card is a regular card
				if ( (this.hand[i].getColor() == discardPile.getTopCard().getColor() ) || (this.hand[i].getNbr() == discardPile.getTopCard().getNbr() ) ) { // If the card matches the topCard by color or number.
					playable = true; // There is a playable card.
					break; // Goes out of the for loop
				}
			} else if ( (this.hand[i] instanceof SkipCard) || (this.hand[i] instanceof ReverseCard) || (this.hand[i] instanceof DrawTwoCard) ) { // If the card is a special card
				if ( this.hand[i].getColor() == discardPile.getTopCard().getColor() ) { // If the card matches the topCard by color .
					playable = true; // There is a playable card.
					break;// Goes out of the for loop
				}
			} else if ( (this.hand[i] instanceof WildCard) || (this.hand[i] instanceof WildDrawFour) ) { // If the card is a wild card 
				playable = true; // There is a playable card.
				break; // Goes out of the for loop
			}	
		}
		return playable;
	}
	
	public boolean isWildFourPlayable( int pos , Pile discardPile) { // WildFourCard
		boolean playable = true; // the card is playable
		int i;
		for (i = 0 ; i < this.NbrCards ; i++) {
			if ( i != pos) {
				if (this.hand[i] instanceof RegularCard) { // If the card is a regular card
					if ( (this.hand[i].getColor() == discardPile.getTopCard().getColor() ) || (this.hand[i].getNbr() == discardPile.getTopCard().getNbr() ) ) { // If the card matches the topCard by color or number.
						playable = false; // WildDrawFour is not playable.
						break; // Goes out of the for loop
					}
				} else if ( (this.hand[i] instanceof SkipCard) || (this.hand[i] instanceof ReverseCard) || (this.hand[i] instanceof DrawTwoCard) ) { // If the card is a special card
					if ( this.hand[i].getColor() == discardPile.getTopCard().getColor() ) { // If the card matches the topCard by color .
						playable = false; // WildDrawFour is not playable.
						break;// Goes out of the for loop
					}
				} else if ( (this.hand[i] instanceof WildCard) ) { // If the card is a wild card 
					playable = false; // WildDrawFour is not playable
					break; // Goes out of the for loop
				}	
			}
		}
		return playable;
	}
	
	public void drawCard(int nbr, Pile deck, Pile discardPile) {
	    for (int i = 1; i <= nbr; i++) {
	        if (deck.getNumberOfCards() == 0) {
	            System.out.println("There are no more cards in the draw pile. We will now take all the previous played cards except the last one, shuffle it, and use it as a draw pile (deck).");
	            
	            // THIS IS TO TEST THE MECHANIC 
	            /*System.out.println("Here is the discard pile before the operation :");
	            discardPile.displayDeck();*/
	            
	            // Save the discard pile size and top card
	            int discardSize = discardPile.getNumberOfCards();
	            Card dpTopCard = discardPile.getCards()[discardSize - 1];
	            
	            // Set new deck size (discard pile size minus 2: one for 0-based index, one for keeping top card)
	            deck.setNumberOfCards(discardSize - 1);
	            
	            // Copy cards from discard pile to deck (except top card)
	            Card[] deckCards = deck.getCards();
	            Card[] discardCards = discardPile.getCards();
	            for (int j = 0; j < discardSize - 1; j++) {
	                deckCards[j] = discardCards[j];
	            }
	            
	            deck.shuffle(); // Shuffles the deck
	            
	            // Reset discard pile and add back top card
	            discardPile.resetPile();
	            discardPile.getCards()[0] = dpTopCard;
	            discardPile.setNumberOfCards(1);
	            
	            // THIS IS TO TEST THE MECHANIC
	            /*System.out.println("Here is the deck after the operation :");
	            deck.displayDeck();
	            System.out.println("Here is the discard pile after the operation :");
	            discardPile.displayDeck();
	            System.out.println("Discard pile top card is : " + discardPile.getTopCard());*/
	            
	            // Draw mechanic
	            this.hand[this.NbrCards] = deck.drawPileCard();
	            this.NbrCards++;
	        } else {
	            // Draw mechanic
	            this.hand[this.NbrCards] = deck.drawPileCard();
	            this.NbrCards++;
	        }
	    }
	}
	
	public abstract int playProcess(Player nextPlayer,Pile discardPile,Pile deck, boolean[] firstPlayedCard,int nbrOfPlayers,Scanner reader) ; // This method handles all the playing process for a player. 
}
