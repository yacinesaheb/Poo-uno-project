package poo_uno;
import java.util.Scanner;

public class WildCard extends Card {

	@Override
	public String displayCard() {
		if ( this.getColor() == null ) {
			return ("WC");
		} else {
			return (this.getColor() + "-WC"); // It will be displayed as R-WC for example.
		}
	}


	@Override
	public void specialEvent(Player nextPlayer,int nbrOfPlayers, Pile deck, Pile discardPile, Scanner reader) {
		// This card does nothing by itself as the chooseColor method is in the player class.
	}


	@Override
	public int getNbr() {
		// TODO Auto-generated method stub
		return 0;
	}
}
