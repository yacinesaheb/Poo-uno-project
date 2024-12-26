package poo_uno;

public class Node {

	// Classe pour représenter un nœud
	
	    private String playername;
	    private Deck deck;
	    Node next;      // Pointeur vers le nœud suivant
	    Node prev;      // Pointeur vers le nœud précédent

	    // Constructeur pour initialiser le nœud
	    public Node(String playername,Deck deck) {
	        this.playername = playername;
	        this.deck=deck;
	        this.next = null;
	        this.prev = null;
	    }
	    
	    public void display() {
	    	
	    	System.out.println("PLAYER NAME:"+this.playername);
			System.out.println("methode dans la classe deck:"+this.deck);//this is just for test there is a display methode for deck classe
	    	
	    }
	}
	

