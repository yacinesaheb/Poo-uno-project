package poo_uno;

import java.util.Random;
import java.util.Scanner;

public abstract class Card { // THE COLOR SETTER AND GETTER IS HERE BECAUSE WE NEED IT IN WILDCARD AND WILDDRAWFOUR OR ELSE WE WOULD REDEFINE IT THERE.
	
	private String clr;
	public abstract String displayCard();
	public abstract int getNbr();
	public abstract void skip(Player nextPlayer);
	public abstract void reverse(int nbrOfPlayers,Player nextPlayer);
	public abstract void drawTwo(Player nextPlayer,Pile deck, Pile discardPile);
	public abstract void drawFourCards(Player player,Player nextPlayer,int pos,Pile deck,Pile discardPile,Scanner reader);
	
	public void setClr(String clr) { // clr's setter
		this.clr = clr;
	}
	
	public String getColor() { // clr's getter
	     return clr;
	 }
	
	// Choose color method for the wild cards.
	public void chooseColor(Player player,Scanner reader) {
		String color;
	if (player instanceof Human) {
		int colorvalue;
		do {
		System.out.printf( player.getName() + " please choose the color for the next turn (Choose between 1=Red / 2=Blue / 3=Green / 4=Yellow): ");
    	colorvalue = reader.nextInt();// Get the value of integer pos from the user.
    	switch (colorvalue) {
    		case 1 :
    			setClr("R"); // Sets the card color to red.
    			break;
    		case 2 :
    			setClr("B"); // Sets the card color to blue.
    			break;
    		case 3 :
    			setClr("G"); // Sets the card color to green.
    			break;
    		case 4 :
    			setClr("Y"); // Sets the card color to yellow.
    			break;
    	}
		} while (colorvalue != 1 && colorvalue != 2 && colorvalue != 3 && colorvalue != 4 ); // While color is different from Blue Red Green or Yellow
	} else if (player instanceof MediumRobot) { // The medium robot searches in his hand for the color from which he has the most cards , then chooses his color to match it.
		int nbBlue = 0,nbRed = 0,nbYellow = 0,nbGreen = 0; 
		int i;
		for (i = 0; i < player.getNbrCards();i++) {
			 if ( player.getHand()[i].getColor() != null ) {
			 switch (player.getHand()[i].getColor()) { // Check for the color of the "i"th card.
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
		}
		color = "R"; // We initialize color as red than compare with the other colors.
		if (nbRed < nbBlue) { // If there are strictly more blue cards then red cards.
			color = "B";
		} else if (nbRed < nbYellow) { // If there are strictly more yellow cards then red cards.
			color = "Y";
		} else if (nbRed < nbGreen) { // If there are strictly more green cards then red cards.
			color = "G";
		}
		setClr(color); // Sets the card color.
	} else if (player instanceof EasyRobot) { // The easy robot simply chooses his color randomly.
		String[] colors = { "R", "B", "G", "Y" }; // Initialize a table to draw randomly from it.
		Random randomcolor = new Random(); // Creating the randomizer.
        int randomIndex = randomcolor.nextInt(colors.length); // Takes a random index from the table (choose a random color).
        setClr(colors[randomIndex]); // Sets the card color .
	}
}
	
}
