package poo_uno;

import java.util.Scanner;

public class RegularCard extends ColoredCard {
	
	// Set all the possible numbers
			int[] Number = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			
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
	 
	 
	 public String displayCard() { // Display a regular card
		return getColor() + "-" + getNbr(); // It will be displayed as R-0 for example.
	}
	 
	 // Not needed methods for this class :
	@Override
	public void skip(Player nextPlayer) {
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
	@Override
	public void reverse(int nbrOfPlayers,Player nextPlayer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawTwo(Player nextPlayer,Pile deck,Pile discardPile) {
		// TODO Auto-generated method stub
		
	}
	 
}
