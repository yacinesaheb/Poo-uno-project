package poo_uno;
import java.util.Scanner;


	public class Human extends Player { 
		
		// Human's constructor.
		public Human() {
	        super(); // Calls the Player constructor to initialize the hand
	    }
		
	@Override
	public int playProcess(Player nextPlayer,Pile discardPile,Pile deck, Boolean firstPlayedCard,int nbrOfPlayers,   Scanner reader) { // For a player , he gets to choose which card he plays from his hand. The only special case is the wildDrawFour card that can only be played when there are no other options.
			
			int pos; // Initializing the variable that will determine which card the player wants to play
			boolean played = false; // Check if the card has been successfully played to go out of the loop.
			
			if ( firstPlayedCard == true ) { // If this is the first ever card played in the game
				
				firstPlayedCard = false; // It's not the first played card anymore after the next player.
				
				do {
				// Asking the player to choose a card from his deck to play
			    do {
			    	System.out.println( this.getName()+ " please choose a card to play from your deck (Choose a number from 1 to n such as n = " + this.getNbrCards() + ")");
			    	
			    	pos = reader.nextInt() - 1; // Get the value of integer pos from the user.
			    	
			    }
			    while ( ( pos < 0 ) || ( pos > this.getNbrCards()) ); // Condition to get a correct position
			    
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
				} else if (this.getHand()[pos] instanceof WildCard) {
					this.getHand()[pos].chooseColor(this);
					played = this.playCard( pos ,  discardPile);
					System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
				} else if ( (this.getHand()[pos] instanceof WildDrawFour) ) { // If the card is a wild card 
							System.out.println(this.getName() + ". You can't play a wild draw four card as a first card ! ");
					}
			    } while (played == false); // Repeat the playing process while the player hasn't played yet. We don't need to verify if he can play a card because it's the first played card of the game.
			
			} else if (checkPlayableCards(discardPile) == true ) {
			do {
				if ( this.getSkip() == true ) {
					System.out.println(this.getName() + " has to skip his turn because the previous player played a skip card !");
					played = true;
					this.setSkip(false);
				} else {
				
			// Asking the player to choose a card from his deck to play
				do {
				    System.out.printf( this.getName(), " please choose a card to play from your deck (Choose a number from 1 to n such as n = " + this.getNbrCards() + ")");
				    Scanner readpos = new Scanner(System.in); // Initialize an integer scanner.
				    pos = readpos.nextInt() - 1; // Get the value of integer pos from the user.
				    readpos.close();
				   } while ( ( pos > 0 ) && ( pos <= this.getNbrCards()) ); // Condition to get a correct position
				
		    
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
					played = this.playCard( pos , discardPile);
					System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
				} 
			} else if (this.getHand()[pos] instanceof DrawTwoCard) {
				if ( this.getHand()[pos].getColor() == discardPile.getTopCard().getColor() ) { // If the card matches the discardPileTopCard by color
					this.getHand()[pos].drawTwo(nextPlayer,deck,discardPile);
					played = this.playCard( pos , discardPile);
					System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());
				}
			} else if (this.getHand()[pos] instanceof WildCard) {
				this.getHand()[pos].chooseColor(this);
					played = this.playCard( pos ,  discardPile);
					System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard());

			} else if ( (this.getHand()[pos] instanceof WildDrawFour) ) { // If the card is a wild card 
					if ( isWildFourPlayable(pos,discardPile) == true ) {
						this.getHand()[pos].drawFourCards(this , nextPlayer , pos ,  deck,discardPile);
						played = this.playCard( pos ,  discardPile);
						System.out.println(this.getName() + " just played " + discardPile.getTopCard().displayCard() + ". " + nextPlayer.getName() +  " has been given 4 cards, and the new color is " + discardPile.getTopCard().getColor());
					}
			    }
			}
		} while (played = false); // Repeat the playing process while the player hasn't played yet. This here is to make the player choose a playable card (we've verified before that there is at least one playable card is his hand with the if statement in line 18)
			
		} else { // There are no playable card in the hand of the player or it's not the first turn.
			System.out.println(this.getName() + " has no playable cards. So he will draw one card.");
			drawCard(1,deck,discardPile);
			
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
	
	public void displayHand() {
	    System.out.println("Player " + getName() + "'s hand (" + getNbrCards() + " cards):");
	    int i = 0;
	    while (i < this.getNbrCards()) {
	        if (this.getHand()[i] != null) {
	            System.out.print(this.getHand()[i].displayCard() + "/");
	        } else {
	            System.out.print("null/");
	        }
	        i++;
	    }
	    System.out.println("");
	}

}
