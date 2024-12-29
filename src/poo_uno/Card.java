package poo_uno;

public abstract class Card { // THE COLOR SETTER AND GETTER IS HERE BECAUSE WE NEED IT IN WILDCARD AND WILDDRAWFOUR OR ELSE WE WOULD REDEFINE IT THERE.
	
	private String clr;
	
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
