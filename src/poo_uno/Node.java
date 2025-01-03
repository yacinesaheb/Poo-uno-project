package poo_uno;

import java.util.Scanner;

//Represents a node in a doubly linked list.Each node can store either a human player or a robot player.
public class Node {

    // Attributes
    private Human human; // Stores a Human player (null if this node represents a Robot)
    private MediumRobot mrobot; // Stores a Robot player (null if this node represents a Human)
    private EasyRobot erobot;

    Node next; // Pointer to the next node in the list
    Node prev; // Pointer to the previous node in the list

    // Methods
    public Node() {
        this.human = null;
        this.mrobot = null;
        this.erobot = null;
        this.next = null;
        this.prev = null;
    }
    // Constructor//note sure i need it 
    public Player getnext() {
    	  if (human != null) {
    		  return human;
              
          } else if (mrobot != null) {
            return mrobot;
          }else if (erobot != null) {
        	  return erobot; 
          }  
          else {
              // Indicate that the node is uninitialized
              System.out.println("NODE IS UNINITIALIZED");
          }
		return null;
        
    }
    public void setNode(String playerType, String playerName) {
        if ("human".equalsIgnoreCase(playerType)) {
            addHuman(playerName);
        } else if ("robot".equalsIgnoreCase(playerType)) {
            addMediumRobot();
        } else {
            System.out.println("Invalid player type. Use 'human' or 'robot'.");
        }
    }
    // Initializes the node for a human player.playerName The name of the human player to be added.
    public void addHuman(String playerName) {
        this.human = new Human(); // Create a new Human object
        this.human.setName(playerName); // Assign the player's name
        
        this.next = null; // Initialize pointers to null
        this.prev = null;
    }

    // Initializes the node for a robot player. (You can expand the Robot class to include more attributes if needed.)
    public void addMediumRobot() {
        this.mrobot = new MediumRobot(); // Create a new Medium Robot object
        this.next = null; // Initialize pointers to null
        this.prev = null;
    }

    public void addEasyRobot() {
        this.erobot = new EasyRobot(); // Create a new Medium Robot object
        this.next = null; // Initialize pointers to null
        this.prev = null;
    }

    //Displays information about the node.If the node represents a human player, it displays the player's name.Otherwise, it indicates that the node represents a robot.
    public void displayplayers() {
        if (human != null) {
            // Display the human player's name
            System.out.println("PLAYER NAME: " + human.getName());
        } else if (mrobot != null) {
            // Indicate that this node represents a robot
            System.out.println("ROBOT (MEDIUM)");
        }else if (erobot != null) {
            // Indicate that this node represents a robot
            System.out.println("ROBOT(EASY)");
        }  
        else {
            // Indicate that the node is uninitialized
            System.out.println("NODE IS UNINITIALIZED");
        }
    }
    public void displayHumanhand() {
        if (human != null) {
            // Display the human hand
            this.human.displayHand();
        }
       }
    
    
    //method to draw
    public void distribution (Pile deck,Pile discardPile) {
    	 if (human != null) {
             this.human.drawCard( 1,  deck, discardPile);
         } else if (mrobot != null) {
             // Indicate that this node represents a robot
        	 this.mrobot.drawCard( 1,  deck ,discardPile);
         }else if (erobot != null) {
             // Indicate that this node represents a robot
        	 this.erobot.drawCard( 1,  deck, discardPile);
         }  
         else {
             // Indicate that the node is uninitialized
             System.out.println("NODE IS UNINITIALIZED");
         }
    	
    	
    	
    	
    	
    	
    }


    public int playProcess(Player nextplayer,Pile discardPile,Pile deck, boolean[] firstPlayedCard,int nbrOfPlayers,        Scanner reader){
    	int temp=0;
		if (human != null) {
           return temp=human.playProcess(nextplayer, discardPile, deck,firstPlayedCard,nbrOfPlayers,reader);
        } else if (mrobot != null) {
            // Indicate that this node represents a robot
        	return temp=mrobot.playProcess(nextplayer, discardPile, deck,firstPlayedCard,nbrOfPlayers,reader);
        }else if (erobot != null) {
            // Indicate that this node represents a robot
        	return temp=erobot.playProcess(nextplayer, discardPile, deck,firstPlayedCard,nbrOfPlayers,reader);
        }  
        else {
            // Indicate that the node is uninitialized
            System.out.println("NODE IS UNINITIALIZED");
        }
		return temp;
		
		
		
	}





}
