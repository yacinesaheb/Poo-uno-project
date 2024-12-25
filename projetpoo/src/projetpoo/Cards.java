package projetpoo;

public abstract class Cards {
	public enum Color {
        RED, BLUE, GREEN, YELLOW, WILD;
	
	}
    
    // Abstract methods that all cards must implement
    public abstract String getSpecialAction();
    public abstract Color getColor();
    
    @Override
    public abstract String toString();
    
    @Override
    public abstract boolean equals(Object obj);
    
    @Override
    public abstract int hashCode();
}

//ColoredCard class for all colored cards
public abstract class ColoredCard extends Cards {
 protected final Color color;
 
 protected ColoredCard(Color color) {//Valide que la couleur ne peut pas être WILD 
	 
     if (color == Color.WILD) {
         throw new IllegalArgumentException("Colored cards cannot have WILD color");
     }
     this.color = color;
 }
 
 @Override
 public Color getColor() {
     return color;
 }
 private 	Color clr;
 
 

public void setClr(Color clr) {
	this.clr = clr;
}

@Override
 public boolean equals(Object obj) {
     if (this == obj) return true;
     if (!(obj instanceof ColoredCard)) return false;
     ColoredCard other = (ColoredCard) obj;
     return color == other.color;
 }
 
 @Override
 public int hashCode() {
     return color.hashCode();
 }
}

//Regular number card
public class RegularCard extends ColoredCard {
	 public enum Numero {
	        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE;
	    }

	private Number nbr;
	
 public Number getNbr() {
		return nbr;
	}
 public RegularCard(Color color, Numero  nbr){
     super(color); // Appelle le constructeur de la classe parente
     this.nbr = nbr;
 }



 
 
 public void setNbr(Number nbr) {
		this.nbr = nbr;
	}
 
 
 

}

//Skip card
public class SkipCard extends ColoredCard {
 public SkipCard() {
     
 }
 
}

//Draw Two card
public class DrawTwoCard extends ColoredCard {
 public DrawTwoCard() {
     
 }
 
 
}

//Reverse card
public class ReverseCard extends ColoredCard {
 public ReverseCard() {

 }
 
}
 

 
 

 
 
 
 
 
 
 

