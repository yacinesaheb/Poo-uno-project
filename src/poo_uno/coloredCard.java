package poo_uno;

public abstract class ColoredCard extends Card {
	
	private String clr;
	
	public String getColor() { // clr's getter
	     return clr;
	 }
	
	public void setColor(String clr) { // clr's setter
		this.clr = clr;
	}
	
	public abstract void displayCard();
	
}
