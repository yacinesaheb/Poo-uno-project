package poo_uno;

 //Represents a node in a doubly linked list.Each node can store either a human player or a robot player.
public class Node {

    // Attributes
    private Human human; // Stores a Human player (null if this node represents a Robot)
    private Robot robot; // Stores a Robot player (null if this node represents a Human)

    Node next; // Pointer to the next node in the list
    Node prev; // Pointer to the previous node in the list

    // Methods

    // Initializes the node for a human player.playerName The name of the human player to be added.
    public void addHuman(String playerName) {
        this.human = new Human(); // Create a new Human object
        this.human.setName(playerName); // Assign the player's name
        this.next = null; // Initialize pointers to null
        this.prev = null;
    }

    // Initializes the node for a robot player. (You can expand the Robot class to include more attributes if needed.)
    public void addRobot() {
        this.robot = new Robot(); // Create a new Robot object
        this.next = null; // Initialize pointers to null
        this.prev = null;
    }

    //Displays information about the node.If the node represents a human player, it displays the player's name.Otherwise, it indicates that the node represents a robot.
    public void displayplayers() {
        if (human != null) {
            // Display the human player's name
            System.out.println("PLAYER NAME: " + human.getName());
        } else if (robot != null) {
            // Indicate that this node represents a robot
            System.out.println("ROBOT");
        } else {
            // Indicate that the node is uninitialized
            System.out.println("NODE IS UNINITIALIZED");
        }
    }
}
