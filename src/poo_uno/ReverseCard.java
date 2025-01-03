package poo_uno;

import java.util.Scanner;

public class ReverseCard extends ColoredCard {
	
	// ReverseCard constructor
	public ReverseCard (String clr) {
		 setClr(clr);;	 
	 }
	
	@Override
	public void reverse(int nbrOfPlayers,Player nextPlayer) {
		if (nbrOfPlayers == 2) {
			System.out.println("As the number of players is 2 , the reverse card acts as a skip card.");
			nextPlayer.setSkip(true);
		} else {
		if (Game.getGamedirection() == true) {
		Game.setGamedirection(false);
		} else if (Game.getGamedirection() == false) {
			Game.setGamedirection(true);
		}
		System.out.println("The game sense has been changed.");
		}
	}

	@Override
	public String displayCard() {
		return (getColor() + "-Rev"); // It will be displayed as R-Rev for example.
		
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
	public void chooseColor(Player player,Scanner reader) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawFourCards(Player player,Player nextPlayer,int pos,Pile deck,Pile discardPile,Scanner reader) {
		// TODO Auto-generated method stub
		
	}

}
