package poo_uno;

public class RegularCard extends ColoredCard {
	
	// Set all the possible numbers
			String[] Number = {  "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE" };
			
	// Initialize the attributes		
	private String nbr;
	
	// Class RegularCard constructor
	public RegularCard(String clr, String nbr) {
		this.nbr = nbr;
		setClr(clr); ;
	}
	
	public String getNbr() { // nbr's getter
		return nbr;
	}
	public void setNbr(String nbr) { // nbr's setter
		this.nbr = nbr;
	}
	 
	 
	 public void displayCard() { // Display a regular card
		System.out.println("Color : " + getColor() + " / Number : " + getNbr());
	}
	@Override
	public void skip() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void drawTwo() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void chooseColor() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void drawFourCards() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		
	}
	 
}
