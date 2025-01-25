package poo_uno;

import java.util.Scanner;

public abstract class Card { 
	
	private String clr; // String of the color of any card.
	public abstract String displayCard(); // Equivalent of toString(). Displays the card as a text to recognize it.
	public abstract int getNbr();
	public abstract void specialEvent(Player nextPlayer,int nbrOfPlayers,Pile deck,Pile discardPile,Scanner reader);
	
	public boolean cardMatches(Pile discardPile) { // Equivalent to equals(). Checks if a card matches the top card in play.
		boolean match = false;
		if (this.clr == discardPile.getTopCard().getColor() ) {
			return true;
		}
		return match;
	}
	
	public void setClr(String clr) { // clr's setter
		this.clr = clr;
	}
	
	public String getColor() { // clr's getter
	     return clr;
	 }	
}
