 package poo_uno;

public class Turn {
	///////////// Classe pour la liste doublement chaînée circulaire
	
	    private Node head; // Tête de la liste

	    public void turn() {
	        this.head = null;
	    }

	    ////////////////// Ajouter un nœud à la fin de la liste
	    public void addNode(String playername,Deck deck) {
	        Node newNode = new Node( playername, deck);
	        if (head == null) {
	            // Si la liste est vide
	            head = newNode;
	            head.next = head;
	            head.prev = head;
	        } else {
	            // Ajouter à la fin
	            Node tail = head.prev;
	            tail.next = newNode;
	            newNode.prev = tail;
	            newNode.next = head;
	            head.prev = newNode;
	        }
	    }

	    /////////////////// Afficher la liste
	    public void display() {
	        if (head == null) {
	            System.out.println("Liste vide!");
	            return;
	        }
	        Node temp = head;
	        do {
	            temp.display();
	            temp = temp.next;
	        } while (temp != head);
	        System.out.println();
	    }
	    
	    
	    //////////////////// Méthode pour inverser la direction de la liste
	    public void reverse() {
	        if (head == null) return;

	        Node current = head;
	        Node temp = null;

	        do {
	            // Échange des pointeurs `next` et `prev`
	            temp = current.next;
	            current.next = current.prev;
	            current.prev = temp;

	            // Avancer au nœud suivant dans la liste originale
	            current = temp;
	        } while (current != head);

	        // Mise à jour de la tête pour refléter la nouvelle direction
	        head = head.prev;
	    }

	    ////////////////////// Supprimer tous les nœuds pour libérer la mémoire
	    public void clear() {
	        if (head == null) return;
	        Node current = head;
	        do {
	            Node nextNode = current.next;
	            current.prev = null;
	            current.next = null;
	            current = nextNode;
	        } while (current != head);
	        head = null;
	    }
}
