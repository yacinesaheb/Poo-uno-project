package poo_uno;
import java.util.Scanner;


	public class Human extends Player { 
		public Human() {
	        super(); // Calls the Player constructor to initialize the hand
	    }
	
	@Override
	
	public int playProcess(Player player,Player nextPlayer,Card[] hand,Card discardPileTopCard,int playerNbrCards,Deck deck) { // For a player , he gets to choose which card he plays from his hand. The only special case is the wildDrawFour card that can only be played when there are no other options.
			
			int pos; // Initializing the variable that will determine which card the player wants to play
			boolean played = false; // Check if the card has been successfully played to go out of the loop.
			
			if (checkPlayableCards(  discardPileTopCard ) == true ) {
			do {
				
			// Asking the player to choose a card from his deck to play
		    do {
		    	System.out.printf( player.getName(), " please choose a card to play from your deck (Choose a number from 1 to n such as n): ");
		    	Scanner readpos = new Scanner(System.in); // Initialize an integer scanner.
		    	pos = readpos.nextInt(); // Get the value of integer pos from the user.
		    	readpos.close();
		    }
		    while ( ( pos > 0 ) && ( pos <= playerNbrCards) ); // Condition to get a correct position
		    
		    // Determining the card played and play it.
			if (hand[pos] instanceof RegularCard) { // If the card is a regular card
				if ( (hand[pos].getColor() == discardPileTopCard.getColor() ) || (hand[pos].getNbr() == discardPileTopCard.getNbr() ) ) { // If the card matches the discardPileTopCard by color or number.
					played = playCard( pos ,  discardPileTopCard);
					System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());
				}
			} else if (hand[pos] instanceof SkipCard) {
				if ( hand[pos].getColor() == discardPileTopCard.getColor() ) { // If the card matches the discardPileTopCard by color
					hand[pos].skip();
					played = playCard( pos ,  discardPileTopCard);	
					System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());
				}
			} else if (hand[pos] instanceof ReverseCard) {
				if ( hand[pos].getColor() == discardPileTopCard.getColor() ) { // If the card matches the discardPileTopCard by color
					hand[pos].reverse();
					played = playCard( pos , discardPileTopCard);
					System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());
				} 
			} else if (hand[pos] instanceof DrawTwoCard) {
				if ( hand[pos].getColor() == discardPileTopCard.getColor() ) { // If the card matches the discardPileTopCard by color
					hand[pos].drawTwo(nextPlayer,hand,playerNbrCards,deck);
					played = playCard( pos , discardPileTopCard);
					System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());
				}
			} else if (hand[pos] instanceof WildCard) {
					hand[pos].chooseColor(player,hand,playerNbrCards);
					played = playCard( pos ,  discardPileTopCard);
					System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard());

			} else if ( (hand[pos] instanceof WildDrawFour) ) { // If the card is a wild card 
					if ( isWildFourPlayable(pos,discardPileTopCard) == true ) {
						hand[pos].drawFourCards(player , nextPlayer , hand , pos , playerNbrCards , deck);
						played = playCard( pos ,  discardPileTopCard);
						System.out.println(player.getName() + " just played " + discardPileTopCard.displayCard() + ". " + nextPlayer.getName() +  " has been given 4 cards, and the new color is " + discardPileTopCard.getColor());
					}
			  }	
			}
			while (played = false);
		} else {
			boolean drawed = drawCard(1,deck);
			if (drawed == true) {
				System.out.println(player.getName() + " had no card to play ,so he drawed one card.");
			} else {
				System.out.println(player.getName() + " had no card to play ,and there are no more cards left in the deck , so he passes his turn.");
			}
		}
			
		return playerNbrCards; // To make easier to check if the player won or not in the Game class.
	}

}
