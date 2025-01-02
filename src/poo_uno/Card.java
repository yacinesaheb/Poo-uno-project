package poo_uno;

public abstract class Card { // THE COLOR SETTER AND GETTER IS HERE BECAUSE WE NEED IT IN WILDCARD AND WILDDRAWFOUR OR ELSE WE WOULD REDEFINE IT THERE.
	
	private String clr;
	public abstract String displayCard();
	public abstract int getNbr();
	public abstract void skip(Player nextPlayer);
	public abstract void reverse(int nbrOfPlayers,Player nextPlayer);
	public abstract void drawTwo(Player nextPlayer,Pile deck, Pile discardPile);
	public abstract void chooseColor(Player player);
	public abstract void drawFourCards(Player player,Player nextPlayer,int pos,Pile deck,Pile discardPile);
	
	public void setClr(String clr) { // clr's setter
		this.clr = clr;
	}
	
	public String getColor() { // clr's getter
	     return clr;
	 }
	
	
}
