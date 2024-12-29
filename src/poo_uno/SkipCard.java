package poo_uno;

public class SkipCard extends ColoredCard {
	
	// SkipCard constructor
	public SkipCard (String clr) {
		 setClr(clr);;	 
	 }
	
	@Override
	public void skip() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String displayCard() {
		return null;
		
	}

	// Not needed methods for this class :
	@Override
	public int getNbr() {
		// TODO Auto-generated method stub
		return -1;
	}


	@Override
	public void drawTwo(Player nextPlayer,Card[] hand,int playerNbrCards,Deck deck) {
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

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		
	}

}
