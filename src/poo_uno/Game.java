package poo_uno;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    //les attribues:
	private int currentplayer;
	private String[] playersnames= new String[4];
	private Deck deck;
	private ArrayList<Player> players ;
	private boolean gamedirection;
	
	
    //les methode:
	//methode pour avoir les noms des joueurs:
	 public void collectPlayerNames() {
	        Scanner reader = new Scanner(System.in);

	        for (int i = 0; i < playersnames.length; i++) {
	            System.out.println("Give me the name of player " + (i + 1) + ":");
	            playersnames[i] = reader.nextLine(); // Store the name in the array
	        }

	        reader.close();

	   
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
	
	
	
	
	
	
	
	
	
}
