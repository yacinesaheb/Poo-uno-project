package poo_uno;

public abstract class ColoredCard extends Card {
	
	private Color clr;
	
	public Color getColor() { // clr's getter
	     return clr;
	 }
	
	public void setClr(Color clr) { // clr's setter
		this.clr = clr;
	}
	
	public abstract void displayCard();
	
}
