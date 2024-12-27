package poo_uno;

public class Robot extends Player {
	
	@SuppressWarnings("unused")
	@Override
	public int playProcess(Player player,Card[] hand,Card discardPileTopCard,int nbrCards) { // For a robot , it plays the first playable card in his hand , except if it's a wildDrawFour we check before if it's the only playable card.
		int pos = 0; // Initializing the variable that will determine which card the player wants to play
		boolean played = false; // Check if the card has been successfully played to go out of the loop.
		
		if (  checkPlayableCards(getHand() ,nbrCards, discardPileTopCard ) == true) {
		do {
		    
		    // Determining the card played and play it.
			if (hand[pos] instanceof RegularCard) { // If the card is a regular card
				if ( (hand[pos].getColor() == discardPileTopCard.getColor() ) || (hand[pos].getNbr() == discardPileTopCard.getNbr() ) ) { // If the card matches the discardPileTopCard by color or number.
					played = playCard(getHand() , pos , nbrCards, discardPileTopCard); 
				}
			} else if (hand[pos] instanceof SkipCard) {
				if ( hand[pos].getColor() == discardPileTopCard.getColor() ) { // If the card matches the discardPileTopCard by color
					hand[pos].skip();
					played = playCard(getHand() , pos , nbrCards, discardPileTopCard);	
				}
			} else if (hand[pos] instanceof ReverseCard) {
				if ( hand[pos].getColor() == discardPileTopCard.getColor() ) { // If the card matches the discardPileTopCard by color
					hand[pos].reverse();
					played = playCard(getHand() , pos , nbrCards, discardPileTopCard);
				} 
			} else if (hand[pos] instanceof DrawTwoCard) {
				if ( hand[pos].getColor() == discardPileTopCard.getColor() ) { // If the card matches the discardPileTopCard by color
					hand[pos].drawTwo();
					played = playCard(getHand() , pos , nbrCards, discardPileTopCard);
				}
			} else if (hand[pos] instanceof WildCard) {
					hand[pos].chooseColor();
					played = playCard(getHand() , pos , nbrCards, discardPileTopCard);

			} else if ( (hand[pos] instanceof WildDrawFour) ) { // If the card is a wild card 
					if ( isWildFourPlayable(getHand(),pos,nbrCards,discardPileTopCard) == true ) {
						hand[pos].drawFourCards();
						played = playCard(getHand() , pos , nbrCards, discardPileTopCard);
					}
			  }	
			pos++;
			}
			while (played = false);
		} else {
			drawCard(1); // THIS IS TEMPORARY UNTILL I GET THE STRUCTURE OF THE DECK SO THAT I MAKE THE CONDITION OF UNTILL DECK IS EMPTY.
		}
		
		return nbrCards; // To make easier to check if the player won or not in the Game class.
	}

}
