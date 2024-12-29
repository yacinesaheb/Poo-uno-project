package poo_uno;

public class MediumRobot extends Player { // Robot of difficulty medium plays the Wild card better than the easy one , as he chooses the color depending on the number of cards he has in his hand from every color.
	
	@SuppressWarnings("unused")
	@Override
	public int playProcess(Player player,Player nextPlayer,Card[] hand,Card discardPileTopCard,int playerNbrCards,Deck deck) { // For a robot , it plays the first playable card in his hand , except if it's a wildDrawFour we check before if it's the only playable card.
		
		int pos = 0; // Initializing the variable that will determine which card the player wants to play
		boolean played = false; // Check if the card has been successfully played to go out of the loop.
		
		if ( checkPlayableCards(hand ,playerNbrCards, discardPileTopCard ) == true) { // There is at least one playable card in the hand of the player (including wildDrawFour).
		do {
			
		    // Determining the card played and play it.
			if (hand[pos] instanceof RegularCard) { // If the card is a regular card
				if ( (hand[pos].getColor() == discardPileTopCard.getColor() ) || (hand[pos].getNbr() == discardPileTopCard.getNbr() ) ) { // If the card matches the discardPileTopCard by color or number.
					played = playCard(hand , pos , playerNbrCards, discardPileTopCard); 
					System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());
				}
			} else if (hand[pos] instanceof SkipCard) {
				if ( hand[pos].getColor() == discardPileTopCard.getColor() ) { // If the card matches the discardPileTopCard by color
					hand[pos].skip();
					played = playCard(hand , pos , playerNbrCards, discardPileTopCard);	
					System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());
				}
			} else if (hand[pos] instanceof ReverseCard) {
				if ( hand[pos].getColor() == discardPileTopCard.getColor() ) { // If the card matches the discardPileTopCard by color
					hand[pos].reverse();
					played = playCard(hand , pos , playerNbrCards, discardPileTopCard);
					System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());
				} 
			} else if (hand[pos] instanceof DrawTwoCard) {
				if ( hand[pos].getColor() == discardPileTopCard.getColor() ) { // If the card matches the discardPileTopCard by color
					hand[pos].drawTwo(nextPlayer , hand , playerNbrCards , deck);
					played = playCard(hand , pos , playerNbrCards, discardPileTopCard);
					System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());
				}
			} else if (hand[pos] instanceof WildCard) {
					hand[pos].chooseColor(player,hand,playerNbrCards);
					played = playCard(hand , pos , playerNbrCards, discardPileTopCard);
					System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());

			} else if ( (hand[pos] instanceof WildDrawFour) ) { // If the card is a wild card 
					if ( isWildFourPlayable(hand,pos,playerNbrCards,discardPileTopCard) == true ) { // A wildFourCard is playable only if it is the only playable card in the hand of the player.
						hand[pos].drawFourCards(player , nextPlayer , hand , pos , playerNbrCards , deck);
						played = playCard(hand , pos , playerNbrCards, discardPileTopCard);
						System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard() + ". " + nextPlayer.getName() +  " has been given 4 cards, and the new color is " + discardPileTopCard.getColor());
					}
			  }	
			pos++;
			}
			while ( played = false);
		
		} else { // There are no playable cards in the hand of the player.
			
			boolean drawed = drawCard(hand,1,playerNbrCards,deck); // Calls the drawCard method.
			if (drawed == true) {
				System.out.println(player.getName() + " had no card to play ,so he drawed one card.");
			} else {
				System.out.println(player.getName() + " had no card to play ,and there are no more cards left in the deck , so he passes his turn.");
			}
		}
		return playerNbrCards; // To make easier to check if the player won or not in the Game class.
	}

}
