package poo_uno;

import java.util.Scanner;

public class MediumRobot extends Player { // Robot of difficulty medium plays the Wild card better than the easy one , as he chooses the color depending on the number of cards he has in his hand from every color. He also doesn't play it as a first card.
	 
	public MediumRobot() {
	        super(); // Calls the Player constructor
	    }

	public void chooseColor(Scanner reader,Card playedCard) {
		String color;
		int nbBlue = 0,nbRed = 0,nbYellow = 0,nbGreen = 0; 
		int i;
		for (i = 0; i < this.getNbrCards();i++) {
			 if ( this.getHand()[i].getColor() != null ) {
			 switch (this.getHand()[i].getColor()) { // Check for the color of the "i"th card.
			 	case "R":
			 		nbRed++;
			 		break;
			 	case "B":
			 		nbBlue++;
			 		break;
			 	case "Y":
			 		nbYellow++;
			 		break;
			 	case "G":
			 		nbGreen++;
			 		break;
			 }
		}
		}
		color = "R"; // We initialize color as red than compare with the other colors.
		if (nbRed < nbBlue) { // If there are strictly more blue cards then red cards.
			color = "B";
		} else if (nbRed < nbYellow) { // If there are strictly more yellow cards then red cards.
			color = "Y";
		} else if (nbRed < nbGreen) { // If there are strictly more green cards then red cards.
			color = "G";
		}
		playedCard.setClr(color); // Sets the card color.
	}
	
	@Override
	public int playProcess(Player nextPlayer,Pile discardPile,Pile deck, boolean[] firstPlayedCard,int nbrOfPlayers, Scanner reader) { // For a robot , it plays the first playable card in his hand , except if it's a wildDrawFour we check before if it's the only playable card.
		
		int pos = 0; // Initializing the variable that will determine which card the player wants to play
		boolean played = false; // Check if the card has been successfully played to go out of the loop.
		
		if ( firstPlayedCard[0] == true ) { // If this is the first ever card played in the game
			firstPlayedCard[0] = false; // It's not the first played card anymore after the next player.
			do {
				// Determining the card played and play it.
				if ( (this.getHand()[pos] instanceof WildCard) || (this.getHand()[pos] instanceof WildDrawFour) ) { // If the card is a Wild type.
					// Doesn't play a wild card as a first card by choice, and can't play a wild draw four card first by definition.
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
						played = this.playCard( pos ,  discardPile);
						System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard() + ".");
					}
				} else { // If the card is any other type of cards.
					if ( this.getHand()[pos].cardMatches(discardPile) ) { // If the card matches the discardPileTopCard by color
						this.getHand()[pos].specialEvent(nextPlayer,nbrOfPlayers,deck,discardPile,reader);
						played = this.playCard( pos ,  discardPile);	
						System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
					}
				}
				pos++;
			} while ( ( played == false) && (drawn == false) ); // Repeat the playing process while the player hasn't played yet.
		} 
		return this.getNbrCards(); // To make easier to check if the player won or not in the Game class.
	}
}	
