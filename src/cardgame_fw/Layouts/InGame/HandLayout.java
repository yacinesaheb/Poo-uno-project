package cardgame_fw.Layouts.InGame;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import cardgame_fw.Components.ImageLabel;
import cardgame_fw.Components.MyButton;

public class HandLayout implements LayoutManager {

	@Override
	public void addLayoutComponent(String name, Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		return new Dimension(800, 150);
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		return new Dimension(300, 150);
		
	}

	@Override
	public void layoutContainer(Container parent) {
		
		int spacing = -40; // Spacing between cards (set to negative value so the cards are on top of eachother)
		int topSpace = 20; // When a card is selected, is goes up of 20px, so we should leave space for it to go up in the Panel.
		
		int nbr = parent.getComponentCount(); // How Many Cards are in the Hand Panel.
		
        int cardWidth = (parent.getWidth() - (nbr - 1) * spacing) / nbr; // Calculate each card width directly from the container's width and the total spacing.
        int cardHeight = (int)(cardWidth * 1.5); // Direct calculation of the card height from it's width.

        // Assuring that cards do not go off the Hand Panel.
        if (cardHeight > parent.getHeight() - topSpace) { 
        	cardHeight = parent.getHeight() - topSpace; 
            cardWidth = (int)(parent.getHeight() / 1.5); // Recalculate the width in consequence.
        }
        
        // Displaying cards
        int X = 0;
        for (Component img : parent.getComponents()) {
        	img.setBounds(X, topSpace, cardWidth, cardHeight);
            X += cardWidth + spacing;
        }
		
	}

}
