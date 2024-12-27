package poo_uno;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	
	// Attributs
    private ArrayList<Card> cards;      // Liste des cartes dans le deck
    private int numberOfCards;          // Nombre actuel de cartes dans le deck
	
	
    // constructor; when no argument is passed, initialize a whole deck with 108 cards
    public Deck () {   //Ce constructeur initialise un deck complet de 108 cartes UNO.
        numberOfCards = 108;
        cards = new ArrayList<Card>(numberOfCards);

        String[] colors = { "RED", "BLUE", "GREEN", "YELLOW"}; //Il définit les couleurs disponibles 
        String[] numbers = { "ZERO", "ONE", "TWO", "THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"};
        // iterate through all the colors
        for (int i=0; i<4; i++) {

            // each color only has one "0"
            cards.add(i*25, new RegularCard(colors[i], "ZERO" )); //Ajout de la carte "0"

            for (int j=1; j<19; j+=2) { // Ajout des cartes numérotées (1 à 9)
                cards.add(i*25+j , new RegularCard(colors[i], numbers[j/2]) ) ;
                cards.add(i*25+j+1 , new RegularCard(colors[i], numbers[j/2]) );
            }
            // each color has some action cards
            //Ajout des cartes d'action
            cards.add( 19+i*25, new DrawTwoCard(colors[i]) );
            cards.add( 20+i*25, new DrawTwoCard(colors[i]) );
            cards.add( 21+i*25, new ReverseCard (colors[i]) );
            cards.add( 22+i*25, new ReverseCard (colors[i]) );
            cards.add( 23+i*25, new SkipCard (colors[i]) );
            cards.add( 24+i*25, new SkipCard (colors[i]) );
        }

        // wild cards don't have a set color
        //Ajout des cartes spéciales
        for (int i=100; i<104; i++) {  //Cartes Wild (Joker)
            cards.add( i, new WildCard () );
        }
        for (int i=104; i<108; i++) {  //Cartes Wild Draw 4
            cards.add( i, new WildDrawFour () );
        }
    }

	
	