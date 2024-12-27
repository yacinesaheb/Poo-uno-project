package poo_uno;

public abstract class Card {
	
	  // Setting colors to only red blue green and yellow (we set it here because we need it in wild cards)
	String[] Color = { "RED", "BLUE", "GREEN", "YELLOW" };	
	
	
	public abstract void displayCard();
	public abstract String getColor();
	public abstract Number getNbr();
	
}