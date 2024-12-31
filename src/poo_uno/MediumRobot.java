package poo_uno;

public class MediumRobot extends Player { // Robot of difficulty medium plays the Wild card better than the easy one , as he chooses the color depending on the number of cards he has in his hand from every color.
	 public MediumRobot() {
	        super(); // Calls the Player constructor
	    }
	@SuppressWarnings("unused")
	@Override
public int playProcess(Player player,Player nextPlayer,Card discardPileTopCard,Deck deck, Boolean firstPlayedCard) { // For a robot , it plays the first playable card in his hand , except if it's a wildDrawFour we check before if it's the only playable card.
		
		int pos = 0; // Initializing the variable that will determine which card the player wants to play
		boolean played = false; // Check if the card has been successfully played to go out of the loop.
		
		if ( firstPlayedCard == true ) { // If this is the first ever card played in the game
			
			firstPlayedCard = false; // It's not the first played card anymore after the next player.
		
		do {
		    // Determining the card played and play it.
			if (player.getHand()[pos] instanceof RegularCard) { // If the card is a regular card
				played = playCard( pos ,  discardPileTopCard);
				System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());
			} else if (player.getHand()[pos] instanceof SkipCard) {
				player.getHand()[pos].skip(nextPlayer);
				played = playCard( pos ,  discardPileTopCard);	
				System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());
			} else if (player.getHand()[pos] instanceof ReverseCard) {
				player.getHand()[pos].reverse();
				played = playCard( pos , discardPileTopCard);
				System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());
			} else if (player.getHand()[pos] instanceof DrawTwoCard) {
				player.getHand()[pos].drawTwo(nextPlayer,deck);
				played = playCard( pos , discardPileTopCard);
				System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());
			} else if (player.getHand()[pos] instanceof WildCard) {
				player.getHand()[pos].chooseColor(player);
				played = playCard(pos,discardPileTopCard);
				System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());
			} else if ( (player.getHand()[pos] instanceof WildDrawFour) ) { // If the card is a wild card 
						System.out.println(player.getName() + ". You can't play a wild draw four card as a first card ! ");
				}
			pos++;
		    } while (played == false); // Repeat the playing process while the player hasn't played yet. We don't need to verify if he can play a card because it's the first played card of the game.
		
		} else if ( checkPlayableCards(discardPileTopCard ) == true) { // There is at least one playable card in the hand of the player (including wildDrawFour).
			if ( player.getSkip() == true ) {
				System.out.println(player.getName() + " has to skip his turn because the previous player played a skip card !");
				played = true;
				player.setSkip(false);
			} else {
				do {
			
					// Determining the card played and play it.
					if (player.getHand()[pos] instanceof RegularCard) { // If the card is a regular card
						if ( (player.getHand()[pos].getColor() == discardPileTopCard.getColor() ) || (player.getHand()[pos].getNbr() == discardPileTopCard.getNbr() ) ) { // If the card matches the discardPileTopCard by color or number.
							played = playCard( pos ,  discardPileTopCard);
							System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());
						}
					} else if (player.getHand()[pos] instanceof SkipCard) {
						if ( player.getHand()[pos].getColor() == discardPileTopCard.getColor() ) { // If the card matches the discardPileTopCard by color
							player.getHand()[pos].skip(nextPlayer);
							played = playCard( pos ,  discardPileTopCard);
							System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());
						}
					} else if (player.getHand()[pos] instanceof ReverseCard) {
						if ( player.getHand()[pos].getColor() == discardPileTopCard.getColor() ) { // If the card matches the discardPileTopCard by color
							player.getHand()[pos].reverse();
							played = playCard( pos ,  discardPileTopCard);
							System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());
						} 
					} else if (player.getHand()[pos] instanceof DrawTwoCard) {
						if ( player.getHand()[pos].getColor() == discardPileTopCard.getColor() ) { // If the card matches the discardPileTopCard by color
							player.getHand()[pos].drawTwo(nextPlayer , deck);
							played = playCard( pos ,  discardPileTopCard);
							System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());
						}
					} else if (player.getHand()[pos] instanceof WildCard) {
						player.getHand()[pos].chooseColor(player);
						played = playCard( pos ,  discardPileTopCard);
						System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());

					} else if ( (player.getHand()[pos] instanceof WildDrawFour) ) { // If the card is a wild card 
						if ( isWildFourPlayable(pos,discardPileTopCard) == true ) { // A wildFourCard is playable only if it is the only playable card in the hand of the player.
							player.getHand()[pos].drawFourCards(player , nextPlayer , pos , deck);
							played = playCard( pos ,  discardPileTopCard);
							System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard() + ". " + nextPlayer.getName() +  " has been given 4 cards, and the new color is " + discardPileTopCard.getColor());
						}
					}
					pos++;
				} while ( played = false); // Repeat the playing process while the player hasn't played yet. This here is to make the player choose a playable card (we've verified before that there is at least one playable card is his hand with the if statement in line 14)
			}
		
		} else { // There are no playable cards in the hand of the player.
			
			boolean drawed = drawCard(1,deck); // Calls the drawCard method.
			if (drawed == true) {
				System.out.println(player.getName() + " had no card to play ,so he drawed one card.");
			} else {
				System.out.println(player.getName() + " had no card to play ,and there are no more cards left in the deck , so he passes his turn.");
			}
		}
		return player.getNbrCards(); // To make easier to check if the player won or not in the Game class.
	}
}	
