package poo_uno;

	// A class representing a circular doubly linked list of nodes. Each node can store either a human or a robot player.
	public class Turn {
		
		// Attributes
		private Node head; // The head of the circular doubly linked list

		// Getters
		public Node gethead() {
			return this.head;
		}
    
		public String getnames() {
				return this.head.getnames();
		}
   
		//Initializes an empty circular doubly linked list.
		public Turn() {
			this.head = null;
		}

    // Methods
		
     //@param playerName The name of the human player to add.
    public void addHumain(String playerName) {  // Adds a new human player to the list.
        Node newNode = new Node();
        newNode.addHuman(playerName); // Initialize the node with the human player
        if (head == null) {
            // If the list is empty
            head = newNode;
            head.next = head; // Circular link
            head.prev = head;
        } else {
            // Add the new node at the end of the list
            Node tail = head.prev;
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    
     // Adds a new robot player to the list.
    int i =1;
    public void addMediumRobot() {
        Node newNode = new Node();
        newNode.addMediumRobot(i); // Initialize the node with the medium robot player
        if (head == null) {
            // If the list is empty
            head = newNode;
            head.next = head; // Circular link
            head.prev = head;
        } else {
            // Add the new node at the end of the list
            Node tail = head.prev;
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
        }
        i++;
    }
    int i2=1;
    public void addEasyRobot() {
        Node newNode = new Node();
        newNode.addEasyRobot(i2); // Initialize the node with the medium robot player
        if (head == null) {
            // If the list is empty
            head = newNode;
            head.next = head; // Circular link
            head.prev = head;
        } else {
            // Add the new node at the end of the list
            Node tail = head.prev;
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
        }
        i2++;
    }
    
    //next method
    public Node next(boolean gamedirection, Node tracker) {
        if (gamedirection) {
            return tracker.next;
        } else {
            return tracker.prev;
        }
    }
	
    public void display() { //Prints the name of each player in the list.
        if (head == null) {
            System.out.println("Liste vide!"); 
            return;
        }
        Node temp = head;
        do {
           temp.displayplayers(); // Displays information about the current node
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }   
   
    public void clear() { // Clears the list and releases all memory.
        if (head == null) return; // If the list is already empty, do nothing
        Node current = head;
        do {
            Node nextNode = current.next;
            current.prev = null; // Break the previous link
            current.next = null; // Break the next link
            current = nextNode; // Move to the next node
        } while (current != head);
        head = null; // Set the head to `null` to signify the list is empty
    }	
}
