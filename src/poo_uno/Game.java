package poo_uno;

import java.util.Scanner;

public class Game {

	
	
    // Methods of the class Game
	

    // Attributes
    private int currentplayer; // Tracks the current player//i think this one will go 
    private Deck deck=new Deck(); // Represents the deck of cards (implement Deck separately)
    private static boolean gamedirection = true; // Tracks the game direction (true for clockwise, false for counterclockwise)//this one comes from player class from play process.
    private Turn turn = new Turn();// Linked list to manage players
    private static Node tracker = new Node();
    private Card discardPileTopCard;


    // Attributes for players
    private int numberofplayers; // Total number of players
    private String playersnames; // Array to store player names

    // Getters and setters of some attributes.
    public Card getDiscardPileTopCard() { // discardPileTopCard's getter
    	return discardPileTopCard;
    }
    
    public void setDiscardPileTopCard(Card discardPileTopCard) { // discardPileTopCard's setter
    	this.discardPileTopCard = discardPileTopCard;
    }
    
	public static boolean getGamedirection() { // Game direction getter
		return gamedirection; 
	}

	public static void setGamedirection(boolean gamedirection) { // Game direction setter
		Game.gamedirection = gamedirection; 
	}

    
    
    
    //Fills the Turn linked list with players.Adds human players first, followed by any additional robots (if applicable).
    public void fillTurn(Scanner reader) {
    	//Asks the user how many players will participate in the game.     
    	System.out.println("How many players?");
        this.numberofplayers = reader.nextInt(); // Read the number of players
        reader.nextLine(); // Consume the newline character to avoid skipping input
    	
    	
    	
    	int i = 0;
        // Add human players to the turn
        while (i < this.numberofplayers) {
        	int humanorrobot;
        	do {
        	  System.out.println("Is player"+(i+1)+ " a human or a robot ?");
        	  System.out.println("1-human      2-robot");
              humanorrobot = reader.nextInt(); // Read the number of players
              reader.nextLine();
        	}while(humanorrobot !=1 && humanorrobot!=2 );
        	
        	
        	if(humanorrobot==1) {
        		 System.out.println("what is his name ?");
        		 this.playersnames = reader.nextLine();
                 this.turn.addHumain(this.playersnames);
            }else 
            {    
            	this.turn.addMediumRobot();
            }
            i++;
        }

      
    }
    // To go over the list .
    public void next() {
    	Game.tracker=turn.next(gamedirection, tracker);            	
    }
    //distribution.
    public void distribution () {
    	
    	int totalCardsToDistribute = 7 * numberofplayers;
    	  for (int i = 0; i < totalCardsToDistribute; i++) {
    		
    			
    		Game.tracker.displayplayers();// I use display to test but after i will change it to draw card when the method is ready	
    		next();	
    			
    			    		    		    		
    	}    	    	                                      	
    	
    }
    // Main method to execute the game setup and display the player list.
     
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in); // Create the Scanner here
        Game game = new Game();
        
        // Game setup
        game.fillTurn(reader); // Populate the Turn linked list with players
        Game.tracker=game.turn.gethead();//give the head to the tracker 
        //test distribution
        game.distribution();
        // Display the players in turn order
        game.turn.display();
     
        reader.close(); // Close the Scanner at the end
        
        
        
    }
}
