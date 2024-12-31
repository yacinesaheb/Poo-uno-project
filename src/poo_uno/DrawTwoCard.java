package poo_uno;

public class DrawTwoCard extends ColoredCard {
	
	// DrawTwoCard class constructor 
	 public DrawTwoCard (String clr) {
		 setClr(clr);	 
	 }
	 
	@Override
	public void drawTwo(Player nextPlayer,Deck deck) {
			nextPlayer.drawCard(2,deck);
		}

	@Override
	public String displayCard() {
		return getColor() + "-D2"; // It will be displayed as R-D2 for example.
		
	}

	// Not needed methods for this class :
	@Override
	public int getNbr() {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public void skip(Player nextPlayer) {
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
