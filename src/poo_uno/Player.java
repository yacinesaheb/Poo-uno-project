package poo_uno;

import java.util.ArrayList;

public abstract class Player { // WE MIGHT ADD A DIFFICULTY SYSTEM TO THE BOTS IF WE HAVE TIME.

	// The object's attributes
	
	private Card[] hand = new Card[108] ; // Player's hand (his cards)
	private int playerNbrCards; // Number of cards in the player's hand
	private String name; // Name of the player
	
	// Setters and getters for out attributes
	
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
			
	public boolean playCard(Card[] hand,int pos,int nbrCards,Card discardPileTopCard) { // POTENTIAL ERROR IN THIS FUNCTION DUE TO THE FIRST ENTRY
		discardPileTopCard = hand[pos];
		hand[pos] = hand[nbrCards];
		nbrCards--;
		return true;
	}
	
	public boolean checkPlayableCards(Card[] hand, int nbrCards, Card topCard) { // This method is here to check whether there is at least one playable card.
		boolean playable = false; // There are no playable cards.
		int i;
		for (i = 0 ; i < nbrCards ; i++) {
			if (hand[i] instanceof RegularCard) { // If the card is a regular card
				if ( (hand[i].getColor() == topCard.getColor() ) || (hand[i].getNbr() == topCard.getNbr() ) ) { // If the card matches the topCard by color or number.
					playable = true; // There is a playable card.
					break; // Goes out of the for loop
				}
			} else if ( (hand[i] instanceof SkipCard) || (hand[i] instanceof ReverseCard) || (hand[i] instanceof DrawTwoCard) ) { // If the card is a special card
				if ( hand[i].getColor() == topCard.getColor() ) { // If the card matches the topCard by color .
					playable = true; // There is a playable card.
					break;// Goes out of the for loop
				}
			} else if ( (hand[i] instanceof WildCard) ) { // If the card is a wild card 
				playable = true; // There is a playable card.
				break; // Goes out of the for loop
			}	
		}
		return playable;
	}
	
	public boolean isWildFourPlayable(Card[] hand, int pos , int nbrCards, Card topCard) { // WildFourCard
		boolean playable = true; // the card is playable
		int i;
		for (i = 0 ; i < nbrCards ; i++) {
			if ( i != pos) {
				if (hand[i] instanceof RegularCard) { // If the card is a regular card
					if ( (hand[i].getColor() == topCard.getColor() ) || (hand[i].getNbr() == topCard.getNbr() ) ) { // If the card matches the topCard by color or number.
						playable = false; // WildDrawFour is not playable.
						break; // Goes out of the for loop
					}
				} else if ( (hand[i] instanceof SkipCard) || (hand[i] instanceof ReverseCard) || (hand[i] instanceof DrawTwoCard) ) { // If the card is a special card
					if ( hand[i].getColor() == topCard.getColor() ) { // If the card matches the topCard by color .
						playable = false; // WildDrawFour is not playable.
						break;// Goes out of the for loop
					}
				} else if ( (hand[i] instanceof WildCard) ) { // If the card is a wild card 
					playable = false; // WildDrawFour is not playable.
					break; // Goes out of the for loop
				}	
			}
		}
		
		return playable;
	}
	
	public boolean drawCard(Card[] hand,int nbr,int nbrCards, Deck deck) { // Draws one card from the Deck if there are still enough. (nbr <==> number of cards to draw)
		boolean drawed = true;
		int i;
		for ( i = 1; i <= nbr ; i++ ) {
			nbrCards++;
			hand[nbrCards - 1] = deck.drawDeckCard();
			if (hand[nbrCards - 1] == null) {
				nbrCards--;
				drawed = false;
				return drawed;
			}
		}
		return drawed;
	}
	
	public abstract int playProcess(Player player,Player nextPlayer,Card[] hand,Card discardPileTopCard,int playerNbrCards,Deck deck) ; // This method handles all the playing process for a player. 
	
}
