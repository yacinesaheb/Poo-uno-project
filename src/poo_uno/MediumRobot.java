package poo_uno;

import java.util.Scanner;

public class MediumRobot extends Player { // Robot of difficulty medium plays the Wild card better than the easy one , as he chooses the color depending on the number of cards he has in his hand from every color. He also doesn't play the wild card as a first card.
	 public MediumRobot() {
	        super(); // Calls the Player constructor
	    }

	@Override
public int playProcess(Player nextPlayer,Pile discardPile,Pile deck, Boolean firstPlayedCard,int nbrOfPlayers, Scanner reader) { // For a robot , it plays the first playable card in his hand , except if it's a wildDrawFour we check before if it's the only playable card.
		
		int pos = 0; // Initializing the variable that will determine which card the player wants to play
		boolean played = false; // Check if the card has been successfully played to go out of the loop.
		
		if ( firstPlayedCard == true ) { // If this is the first ever card played in the game
			
			firstPlayedCard = false; // It's not the first played card anymore after the next player.
		
		do {
		    // Determining the card played and play it.
			if (this.getHand()[pos] instanceof RegularCard) { // If the card is a regular card
				played = this.playCard( pos ,  discardPile);
				System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
			} else if (this.getHand()[pos] instanceof SkipCard) {
				this.getHand()[pos].skip(nextPlayer);
				played = this.playCard( pos ,  discardPile);	
				System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
			} else if (this.getHand()[pos] instanceof ReverseCard) {
				this.getHand()[pos].reverse(nbrOfPlayers,nextPlayer);
				played = this.playCard( pos , discardPile);
				System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
			} else if (this.getHand()[pos] instanceof DrawTwoCard) {
				this.getHand()[pos].drawTwo(nextPlayer,deck,discardPile);
				played = this.playCard( pos , discardPile);
				System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
			}
			pos++;
		    } while (played == false); // Repeat the playing process while the player hasn't played yet. We don't need to verify if he can play a card because it's the first played card of the game.
		
		} else if ( checkPlayableCards(discardPile) == true) { // There is at least one playable card in the hand of the player (including wildDrawFour).
			if ( this.getSkip() == true ) {
				System.out.println(this.getName() + " has to skip his turn because the previous player played a skip card !");
				played = true;
				this.setSkip(false);
			} else {
				do {
			
					// Determining the card played and play it.
					if (this.getHand()[pos] instanceof RegularCard) { // If the card is a regular card
						if ( (this.getHand()[pos].getColor() == discardPile.getTopCard().getColor() ) || (this.getHand()[pos].getNbr() == discardPile.getTopCard().getNbr() ) ) { // If the card matches the discardPileTopCard by color or number.
							played = this.playCard( pos ,  discardPile);
							System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
						}
					} else if (this.getHand()[pos] instanceof SkipCard) {
						if ( this.getHand()[pos].getColor() == discardPile.getTopCard().getColor() ) { // If the card matches the discardPileTopCard by color
							this.getHand()[pos].skip(nextPlayer);
							played = this.playCard( pos ,  discardPile);
							System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
						}
					} else if (this.getHand()[pos] instanceof ReverseCard) {
						if ( this.getHand()[pos].getColor() == discardPile.getTopCard().getColor() ) { // If the card matches the discardPileTopCard by color
							this.getHand()[pos].reverse(nbrOfPlayers,nextPlayer);
							played = this.playCard( pos ,  discardPile);
							System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
						} 
					} else if (this.getHand()[pos] instanceof DrawTwoCard) {
						if ( this.getHand()[pos].getColor() == discardPile.getTopCard().getColor() ) { // If the card matches the discardPileTopCard by color
							this.getHand()[pos].drawTwo(nextPlayer , deck,discardPile);
							played = this.playCard( pos ,  discardPile);
							System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
						}
					} else if (this.getHand()[pos] instanceof WildCard) {
						this.getHand()[pos].chooseColor(this);
						played = this.playCard( pos , discardPile);
						System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());

					} else if ( (this.getHand()[pos] instanceof WildDrawFour) ) { // If the card is a wild card 
						if ( isWildFourPlayable(pos,discardPile) == true ) { // A wildFourCard is playable only if it is the only playable card in the hand of the player.
							this.getHand()[pos].drawFourCards(this , nextPlayer , pos , deck,discardPile);
							played = this.playCard( pos ,  discardPile);
							System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard() + ". " + nextPlayer.getName() +  " has been given 4 cards, and the new color is " + discardPile.getTopCard().getColor());
						}
					}
					pos++;
				} while ( played = false); // Repeat the playing process while the player hasn't played yet. This here is to make the player choose a playable card (we've verified before that there is at least one playable card is his hand with the if statement in line 14)
			}
		
		} else { // There are no playable cards in the hand of the player.
			drawCard(1,deck,discardPile); // Calls the drawCard method.
			
			// Checks if the drawn card matches the discardPile top card and play it if it does.
				if (this.getHand()[getNbrCards() - 1] instanceof RegularCard) { // If the card is a regular card
					if ( (this.getHand()[getNbrCards() - 1].getColor() == discardPile.getTopCard().getColor() ) || (this.getHand()[getNbrCards() - 1].getNbr() == discardPile.getTopCard().getNbr() ) ) { // If the card matches the discardPileTopCard by color or number.
						this.playCard( getNbrCards() - 1 ,  discardPile);
						System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
					}
				} else if (this.getHand()[getNbrCards() - 1] instanceof SkipCard) {
					if ( this.getHand()[getNbrCards() - 1].getColor() == discardPile.getTopCard().getColor() ) { // If the card matches the discardPileTopCard by color
						this.getHand()[getNbrCards() - 1].skip(nextPlayer);
						this.playCard( getNbrCards() - 1 ,  discardPile);	
						System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
					}
				} else if (this.getHand()[getNbrCards() - 1] instanceof ReverseCard) {
					if ( this.getHand()[getNbrCards() - 1].getColor() == discardPile.getTopCard().getColor() ) { // If the card matches the discardPileTopCard by color
						this.getHand()[getNbrCards() - 1].reverse(nbrOfPlayers,nextPlayer);
						this.playCard( getNbrCards() - 1 , discardPile);
						System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
					} 
				} else if (this.getHand()[getNbrCards() - 1] instanceof DrawTwoCard) {
					if ( this.getHand()[getNbrCards() - 1].getColor() == discardPile.getTopCard().getColor() ) { // If the card matches the discardPileTopCard by color
						this.getHand()[getNbrCards() - 1].drawTwo(nextPlayer,deck,discardPile);
						this.playCard( getNbrCards() - 1 , discardPile);
						System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
					}
				} else if (this.getHand()[getNbrCards() - 1] instanceof WildCard) {
					this.getHand()[getNbrCards() - 1].chooseColor(this);
					this.playCard( getNbrCards() - 1 ,  discardPile);
					System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());

				} else if ( (this.getHand()[getNbrCards() - 1] instanceof WildDrawFour) ) { // If the card is a wild card 
					this.getHand()[getNbrCards() - 1].drawFourCards(this , nextPlayer , getNbrCards() - 1 ,  deck,discardPile);
					this.playCard( getNbrCards() - 1 ,  discardPile);
					System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard() + ". " + nextPlayer.getName() +  " has been given 4 cards, and the new color is " + discardPile.getTopCard().getColor());
				 } 			
		}
		return this.getNbrCards(); // To make easier to check if the player won or not in the Game class.
	}
}	
