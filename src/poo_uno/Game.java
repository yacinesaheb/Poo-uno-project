package poo_uno;

import java.util.Scanner;

public class Game {

    // Attributes
    private Pile deck; // Represents the deck of cards (implement Deck separately)
    private static boolean gamedirection = true; // Tracks the game direction (true for clockwise, false for counterclockwise)
    private Turn turn = new Turn();// Linked list to manage players
    private static Node tracker = new Node();
    private Pile discardPile;
    private boolean[] firstPlayedCard = { true };
    private int numberofplayers; // Total number of players
    private String playersnames; // Array to store player names

    // Getters and setters of some attributes.
	public static boolean getGamedirection() { // Game direction getter
		return gamedirection; 
	}

	public static void setGamedirection(boolean gamedirection) { // Game direction setter
		Game.gamedirection = gamedirection; 
	}

    //Fills the Turn linked list with players.Adds human players first, followed by any additional robots (if applicable).
    public void fillTurn(Scanner reader) {   
    	System.out.println("How many players?");
        this.numberofplayers = reader.nextInt(); // Read the number of players
        reader.nextLine(); // Consume the newline character to avoid skipping input
    	int i = 0;
        // Add humans and robots players to the turn
        while (i < this.numberofplayers) {
        	int humanorrobot;
        	do {
        	  System.out.println("Is player"+(i+1)+ " a human or a robot ?");
        	  System.out.println("1-human      2-robot");
              humanorrobot = reader.nextInt(); // Read the type of players
              reader.nextLine();
        	}while(humanorrobot !=1 && humanorrobot!=2 );
        	
        	
        	if (humanorrobot==1) {
        		 System.out.println("what is his name ?");
        		 this.playersnames = reader.nextLine();
                 this.turn.addHumain(this.playersnames);
            } else {   
            	int easyormedium;
        	    do {
        	    	System.out.println("What difficulty  do you want it ?");
        	    	System.out.println("1-Easy      2-Medium");
        	    	easyormedium = reader.nextInt();
        	    } while(easyormedium !=1 && easyormedium!=2 );// Read the difficulty 
        	    if	(easyormedium==2) {this.turn.addMediumRobot();}else {this.turn.addEasyRobot();}//add the right robot
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
    	
    	int totalCardsToDistribute = 7* numberofplayers;
    	  for (int i = 0; i < totalCardsToDistribute; i++) {
            tracker.distribution(this.deck,this.discardPile);
    		next();			    		    		    		
    	} 
    }
    
    // Main method to execute the game setup and display the player list.
    public static void main(String[] args) {
    	
    	// Initialization of variables.
        Scanner reader = new Scanner(System.in); // Create the Scanner here
        Game game = new Game();
        game.deck=new Pile("Deck");
        game.discardPile  = new Pile("Discard Pile");
        
        // Game setup :
        game.fillTurn(reader); // Populate the Turn linked list with players
        Game.tracker=game.turn.gethead();//give the head to the tracker 
        game.deck.shuffle();
        game.distribution();
        game.turn.display();
         
        // Game process :
        int playerRemaining=game.numberofplayers;
        int j=1;
        while (playerRemaining > 1 ) { // Condition to break the game
        	Game.tracker.playProcess(Game.tracker.next.getnext(gamedirection, tracker),game.discardPile,game.deck,game.firstPlayedCard,game.numberofplayers,reader); 
        	// Check if the current player has no cards left
        	if (Game.tracker.getnbrcards()== 0) {
        		playerRemaining--;
        		System.out.println("Player " + Game.tracker.getnames() + " is out of cards! "+j+" place");
        		j++;
            	// Remove the player from the game (implementation depends on your game structure)
        		Game.tracker.removeNode();
        	}
        	System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        	if ( Game.tracker.next.getnext(gamedirection, tracker) instanceof Human ) { // Only displays the current played card if the human is the next to play for better readability.
        		System.out.println(" Current Card in play :" + game.discardPile.getTopCard().displayCard());
        		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        	}
        	game.next();
        	}
     
        // Announce the loser.
        System.out.println("Player " + game.turn.next(gamedirection, tracker).getnames()+ " is the loser!");
        reader.close(); // Close the Scanner at the end        
    }
}
    
