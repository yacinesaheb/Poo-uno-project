package poo_uno;

public class RegularCard extends ColoredCard {
	
	public enum Numero { // Set all the possible numbers
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE;
    }
	
	private Number nbr;
	
	public Number getNbr() { // nbr's getter
		return nbr;
	}
	public void setNbr(Number nbr) { // nbr's setter
		this.nbr = nbr;
	}
	 
	 
	 public void displayCard() { // Display a regular card
		System.out.println("Color : " + getColor() + " / Number : " + getNbr());
	}
	 
}
