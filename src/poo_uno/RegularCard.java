package poo_uno;

public class RegularCard extends ColoredCard {
	
	// Set all the possible numbers
		String[] Number = {  "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE" };
    
	
	private String nbr;
	
	
	
	public RegularCard(String clr, String nbr) {
		this.nbr = nbr;
		setColor(clr); ;
	}
	
	
	
	public String getNumber() { // nbr's getter
		return nbr;
	}
	
	
	public void setNumber(String nbr) { // nbr's setter
		this.nbr = nbr;
	}
	 
	 
	 public void displayCard() { // Display a regular card
		System.out.println("Color : " + getColor() + " / Number : " + getNbr());
	}



	@Override
	public java.lang.Number getNbr() {
		// TODO Auto-generated method stub
		return null;
	}
	 
}