package poo_uno;

import java.util.Scanner;

public class DrawTwoCard extends Card {
	
	// DrawTwoCard class constructor 
	 public DrawTwoCard (String clr) {
		 setClr(clr);	 
	 }

	@Override
	public String displayCard() {
		return getColor() + "-D2"; // It will be displayed as R-D2 for example.
		
	}

	@Override
	public void specialEvent(Player nextPlayer,int nbrOfPlayers, Pile deck, Pile discardPile, Scanner reader) {
		nextPlayer.drawCard(2,deck,discardPile);
	}

	@Override
	public int getNbr() {
		// TODO Auto-generated method stub
		return 0;
	}
}
