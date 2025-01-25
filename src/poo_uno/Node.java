package poo_uno;

import java.util.Scanner;

//Represents a node in a doubly linked list.Each node can store either a human player or a robot player.
public class Node {

    // Attributes
    private Player player; // Stores a player.
    Node next; // Pointer to the next node in the list
    Node prev; // Pointer to the previous node in the list

    // Constructor
    public Node() {
        this.player = null;
        this.next = null;
        this.prev = null;
    }
    // Getters
    public Player getnext(boolean gamedirection, Node tracker) {
  	  if (player != null) {
  		  
  		  if (gamedirection) {
  	            return tracker.next.player;
  	        } else {
  	            return tracker.prev.player;
  	        }
            
        }
		return null;
      
  }
    
    // Initializes the node for a human
    public void addHuman(String playerName) {
        this.player = new Human(); // Create a new Human object
        this.player.setName(playerName); // Assign the player's name
        this.next = null; // Initialize pointers to null
        this.prev = null;
    }

    // Initializes the node for a robot player.
    
    public void addMediumRobot(int i) {
    	this.player= new MediumRobot(); // Create a new Medium Robot object	
    	this.player.setName("medium robot "+i);
        this.next = null; // Initialize pointers to null
        this.prev = null;
    }
    
    public void addEasyRobot(int j) {
        this.player = new EasyRobot(); // Create a new Easy Robot object
        this.player.setName("easy robot "+j);
        this.next = null; // Initialize pointers to null
        this.prev = null;
    }

    //Displays information about the node.
    public void displayplayers() {
        if (player != null) {
            // Display the human player's name
            System.out.println("PLAYER NAME: " + player.getName());
        } else {
            // Indicate that the node is uninitialized
            System.out.println("NODE IS UNINITIALIZED");
        }
    }
   
    public void distribution (Pile deck,Pile discardPile) {
    	 if (player != null) {
             this.player.drawCard( 1,  deck, discardPile);
         }
    	}
    
    // --------------------------------------------------------------------------------------------
    // THE NEXT METHODS ARE REDEFINITIONS OF THE METHODS WE CAN FIND IN OTHER CLASSES.
    // WE DID THE REDEFINITIONS TO COVER SOME SPECIAL CASES THAT CAN'T BE COVERED
    // DIRECTLY IN THOSE CLASSES BECAUSE IT'S ABOUT THE GAME FLOW.
    // NOTE : ME, THE ONE WHO WROTE THIS COMMENT, DON'T REALLY SEE THE POINT OF THIS REDEFINITION 
    // BUT I HAD TO GIVE IT A SENSE SO WHATEVER.
    // ---------------------------------------------------------------------------------------------

    public int playProcess(Player nextplayer,Pile discardPile,Pile deck, boolean[] firstPlayedCard,int nbrOfPlayers,Scanner reader){
    	int temp=0;
		if (player != null) {
           return temp=player.playProcess(nextplayer, discardPile, deck,firstPlayedCard,nbrOfPlayers,reader);
        }
		return temp;
		}
    
    public int getnbrcards() {
        if (player!= null) {  
        return this.player.getNbrCards();
        }
		return 0;
    }
    
    public String getnames() {
        if (player!= null) {  
        return this.player.getName();
        }
		return "";
    }

    
 // Method to remove the node from the list. This here is to remove a player whenever his number of cards drops to 0 (so he wins basically).
    public void removeNode() {
        if (this.prev != null) {
            this.prev.next = this.next;
        }
        if (this.next != null) {
            this.next.prev = this.prev;
        }
    }

}
