package poo_uno;

import java.util.Scanner;

public class ReverseCard extends Card {
	
	// ReverseCard constructor
	public ReverseCard (String clr) {
		 setClr(clr);;	 
	 }

	@Override
	public String displayCard() {
		return (getColor() + "-Rev"); // It will be displayed as R-Rev for example.
		
	}

	@Override
	public void specialEvent(Player nextPlayer,int nbrOfPlayers, Pile deck, Pile discardPile, Scanner reader) {
		if (nbrOfPlayers == 2) {
			System.out.println("As the number of players is 2 , the reverse card acts as a skip card.");
			nextPlayer.setSkip(true);
		} else {
		if (Game.getGamedirection() == true) {
		Game.setGamedirection(false);
		} else if (Game.getGamedirection() == false) {
			Game.setGamedirection(true);
		}
		System.out.println("The game sense has been reverted.");
		}
	}

	@Override
	public int getNbr() {
		// TODO Auto-generated method stub
		return 0;
	}
}
