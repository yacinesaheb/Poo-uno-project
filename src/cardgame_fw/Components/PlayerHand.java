package cardgame_fw.Components;

import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cardgame_fw.Layouts.InGame.HandLayout;

public class PlayerHand extends JPanel {
	
	private final List<ImageLabel> cards = new ArrayList<>(); // THIS WILL BE CHANGED WHEN IMPLEMENTING THE GAME LOGIC.
	
	public PlayerHand() {
		this.setLayout(new HandLayout());
		this.setOpaque(false);
		this.setVisible(true);
	}
	
	public void addCard(ImageLabel card) {
        cards.add(card);
        this.add(card);
        this.addCardAnimations(card);
        this.revalidate();
        this.repaint();
    }
	
	public void removeCard(ImageLabel card) {
        cards.remove(card);
        this.remove(card);
        this.revalidate();
        this.repaint();
    }
	
	private ImageLabel selectedCard = null;  // This here is to make only one selected card at a time.
	private ImageLabel hoveredCard = null;  // This here is to make only the card that the mouse is on to be hovered.
	
	private void elevateCard(ImageLabel card) { // This method will elevate a card (will be called when a card is selectioned)
		card.setLocation(card.getLocation().x, card.getLocation().y - 20); // Elevates the card by 20px .
		card.setHoverBorder(false); // Resets the transparency of the card after selecting it.
		card.repaint();
	} 
	
	private void resetCard(ImageLabel card) { // This method will reput down a selected card (will be called when another card is selectioned or when clicking again on this card)
		card.setLocation(card.getLocation().x, card.getLocation().y + 20); // Puts down the card by 20px .
		card.setHoverBorder(false); // Resets the transparency of the card after unselecting it.
		card.repaint();
	}
	
	private void addCardAnimations(ImageLabel card) { // This method will add all the animations to a card when it's created (Hover / Up)
		
		card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // When mouse is passed on a card, we get the Hand Cursor to indicate it's clickable.
		
		card.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) { // When mouse entered the space of the card.
				if (hoveredCard != null && hoveredCard != card && hoveredCard != selectedCard) { // If there is no hovered card (including this one) and the card is not selected.
					hoveredCard.setHoverBorder(false); // Resets transparency.
			        hoveredCard.repaint();
			    }
				if (card != selectedCard) { // If the card is not the already selected card.
					hoveredCard = card;
					card.setHoverBorder(true);
					card.repaint();
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) { // Basically just resets transparency to normal.
				if (card != selectedCard) {
					card.setHoverBorder(false);
			        card.repaint();
			    }
				
				if (hoveredCard == card) { // If this card is the one hovered
			        hoveredCard = null; // There is no more hovered card.
			        card.repaint();
			    }
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (selectedCard != null && selectedCard != card) { // If there is an already selected card besides this one.
					resetCard(selectedCard); // Puts the card down.
				}
				if (card == selectedCard) { // If this card is already the selected card
				    resetCard(card); // Puts the card down.
				    selectedCard = null; // There is no more selected card.
				}
				else { // There is no previous selected card (neither this nor any other one)
				    elevateCard(card); // Puts the card up.
				    selectedCard = card; // This card is now the selected card.
				}
			}
		});
		
	}

}
