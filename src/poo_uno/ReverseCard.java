package poo_uno;

public class ReverseCard extends ColoredCard {
	
	// ReverseCard constructor
	public ReverseCard (String clr) {
		 setClr(clr);;	 
	 }
	
	@Override
	public void reverse() {
		if (Game.getGamedirection() == true) {
		Game.setGamedirection(false);
		} else if (Game.getGamedirection() == false) {
			Game.setGamedirection(true);
		}
	}

	@Override
	public String displayCard() {
		return (getColor() + "-Rev"); // It will be displayed as R-Rev for example.
		
	}

	// Not needed methods for this class :
	@Override
	public int getNbr() {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public void skip() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void drawTwo(Player nextPlayer,Card[] hand,int playerNbrCards,Deck decks) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void chooseColor(Player player,Card[] hand,int playerNbrCards) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawFourCards(Player player,Player nextPlayer,Card[] hand,int pos,int playerNbrCards,Deck deck) {
		// TODO Auto-generated method stub
		
	}

}
