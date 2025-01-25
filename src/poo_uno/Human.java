package poo_uno;
import java.util.Scanner;


public class Human extends Player { 
		
	// Human's constructor.
	public Human() {
	   super(); // Calls the Player constructor to initialize the hand
	}
	
	public void displayHand() {
	    System.out.print("Player " + getName() + "'s hand (" + getNbrCards() + " cards): ");
	    int i = 0;
	    while (i < this.getNbrCards()) {
	        System.out.print("(" + (i+1) + ")" + this.getHand()[i].displayCard() + " / ");
	        i++;
	    }
	    System.out.println("");
	}
	
	public int chooseCard(Scanner reader) {
		int pos;
		this.displayHand();
		do {
	    	System.out.println( this.getName()+ " please choose a card to play from your deck (Choose a number from 1 to " + this.getNbrCards() + ")");
	    	pos = reader.nextInt() - 1; // Get the value of integer pos from the user.
	    }
	    while ( ( pos < 0 ) || ( pos > this.getNbrCards()) ); // Condition to get a correct position
		return pos;
	}
	
	public void chooseColor(Scanner reader,Card playedCard) {
		int colorvalue;
		do {
			System.out.printf( this.getName() + " please choose the color for the next turn (Choose between 1=Red / 2=Blue / 3=Green / 4=Yellow): ");
			colorvalue = reader.nextInt(); // Get the value of integer colorvalue from the user.
			switch (colorvalue) {
	    		case 1 :
	    			playedCard.setClr("R"); // Sets the card color to red.
	    			break;
	    		case 2 :
	    			playedCard.setClr("B"); // Sets the card color to blue.
	    			break;
	    		case 3 :
	    			playedCard.setClr("G"); // Sets the card color to green.
	    			break;
	    		case 4 :
	    			playedCard.setClr("Y"); // Sets the card color to yellow.
	    			break;
			}
		} while (colorvalue != 1 && colorvalue != 2 && colorvalue != 3 && colorvalue != 4 ); // While color is different from Blue Red Green or Yellow
	}
	
	
	@Override
	public int playProcess(Player nextPlayer,Pile discardPile,Pile deck, boolean[] firstPlayedCard,int nbrOfPlayers,Scanner reader) { // For a player , he gets to choose which card he plays from his hand. The only special case is the wildDrawFour card that can only be played when there are no other options.
			
			int pos; // Initializing the variable that will determine which card the player wants to play
			boolean played = false; // Check if the card has been successfully played to go out of the loop.
			
			if ( firstPlayedCard[0] == true ) { // If this is the first ever card played in the game
				firstPlayedCard[0] = false; // It's not the first played card anymore after the next player.
				do {
					pos =this.chooseCard(reader); // Asking the player to choose a card from his deck to play
					
					// Determining the card played and play it.
					if (this.getHand()[pos] instanceof WildCard) { // If the card is a wild card.
						this.chooseColor(reader,this.getHand()[pos]);
						played = this.playCard( pos ,  discardPile);
						System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
					} else if ( (this.getHand()[pos] instanceof WildDrawFour) ) { // If the card is a wild draw four card.
						System.out.println(this.getName() + ", You can't play a wild draw four card as a first card ! ");
					} else { // If the card is any other type of cards.
						this.getHand()[pos].specialEvent(nextPlayer,nbrOfPlayers,deck,discardPile,reader);
						played = this.playCard( pos ,  discardPile);
						System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
					}
			    } while (played == false); // Repeat the playing process while the player hasn't played yet. We don't need to verify if he can play a card because it's the first played card of the game.
			
			} else if ( this.getSkip() == true ) { // If the player's turn must be skipped.
				System.out.println(this.getName() + " has to skip his turn because the previous player played a skip or a draw card !");
				this.setSkip(false);	
				
			} else { // The player can play normally.
				boolean drawn = false;
				if (checkPlayableCards(discardPile) == false ) { // The player has no playable cards.
					System.out.println(this.getName() + " has no playable cards. So he will draw one card.");
					drawn = drawCard(1,deck,discardPile);
				}
				
				// -------------------------------------------------------------------------------
				// HERE WE USED TWO DEPENDANT IF STATEMENTS AND NOT A SINGLE IF-ELSE STATEMENT
				// THAT'S BECAUSE WE WANT TO CHECK THE SECOND EVEN IF THE FIRST ONE IS TRUE SO
				// THAT WE CAN PLAY A CARD THAT HAS BEEN DRAWN. WE ALSO COULD HAVE MADE THE 
				// DRAWN CARD BE PLAYED DIRECTLY BUT WE PREFERRED TO MAKE THE PLAYER CHOOSE SO
				// BECAUSE IF THERE WAS A SUCCESSION OF DRAWING FOR LIKE 5 6 TURNS IT WOULD SPAM
				// THE CONSOLE AND WE'D HAVE TO RECHECK EVERY LINE.
				// -------------------------------------------------------------------------------
				
				if ( checkPlayableCards(discardPile) == true ) { // Checks if the player has a playable card
					do {
						pos =this.chooseCard(reader);  // Asking the player to choose a card from his deck to play.
					
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
							} else {
								System.out.println(this.getName() + ", you can't play a wild draw four card because you have at least one other playable card.");
							}
						} else { // If the card is any other type of cards.
							if ( this.getHand()[pos].cardMatches(discardPile) ) { // If the card matches the discardPileTopCard by color
								this.getHand()[pos].specialEvent(nextPlayer,nbrOfPlayers,deck,discardPile,reader);
								played = this.playCard( pos ,  discardPile);	
								System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
							}
						}
					} while ( (played == false) && (drawn == false) ); // Repeat the playing process while the player hasn't played yet.
				}
		} 	
		return this.getNbrCards(); // To make easier to check if the player won or not in the Game class.
	}

}
