package poo_uno;

public abstract class Card {
	
	// Setting colors to only red blue green and yellow (we set it here because we need it in wild cards)
		String[] Color = { "RED", "BLUE", "GREEN", "YELLOW" };
	
	public abstract void displayCard();
	public abstract String getColor();
	public abstract String getNbr();
	public abstract void skip();
	public abstract void reverse();
	public abstract void drawTwo();
	public abstract void chooseColor();
	public abstract void drawFourCards();
	
	
}
