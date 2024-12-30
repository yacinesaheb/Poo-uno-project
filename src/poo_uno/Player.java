package poo_uno;

import java.util.ArrayList;

public abstract class Player { // WE MIGHT ADD A DIFFICULTY SYSTEM TO THE BOTS IF WE HAVE TIME.

	// The object's attributes
	
	private Card[] hand = new Card[108] ; // Player's hand (his cards)
	private int NbrCards=0; // Number of cards in the player's hand
	private String name; // Name of the player
	
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
	
	// Methods of the class Player
			
	public boolean playCard(int pos,Card discardPileTopCard) { // POTENTIAL ERROR IN THIS FUNCTION DUE TO THE FIRST ENTRY//i dont need to give it to you you have it so use it directly
		discardPileTopCard = this.hand[pos];
		this.hand[pos] = this.hand[this.NbrCards];
		this.NbrCards--;
		return true;
	}
	
	public boolean checkPlayableCards( Card topCard) { // This method is here to check whether there is at least one playable card.
		boolean playable = false; // There are no playable cards.
		int i;
		for (i = 0 ; i < this.NbrCards ; i++) {
			if (this.hand[i] instanceof RegularCard) { // If the card is a regular card
				if ( (this.hand[i].getColor() == topCard.getColor() ) || (this.hand[i].getNbr() == topCard.getNbr() ) ) { // If the card matches the topCard by color or number.
					playable = true; // There is a playable card.
					break; // Goes out of the for loop
				}
			} else if ( (this.hand[i] instanceof SkipCard) || (this.hand[i] instanceof ReverseCard) || (this.hand[i] instanceof DrawTwoCard) ) { // If the card is a special card
				if ( this.hand[i].getColor() == topCard.getColor() ) { // If the card matches the topCard by color .
					playable = true; // There is a playable card.
					break;// Goes out of the for loop
				}
			} else if ( (this.hand[i] instanceof WildCard) ) { // If the card is a wild card 
				playable = true; // There is a playable card.
				break; // Goes out of the for loop
			}	
		}
		return playable;
	}
	
	public boolean isWildFourPlayable( int pos , Card topCard) { // WildFourCard
		boolean playable = true; // the card is playable
		int i;
		for (i = 0 ; i < this.NbrCards ; i++) {
			if ( i != pos) {
				if (this.hand[i] instanceof RegularCard) { // If the card is a regular card
					if ( (this.hand[i].getColor() == topCard.getColor() ) || (this.hand[i].getNbr() == topCard.getNbr() ) ) { // If the card matches the topCard by color or number.
						playable = false; // WildDrawFour is not playable.
						break; // Goes out of the for loop
					}
				} else if ( (this.hand[i] instanceof SkipCard) || (this.hand[i] instanceof ReverseCard) || (this.hand[i] instanceof DrawTwoCard) ) { // If the card is a special card
					if ( this.hand[i].getColor() == topCard.getColor() ) { // If the card matches the topCard by color .
						playable = false; // WildDrawFour is not playable.
						break;// Goes out of the for loop
					}
				} else if ( (this.hand[i] instanceof WildCard) ) { // If the card is a wild card 
					playable = false; // WildDrawFour is not playable.
					break; // Goes out of the for loop
				}	
			}
		}
		
		return playable;
	}
	
	public boolean drawCard(int nbr,Deck deck) { // Draws one card from the Deck if there are still enough. (nbr <==> number of cards to draw)
		boolean drawed = true;
		int i;
		for ( i = 1; i <= nbr ; i++ ) {
			this.NbrCards++;
			hand[this.NbrCards - 1] = deck.drawDeckCard();
			if (hand[this.NbrCards - 1] == null) {
				this.NbrCards--;
				drawed = false;
				return drawed;
			}
		}
		return drawed;
	}
	public void displayHand() {
	    System.out.println("Player " + name + "'s hand (" + NbrCards + " cards):");
	    for (int i = 0; i < NbrCards; i++) {
	    	  ya kho le mem System.out.print(this.hand[i].displayCard()+"/");// Assumes Card class has a meaningful `toString` method
	    }
	}
	
	public abstract int playProcess(Player player,Player nextPlayer,Card[] hand,Card discardPileTopCard,int playerNbrCards,Deck deck) ; // This method handles all the playing process for a player. 
	
}
