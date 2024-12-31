package poo_uno;
import java.util.Scanner;


	public class Human extends Player { 
		
		// Human's constructor.
		public Human() {
	        super(); // Calls the Player constructor to initialize the hand
	    }
		
	@Override
	public int playProcess(Player player,Player nextPlayer,Card discardPileTopCard,Deck deck, Boolean firstPlayedCard) { // For a player , he gets to choose which card he plays from his hand. The only special case is the wildDrawFour card that can only be played when there are no other options.
			
			int pos; // Initializing the variable that will determine which card the player wants to play
			boolean played = false; // Check if the card has been successfully played to go out of the loop.
			
			if ( firstPlayedCard == true ) { // If this is the first ever card played in the game
				
				firstPlayedCard = false; // It's not the first played card anymore after the next player.
				
				do {
				// Asking the player to choose a card from his deck to play
			    do {
			    	System.out.printf( player.getName(), " please choose a card to play from your deck (Choose a number from 1 to n such as n): ");
			    	Scanner readpos = new Scanner(System.in); // Initialize an integer scanner.
			    	pos = readpos.nextInt(); // Get the value of integer pos from the user.
			    	readpos.close();
			    }
			    while ( ( pos > 0 ) && ( pos <= player.getNbrCards()) ); // Condition to get a correct position
			    
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
					played = playCard( pos ,  discardPileTopCard);
					System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());
				} else if ( (player.getHand()[pos] instanceof WildDrawFour) ) { // If the card is a wild card 
							System.out.println(player.getName() + ". You can't play a wild draw four card as a first card ! ");
					}
			    } while (played == false); // Repeat the playing process while the player hasn't played yet. We don't need to verify if he can play a card because it's the first played card of the game.
			
			} else if (checkPlayableCards(discardPileTopCard) == true ) {
			do {
				if ( player.getSkip() == true ) {
					System.out.println(player.getName() + " has to skip his turn because the previous player played a skip card !");
					played = true;
					player.setSkip(false);
				} else {
				
			// Asking the player to choose a card from his deck to play
		    do {
		    	System.out.printf( player.getName(), " please choose a card to play from your deck (Choose a number from 1 to n such as n): ");
		    	Scanner readpos = new Scanner(System.in); // Initialize an integer scanner.
		    	pos = readpos.nextInt(); // Get the value of integer pos from the user.
		    	readpos.close();
		    }
		    while ( ( pos > 0 ) && ( pos <= player.getNbrCards()) ); // Condition to get a correct position
		    
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
					played = playCard( pos , discardPileTopCard);
					System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());
				} 
			} else if (player.getHand()[pos] instanceof DrawTwoCard) {
				if ( player.getHand()[pos].getColor() == discardPileTopCard.getColor() ) { // If the card matches the discardPileTopCard by color
					player.getHand()[pos].drawTwo(nextPlayer,deck);
					played = playCard( pos , discardPileTopCard);
					System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());
				}
			} else if (player.getHand()[pos] instanceof WildCard) {
				player.getHand()[pos].chooseColor(player);
					played = playCard( pos ,  discardPileTopCard);
					System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());

			} else if ( (player.getHand()[pos] instanceof WildDrawFour) ) { // If the card is a wild card 
					if ( isWildFourPlayable(pos,discardPileTopCard) == true ) {
						player.getHand()[pos].drawFourCards(player , nextPlayer , pos ,  deck);
						played = playCard( pos ,  discardPileTopCard);
						System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard() + ". " + nextPlayer.getName() +  " has been given 4 cards, and the new color is " + discardPileTopCard.getColor());
					}
			    }
			}
		} while (played = false); // Repeat the playing process while the player hasn't played yet. This here is to make the player choose a playable card (we've verified before that there is at least one playable card is his hand with the if statement in line 18)
			
		} else {
			boolean drawed = drawCard(1,deck);
			if (drawed == true) {
				System.out.println(player.getName() + " had no card to play ,so he drawed one card.");
			} else {
				System.out.println(player.getName() + " had no card to play ,and there are no more cards left in the deck , so he passes his turn.");
			}
		}
			
		return player.getNbrCards(); // To make easier to check if the player won or not in the Game class.
	}
	
	public void displayHand() {
	    System.out.println("Player " + getName() + "'s hand (" + getNbrCards() + " cards):");
	    int i = 0;
	    while( i < this.getNbrCards() ) {
	    	   System.out.print(this.getHand()[i].displayCard()+"/");// Assumes Card class has a meaningful `toString` method
	    	    i++;
	    }
	    System.out.println("");
	}

}
