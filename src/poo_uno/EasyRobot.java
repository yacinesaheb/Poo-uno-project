package poo_uno;

import java.util.Scanner;
import java.util.Random;

public class EasyRobot extends Player { // Robot of difficulty easy chooses the color randomly when playing the Wild card, and can play the WildCard as a first card.

	  public EasyRobot() {
	        super(); // Calls the Player constructor
	    }
	  
	  public void chooseColor(Scanner reader,Card playedCard) {
		  String[] colors = { "R", "B", "G", "Y" }; // Initialize a table to draw randomly from it.
		  Random randomcolor = new Random(); // Creating the randomizer.
		  int randomIndex = randomcolor.nextInt(colors.length); // Takes a random index from the table (choose a random color).
		  playedCard.setClr(colors[randomIndex]); // Sets the card color .
	  }
	@Override
	public int playProcess(Player nextPlayer,Pile discardPile,Pile deck, boolean[] firstPlayedCard,int nbrOfPlayers, Scanner reader) { // For a robot , it plays the first playable card in his hand , except if it's a wildDrawFour we check before if it's the only playable card.
		
		int pos = 0; // Initializing the variable that will determine which card the player wants to play
		boolean played = false; // Check if the card has been successfully played to go out of the loop.
		
		if ( firstPlayedCard[0] == true ) { // If this is the first ever card played in the game
			firstPlayedCard[0] = false; // It's not the first played card anymore after the next player.
			do {
				// Determining the card played and play it.
				if (this.getHand()[pos] instanceof WildCard) { // If the card is a wild card.
					this.chooseColor(reader,this.getHand()[pos]);
					played = this.playCard( pos ,  discardPile);
					System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
				} else if ( (this.getHand()[pos] instanceof WildDrawFour) ) { // If the card is a wild draw four card.
					// Can't play a wild draw four card as a first card.
				} else { // If the card is any other type of cards.
					this.getHand()[pos].specialEvent(nextPlayer,nbrOfPlayers,deck,discardPile,reader);
					played = this.playCard( pos ,  discardPile);
					System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
				}	
				pos++;
			} while (played == false); // Repeat the playing process while the player hasn't played yet. We don't need to verify if he can play a card because it's the first played card of the game.
		
		} else if ( this.getSkip() == true ) { // The player's turn has been skipped.
			System.out.println(this.getName() + " has to skip his turn because the previous player played a skip or a draw card !");
			this.setSkip(false);
		
		} else {
			boolean drawn = false;
			if ( checkPlayableCards(discardPile) == false) { // There are no playable cards in the hand of the robot.
				System.out.println(this.getName() + " has no playable cards. So he will draw one card.");
				drawn = drawCard(1,deck,discardPile); // Sets drawn to true so that there will be only one iteration in the do-while bellow stops directly.
				pos = this.getNbrCards() - 1; // Skips directly to the drawn card to not re-check the whole hand.
			}
			do {
				// Determining the card played and play it.
				if (this.getHand()[pos] instanceof WildCard) { // Determining the card played and play it.
					this.chooseColor(reader,this.getHand()[pos]);
					played = this.playCard( pos ,  discardPile);
					System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
				} else if ( (this.getHand()[pos] instanceof WildDrawFour) ) { // If the card is a wild card 
					if ( isWildFourPlayable(pos,discardPile) == true ) {
						this.chooseColor(reader,this.getHand()[pos]);
						this.getHand()[pos].specialEvent(nextPlayer,nbrOfPlayers,deck,discardPile,reader);
						played = this.playCard( pos ,discardPile);
						System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard() + ".");
					}
				} else { // If the card is any other type of cards.
					if ( this.getHand()[pos].cardMatches(discardPile) ) { // If the card matches the discardPileTopCard by color
						this.getHand()[pos].specialEvent(nextPlayer,nbrOfPlayers,deck,discardPile,reader);
						played = this.playCard( pos ,discardPile);	
						System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
					}
				}
				pos++;
			} while ( ( played == false) && (drawn == false) ); // Repeat the playing process while the player hasn't played yet.
		} 
		return this.getNbrCards(); // To make easier to check if the player won or not in the Game class.
	}

}