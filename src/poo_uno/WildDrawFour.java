package poo_uno;

import java.util.Scanner;

public class WildDrawFour extends Card {
	
	@Override
	public String displayCard() {
		if ( this.getColor() == null ) {
			return ("WD4");
		} else {
			return (this.getColor() + "-WD4"); // It will be displayed as R-WC for example.
		}
	}


	@Override
	public void specialEvent(Player nextPlayer,int nbrOfPlayers, Pile deck, Pile discardPile, Scanner reader) { // Makes the next player draw 4 cards and skip his turn.
		nextPlayer.drawCard(4,deck,discardPile);
		nextPlayer.setSkip(true);
	}


	@Override
	public int getNbr() {
		// TODO Auto-generated method stub
		return 0;
	}
}
