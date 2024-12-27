package poo_uno;

public class Node {

	// Classe pour représenter un nœud
	
	    private Human human;
	    private Robot robot ;
	    
	    Node next;      // Pointeur vers le nœud suivant
	    Node prev;      // Pointeur vers le nœud précédent

	    // Constructeur pour initialiser le nœud
	    public void addHuman(String playername) {
	    	
	    	  this.human = new Human(); // Initialize the player object
	          this.human.setName(playername); // Now it's safe to set the name
	          this.next = null; 
	        this.prev = null;
	    }
	    
	    public void displayhuman() {
	    	
	    	System.out.println("PLAYER NAME:"+human.getName());
				    }
	}
	

