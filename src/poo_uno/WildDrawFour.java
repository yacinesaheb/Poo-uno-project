package poo_uno;

public class WildDrawFour extends Card {
	
	public void drawFourCards(Player player,Player nextPlayer,int pos,Pile deck,Pile discardPile) {
		player.getHand()[pos].chooseColor(player);
		nextPlayer.drawCard( 4,  deck,discardPile);
		skip(nextPlayer);
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
	public void skip(Player nextPlayer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawTwo(Player nextPlayer,Pile deck,Pile discardPile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chooseColor(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reverse(int nbrOfPlayers,Player nextPlayer) {
		// TODO Auto-generated method stub
		
	}
}
