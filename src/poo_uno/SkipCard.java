package poo_uno;

import java.util.Scanner;

public class SkipCard extends Card {
	
	// SkipCard constructor
	public SkipCard (String clr) {
		 setClr(clr);;	 
	 }

	@Override
	public String displayCard() {
		return (getColor() + "-Skip"); // It will be displayed as R-Skip for example.
		
	}

	@Override
	public void specialEvent(Player nextPlayer,int nbrOfPlayers, Pile deck, Pile discardPile,Scanner reader) {
		nextPlayer.setSkip(true);
	}

}
