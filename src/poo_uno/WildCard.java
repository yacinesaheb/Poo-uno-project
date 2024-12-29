package poo_uno;
import java.util.Scanner;

public class WildCard extends Card {
	
	public void chooseColor(Player player,Card[] hand,int playerNbrCards) {
			String color;
		if (player instanceof Human) {
			do {
			System.out.printf( player.getName(), " please choose the color for the next turn (Choose between R B G Y): ");
	    	Scanner readcolor = new Scanner(System.in); // Initialize a string scanner.
	    	color = readcolor.nextLine(); // Get the value of integer pos from the user.
	    	readcolor.close();
			} while (color != "R" && color != "B" && color != "Y" && color != "G" );
			setClr(color);
		} else if (player instanceof Robot) { // The robot searches in his hand for the color from which he has the most cards , then chooses his color to match it.
			int nbBlue = 0,nbRed = 0,nbYellow = 0,nbGreen = 0; 
			int i;
			for (i = 0; i < playerNbrCards;i++) {
				 switch (hand[i].getColor()) { // Check for the color of the "i"th card.
				 	case "R":
				 		nbRed++;
				 		break;
				 	case "B":
				 		nbBlue++;
				 		break;
				 	case "Y":
				 		nbYellow++;
				 		break;
				 	case "G":
				 		nbGreen++;
				 		break;
				 }
			}
			color = "R"; // We initialize color as red than compare with the other colors.
			if (nbRed < nbBlue) { // If there are strictly more blue cards then red cards.
				color = "B";
			} else if (nbRed < nbYellow) { // If there are strictly more yellow cards then red cards.
				color = "Y";
			} else if (nbRed < nbGreen) { // If there are strictly more green cards then red cards.
				color = "G";
			}
			setClr(color);
		}
	}

	@Override
	public String displayCard() {
		return(getColor() + "-WC"); // It will be displayed as R-WC for example.
		
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
	public void drawFourCards(Player player,Player nextPlayer,Card[] hand,int pos,int playerNbrCards,Deck deck) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		
	}

}
