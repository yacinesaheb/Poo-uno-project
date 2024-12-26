package poo_uno;

public abstract class Card {
	
	public enum Color { // Setting colors to only red blue green and yellow (we set it here because we need it in wild cards)
        RED, BLUE, GREEN, YELLOW;	
	}
	
	public abstract void displayCard();
	public abstract Color getColor();
	public abstract Number getNbr();
	
}
