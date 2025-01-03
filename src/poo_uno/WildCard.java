package poo_uno;
import java.util.Scanner;

public class WildCard extends Card {

	@Override
	public String displayCard() {
		return(getColor() + "-WC"); // It will be displayed as R-WC for example.
		
	}

	
	// Not needed methods for this class :

	@Override
	public int getNbr() {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public void skip(Player nextPlayer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawTwo(Player nextPlayer,Pile deck,Pile discardPile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawFourCards(Player player,Player nextPlayer,int pos,Pile deck,Pile discardPile,Scanner reader) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reverse(int nbrOfPlayers,Player nextPlayer) {
		// TODO Auto-generated method stub
		
	}

}
