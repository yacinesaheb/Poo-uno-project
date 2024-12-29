package poo_uno;

public class WildDrawFour extends Card {
	
	public void drawFourCards(Player player,Player nextPlayer,Card[] hand,int pos,int playerNbrCards,Deck deck) {
		hand[pos].chooseColor(player,hand,playerNbrCards);
		nextPlayer.drawCard(hand, 4, playerNbrCards, deck);
	}

	@Override
	public String displayCard() {
		return (getColor() + "-WD4") ;
		
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
	public void drawTwo(Player nextPlayer,Card[] hand,int playerNbrCards,Deck deck) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chooseColor(Player player,Card[] hand,int playerNbrCards) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		
	}
}
