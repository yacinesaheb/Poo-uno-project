package poo_uno;

public abstract class Card { // THE COLOR SETTER AND GETTER IS HERE BECAUSE WE NEED IT IN WILDCARD AND WILDDRAWFOUR OR ELSE WE WOULD REDEFINE IT THERE.
	
	private String clr;
	@Override
	public String toString() {
	    // Example for RegularCard: display its color and number
	    if (this instanceof RegularCard) {
	        return "RegularCard: " + getColor() + " " + getNbr();
	    } else if (this instanceof DrawTwoCard) {
	        return "DrawTwoCard: " + getColor();
	    } else if (this instanceof ReverseCard) {
	        return "ReverseCard: " + getColor();
	    } else if (this instanceof SkipCard) {
	        return "SkipCard: " + getColor();
	    } else if (this instanceof WildCard) {
	        return "WildCard";
	    } else if (this instanceof WildDrawFour) {
	        return "WildDrawFour";
	    } else {
	        return "Unknown Card";
	    }
	}
	public abstract String displayCard();
	public abstract int getNbr();
	public abstract void skip();
	public abstract void reverse();
	public abstract void drawTwo(Player nextPlayer,Card[] hand,int playerNbrCards,Deck deck);
	public abstract void chooseColor(Player player,Card[] hand,int playerNbrCards);
	public abstract void drawFourCards(Player player,Player nextPlayer,Card[] hand,int pos,int playerNbrCards,Deck deck);
	
	public void setClr(String clr) { // clr's setter
		this.clr = clr;
	}
	
	public String getColor() { // clr's getter
	     return clr;
	 }
	
	
}
