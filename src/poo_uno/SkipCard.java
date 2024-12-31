package poo_uno;

public class SkipCard extends ColoredCard {
	
	// SkipCard constructor
	public SkipCard (String clr) {
		 setClr(clr);;	 
	 }
	
	@Override
	public void skip(Player nextPlayer) { // Sets the skip boolean to true for the next player.
		nextPlayer.setSkip(true);
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
	public void drawTwo(Player nextPlayer,Deck deck) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chooseColor(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawFourCards(Player player,Player nextPlayer,int pos,Deck deck) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		
	}

}
