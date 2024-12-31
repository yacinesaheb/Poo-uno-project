package poo_uno;
import java.util.Scanner;
import java.util.Random;

public class WildCard extends Card {
	
	public void chooseColor(Player player) {
			String color;
		if (player instanceof Human) {
			do {
			System.out.printf( player.getName(), " please choose the color for the next turn (Choose between R B G Y): ");
	    	Scanner readcolor = new Scanner(System.in); // Initialize a string scanner.
	    	color = readcolor.nextLine(); // Get the value of integer pos from the user.
	    	readcolor.close(); // Close the reader.
			} while (color != "R" && color != "B" && color != "Y" && color != "G" ); // While color is different from Blue Red Green or Yellow
			setClr(color); // Sets the card color
		} else if (player instanceof MediumRobot) { // The medium robot searches in his hand for the color from which he has the most cards , then chooses his color to match it.
			int nbBlue = 0,nbRed = 0,nbYellow = 0,nbGreen = 0; 
			int i;
			for (i = 0; i < player.getNbrCards();i++) {
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
			// Get a random index between 0 and elements.length - 1
	        int randomIndex = randomcolor.nextInt(colors.length); // Takes a random index from the table (choose a random color).
	        setClr(colors[randomIndex]); // Sets the card color .
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
	public void skip(Player nextPlayer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawTwo(Player nextPlayer,Deck deck) {
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
