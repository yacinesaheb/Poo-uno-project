package poo_uno;

import java.util.Scanner;

public class Game {
<<<<<<< Updated upstream
	
    // Initialization of attributes of the class.
	private int currentplayer;
	private String[] playersnames= new String[4];
	private Deck deck;
	private ArrayList<Player> players ;
	private boolean gamedirection;
	private Card discardPileTopCard;
	
	// Getters and setters of some attributes.
	public Card getDiscardPileTopCard() { // discardPileTopCard's getter
		return discardPileTopCard;
	}

	public void setDiscardPileTopCard(Card discardPileTopCard) { // discardPileTopCard's setter
		this.discardPileTopCard = discardPileTopCard;
	}
	
    // Methods of the class Game
	
	 public void collectPlayerNames() {
	        Scanner reader = new Scanner(System.in);
=======
    // Attributes
    private int currentplayer; // Tracks the current player
    private Deck deck; // Represents the deck of cards (implement Deck separately)
    private boolean gamedirection; // Tracks the game direction (true for clockwise, false for counterclockwise)
    private Turn turn = new Turn(); // Linked list to manage players
>>>>>>> Stashed changes

    // Attributes for players
    private int numberofplayers; // Total number of players
    private String[] playersnames; // Array to store player names

    /**
     * Asks the user how many players will participate in the game.
     * Initializes the playersnames array based on the input.
     * 
     * @param reader Scanner object for reading user input
     */
    public void howmanyplayers(Scanner reader) {
        System.out.println("How many players?");
        this.numberofplayers = reader.nextInt(); // Read the number of players
        reader.nextLine(); // Consume the newline character to avoid skipping input
        this.playersnames = new String[this.numberofplayers]; // Initialize the array
    }

<<<<<<< Updated upstream
	   
	        System.out.println("Players:");
	        for (String name : playersnames) {
	            System.out.println(name);}
	        }
	
	
	
	
	public static void main(String[] args) {
		
		Game game =new Game();
		game.collectPlayerNames();
		  for (int i = 0; i < 4; i++) {
		  }
		
		
		
	}

	
	
	
	
	
	
	
	
	
=======
    /**
     * Collects the names of all players.
     * 
     * @param reader Scanner object for reading user input
     */
    public void collectPlayerNames(Scanner reader) {
        for (int i = 0; i < this.playersnames.length; i++) {
            System.out.println("Give me the name of player " + (i + 1) + ":");
            this.playersnames[i] = reader.nextLine(); // Store each name in the array
        }
    }

    /**
     * Fills the Turn linked list with players.
     * Adds human players first, followed by any additional robots (if applicable).
     */
    public void fillTurn() {
        int i = 0;
        // Add human players to the turn
        while (i < this.numberofplayers) {
            this.turn.addHumain(this.playersnames[i]);
            i++;
        }

        // Add robots if fewer than 5 players (game-specific logic)
        while (i < 5) {
            this.turn.addRobot(); // Assuming addRobot is implemented in Turn
            i++;
        }
    }

    /**
     * Main method to execute the game setup and display the player list.
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in); // Create the Scanner here
        Game game = new Game();

        // Game setup
        game.howmanyplayers(reader); // Ask for the number of players
        game.collectPlayerNames(reader); // Collect player names
        game.fillTurn(); // Populate the Turn linked list with players

        // Display the players in turn order
        game.turn.display();

        reader.close(); // Close the Scanner at the end
    }
>>>>>>> Stashed changes
}
