package poo_uno;

public abstract class Player {

	// The object's attributes
	
	private Card[] hand = new Card[108] ; // Player's hand (his cards)
	private int nbrCards; // Number of cards in the player's hand
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
	
	public void drawCard(int nbr) { // Draws "nbr" cards from the Deck if there are still enough. (nbr <==> number of cards to draw)
		
	}
	
	public abstract int playProcess(Player player,Card[] hand,Card discardPileTopCard,int nbrCards) ; // This method removes a card from the player's hand , rearranges the hand ,changes the value of the topCard of the discard pile , then decrements the number of cards in hand by 1.

}
