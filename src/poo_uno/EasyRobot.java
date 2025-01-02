package poo_uno;

public class EasyRobot extends Player { // Robot of difficulty easy chooses the color randomly when playing the Wild card, and can play the WildCard as a first card.

	  public EasyRobot() {
	        super(); // Calls the Player constructor
	    }
	@Override
	
	public int playProcess(Player player,Player nextPlayer,Pile discardPile,Pile deck, Boolean firstPlayedCard,int nbrOfPlayers) { // For a robot , it plays the first playable card in his hand , except if it's a wildDrawFour we check before if it's the only playable card.
		
		int pos = 0; // Initializing the variable that will determine which card the player wants to play
		boolean played = false; // Check if the card has been successfully played to go out of the loop.
		
		if ( firstPlayedCard == true ) { // If this is the first ever card played in the game
			
			firstPlayedCard = false; // It's not the first played card anymore after the next player.
		
		do {
		    // Determining the card played and play it.
			if (player.getHand()[pos] instanceof RegularCard) { // If the card is a regular card
				played = player.playCard( pos ,  discardPile);
				System.out.println(player.getName() + " just played " + discardPile.getTopCard().displayCard());
			} else if (player.getHand()[pos] instanceof SkipCard) {
				player.getHand()[pos].skip(nextPlayer);
				played = player.playCard( pos ,  discardPile);	
				System.out.println(player.getName() + " just played " + discardPile.getTopCard().displayCard());
			} else if (player.getHand()[pos] instanceof ReverseCard) {
				player.getHand()[pos].reverse(nbrOfPlayers,nextPlayer);
				played = player.playCard( pos , discardPile);
				System.out.println(player.getName() + " just played " + discardPile.getTopCard().displayCard());
			} else if (player.getHand()[pos] instanceof DrawTwoCard) {
				player.getHand()[pos].drawTwo(nextPlayer,deck,discardPile);
				played = player.playCard( pos , discardPile);
				System.out.println(player.getName() + " just played " + discardPile.getTopCard().displayCard());
			} else if (player.getHand()[pos] instanceof WildCard) {
				player.getHand()[pos].chooseColor(player);
				played = player.playCard(pos,discardPile);
				System.out.println(player.getName() + " just played " + discardPile.getTopCard().displayCard());
			}
			pos++;
		    } while (played == false); // Repeat the playing process while the player hasn't played yet. We don't need to verify if he can play a card because it's the first played card of the game.
		
		} else if ( checkPlayableCards(discardPile) == true) { // There is at least one playable card in the hand of the player (including wildDrawFour).
			if ( player.getSkip() == true ) {
				System.out.println(player.getName() + " has to skip his turn because the previous player played a skip card !");
				played = true;
				player.setSkip(false);
			} else {
				do {
			
					// Determining the card played and play it.
					if (player.getHand()[pos] instanceof RegularCard) { // If the card is a regular card
						if ( (player.getHand()[pos].getColor() == discardPile.getTopCard().getColor() ) || (player.getHand()[pos].getNbr() == discardPile.getTopCard().getNbr() ) ) { // If the card matches the discardPileTopCard by color or number.
							played = player.playCard( pos ,  discardPile);
							System.out.println(player.getName() + " just played " + discardPile.getTopCard().displayCard());
						}
					} else if (player.getHand()[pos] instanceof SkipCard) {
						if ( player.getHand()[pos].getColor() == discardPile.getTopCard().getColor() ) { // If the card matches the discardPileTopCard by color
							player.getHand()[pos].skip(nextPlayer);
							played = player.playCard( pos ,  discardPile);
							System.out.println(player.getName() + " just played " + discardPile.getTopCard().displayCard());
						}
					} else if (player.getHand()[pos] instanceof ReverseCard) {
						if ( player.getHand()[pos].getColor() == discardPile.getTopCard().getColor() ) { // If the card matches the discardPileTopCard by color
							player.getHand()[pos].reverse(nbrOfPlayers,nextPlayer);
							played = player.playCard( pos ,  discardPile);
							System.out.println(player.getName() + " just played " + discardPile.getTopCard().displayCard());
						} 
					} else if (player.getHand()[pos] instanceof DrawTwoCard) {
						if ( player.getHand()[pos].getColor() == discardPile.getTopCard().getColor() ) { // If the card matches the discardPileTopCard by color
							player.getHand()[pos].drawTwo(nextPlayer , deck,discardPile);
							played = player.playCard( pos ,  discardPile);
							System.out.println(player.getName() + " just played " + discardPile.getTopCard().displayCard());
						}
					} else if (player.getHand()[pos] instanceof WildCard) {
						player.getHand()[pos].chooseColor(player);
						played = player.playCard( pos ,  discardPile);
						System.out.println(player.getName() + " just played " + discardPile.getTopCard().displayCard());

					} else if ( (player.getHand()[pos] instanceof WildDrawFour) ) { // If the card is a wild card 
						if ( isWildFourPlayable(pos,discardPile) == true ) { // A wildFourCard is playable only if it is the only playable card in the hand of the player.
							player.getHand()[pos].drawFourCards(player , nextPlayer , pos , deck,discardPile);
							played = player.playCard( pos ,  discardPile);
							System.out.println(player.getName() + " just played " + discardPile.getTopCard().displayCard() + ". " + nextPlayer.getName() +  " has been given 4 cards, and the new color is " + discardPile.getTopCard().getColor());
						}
					}
					pos++;
				} while ( played = false); // Repeat the playing process while the player hasn't played yet. This here is to make the player choose a playable card (we've verified before that there is at least one playable card is his hand with the if statement in line 14)
			}
		
		} else { // There are no playable cards in the hand of the player.
			drawCard(1,deck,discardPile); // Calls the drawCard method.
			
			// Checks if the drawn card matches the discardPile top card and play it if it does.
				if (player.getHand()[getNbrCards() - 1] instanceof RegularCard) { // If the card is a regular card
					if ( (player.getHand()[getNbrCards() - 1].getColor() == discardPile.getTopCard().getColor() ) || (player.getHand()[getNbrCards() - 1].getNbr() == discardPile.getTopCard().getNbr() ) ) { // If the card matches the discardPileTopCard by color or number.
						player.playCard( getNbrCards() - 1 ,  discardPile);
						System.out.println(player.getName() + " just played " + discardPile.getTopCard().displayCard());
					}
				} else if (player.getHand()[getNbrCards() - 1] instanceof SkipCard) {
					if ( player.getHand()[getNbrCards() - 1].getColor() == discardPile.getTopCard().getColor() ) { // If the card matches the discardPileTopCard by color
						player.getHand()[getNbrCards() - 1].skip(nextPlayer);
						player.playCard( getNbrCards() - 1 ,  discardPile);	
						System.out.println(player.getName() + " just played " + discardPile.getTopCard().displayCard());
					}
				} else if (player.getHand()[getNbrCards() - 1] instanceof ReverseCard) {
					if ( player.getHand()[getNbrCards() - 1].getColor() == discardPile.getTopCard().getColor() ) { // If the card matches the discardPileTopCard by color
						player.getHand()[getNbrCards() - 1].reverse(nbrOfPlayers,nextPlayer);
						player.playCard( getNbrCards() - 1 , discardPile);
						System.out.println(player.getName() + " just played " + discardPile.getTopCard().displayCard());
					} 
				} else if (player.getHand()[getNbrCards() - 1] instanceof DrawTwoCard) {
					if ( player.getHand()[getNbrCards() - 1].getColor() == discardPile.getTopCard().getColor() ) { // If the card matches the discardPileTopCard by color
						player.getHand()[getNbrCards() - 1].drawTwo(nextPlayer,deck,discardPile);
						player.playCard( getNbrCards() - 1 , discardPile);
						System.out.println(player.getName() + " just played " + discardPile.getTopCard().displayCard());
					}
				} else if (player.getHand()[getNbrCards() - 1] instanceof WildCard) {
					player.getHand()[getNbrCards() - 1].chooseColor(player);
					player.playCard( getNbrCards() - 1 ,  discardPile);
					System.out.println(player.getName() + " just played " + discardPile.getTopCard().displayCard());

				} else if ( (player.getHand()[getNbrCards() - 1] instanceof WildDrawFour) ) { // If the card is a wild card 
					player.getHand()[getNbrCards() - 1].drawFourCards(player , nextPlayer , getNbrCards() - 1 ,  deck,discardPile);
					player.playCard( getNbrCards() - 1 ,  discardPile);
					System.out.println(player.getName() + " just played " + discardPile.getTopCard().displayCard() + ". " + nextPlayer.getName() +  " has been given 4 cards, and the new color is " + discardPile.getTopCard().getColor());
				} 
		}
		return player.getNbrCards(); // To make easier to check if the player won or not in the Game class.
	}

}