package poo_uno;
import java.util.Scanner;


	public class Human extends Player {
	
	
	@Override
	public int playProcess(Player player,Card[] hand,Card discardPileTopCard,int nbrCards) { // For a player , he gets to choose which card he plays from his hand. The only special case is the wildDrawFour card that can only be played when there are no other options.
			
			int pos; // Initializing the variable that will determine which card the player wants to play
			boolean played = false; // Check if the card has been successfully played to go out of the loop.
			
			if (checkPlayableCards( getHand() ,nbrCards, discardPileTopCard ) == true ) {
			do {
				
			// Asking the player to choose a card from his deck to play
		    do {
		    	System.out.printf( player.getName(), " please choose a card to play from your deck (Choose a number from 1 to n such as n): ");
		    	Scanner readpos = new Scanner(System.in); // Initialize an integer scanner.
		    	pos = readpos.nextInt(); // Get the value of integer pos from the user.
		    	readpos.close();
		    }
		    while ( ( pos > 0 ) && ( pos <= nbrCards) ); // Condition to get a correct position
		    
		    // Determining the card played and play it.
			if (hand[pos] instanceof RegularCard) { // If the card is a regular card
				if ( (hand[pos].getColor() == discardPileTopCard.getColor() ) || (hand[pos].getNbr() == discardPileTopCard.getNbr() ) ) { // If the card matches the discardPileTopCard by color or number.
					played = playCard(getHand() , pos , nbrCards, discardPileTopCard); 
				}
			} else if (hand[pos] instanceof SkipCard) {
				if ( hand[pos].getColor() == discardPileTopCard.getColor() ) { // If the card matches the discardPileTopCard by color
					hand[pos].skip();
					played = playCard(getHand() , pos , nbrCards, discardPileTopCard);	
				}
			} else if (hand[pos] instanceof ReverseCard) {
				if ( hand[pos].getColor() == discardPileTopCard.getColor() ) { // If the card matches the discardPileTopCard by color
					hand[pos].reverse();
					played = playCard(getHand() , pos , nbrCards, discardPileTopCard);
				} 
			} else if (hand[pos] instanceof DrawTwoCard) {
				if ( hand[pos].getColor() == discardPileTopCard.getColor() ) { // If the card matches the discardPileTopCard by color
					hand[pos].drawTwo();
					played = playCard(getHand() , pos , nbrCards, discardPileTopCard);
				}
			} else if (hand[pos] instanceof WildCard) {
					hand[pos].chooseColor();
					played = playCard(getHand() , pos , nbrCards, discardPileTopCard);

			} else if ( (hand[pos] instanceof WildDrawFour) ) { // If the card is a wild card 
					if ( isWildFourPlayable(getHand(),pos,nbrCards,discardPileTopCard) == true ) {
						hand[pos].drawFourCards();
						played = playCard(getHand() , pos , nbrCards, discardPileTopCard);
					}
			  }	
			}
			while (played = false);
		} else {
			drawCard(1); // THIS IS TEMPORARY UNTILL I GET THE STRUCTURE OF THE DECK SO THAT I MAKE THE CONDITION OF UNTILL DECK IS EMPTY.
		}
			
		return nbrCards; // To make easier to check if the player won or not in the Game class.
	}

}
