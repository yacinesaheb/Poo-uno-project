package cardgame_fw.Layouts.Mainmenu;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import cardgame_fw.Components.ImageLabel;
import cardgame_fw.Components.MyButton;

public class MMLshort implements LayoutManager { // Layout for the MainMenu. Will be used when the window is Large but short.

	private ImageLabel logo;

	@Override
	public void layoutContainer(Container parent) {
		
		Component[] comps = parent.getComponents(); // All of the parent's components (basically for the main menu, the logo and the 4 buttons)
		
		List<MyButton> buttons = new ArrayList<>(); // An array to stock the 4 buttons and separate them from the logo.
		
		// Searching for the buttons and the logo from the Components.
		for (Component comp : comps) {
			if (comp instanceof MyButton) { // If the component is a MyButton.
				buttons.add((MyButton) comp); // Adding the Component as a MyButton (casting)
			} else {
				logo = (ImageLabel) comp; // We have found the only component that is not a button, so it is the logo. We Cast is as ImageLabel.
			}
		}
		
		int spacing = 20;
		
		// ----------------------------------- Placing Logo ----------------------------------------
        int logoSize = Math.min(parent.getWidth() / 2, parent.getHeight() / 4); // Taking an initial logo size.
        int logoX = (parent.getWidth() - logoSize) / 2; // Calculate X position directly as it adapts to the parent container.
        int logoY = spacing * 2; // Calculate Y position directly with spacing.
        logo.setBounds(logoX, logoY, logoSize, logoSize); // Displays the logo with the previous calculated coordinates and size.
		
        // ---------------------------------- Placing Buttons -------------------------------------
        int buttonWidth = Math.min(parent.getWidth() - (spacing * 4), 250); // Calculating button's width adaption to the parent container.
        
        int availableHeight = parent.getHeight() - logoSize - (spacing * 4); // Gets the remaining height after adding the logo.
        int buttonCount = buttons.size(); // Returns the number of elements of buttons array.
        
        int buttonHeight = Math.min(availableHeight / buttonCount - spacing, 60); // Setting maximum height of the button.
        buttonHeight = Math.max(buttonHeight, 40); // Setting maximum height of the button.
        
        int buttonY = logoY + logoSize + (spacing * 2); // Initial Y value.
        
        for (Component btn : buttons) {
            int buttonX = (parent.getWidth() - buttonWidth) / 2; // Calculating X value.
            btn.setBounds(buttonX, buttonY, buttonWidth, buttonHeight); // Displaying the button.
            buttonY += buttonHeight + spacing; // Spacing the buttons.
        }
	}

	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}
}
