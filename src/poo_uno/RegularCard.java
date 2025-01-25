package poo_uno;

import java.util.Scanner;

public class RegularCard extends Card {
	

	// Initialize the attributes		
	private int nbr;
	
	// Class RegularCard constructor
	public RegularCard(String clr, int nbr) {
		this.nbr = nbr;
		this.setClr(clr) ;
	}
	
	public int getNbr() { // nbr's getter
		return nbr;
	}
	public void setNbr(int nbr) { // nbr's setter
		this.nbr = nbr;
	}
	 
	@Override 
	public String displayCard() { // Display a regular card
		return getColor() + "-" + getNbr(); // It will be displayed as R-0 for example.
	}

	@Override
	public boolean cardMatches(Pile discardPile) {
		boolean match = false;
		if ( ( this.getColor() == discardPile.getTopCard().getColor() ) || (this.nbr == discardPile.getTopCard().getNbr()) ) {
			return true;
		}
		return match;		
	}
	@Override
	public void specialEvent(Player nextPlayer,int nbrOfPlayers, Pile deck, Pile discardPile, Scanner reader) {
		// This method does nothing for a regular card.
	}	 
}
