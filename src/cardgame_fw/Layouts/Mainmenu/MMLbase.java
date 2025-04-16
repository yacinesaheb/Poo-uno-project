package cardgame_fw.Layouts.Mainmenu;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import cardgame_fw.Components.ImageLabel;
import cardgame_fw.Components.MyButton;

public class MMLbase implements LayoutManager { // The basic MainMenu layout when the window is neither too narrow nor too short.

	
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
		
		// ------------------------------- Placing Logo ---------------------------------
		int logoSize = Math.min(parent.getHeight() / 2, parent.getWidth() / 2); // Taking an initial logo size (maximum value between width,height / 2 of parent container)
	    int logoX = (parent.getWidth() - logoSize) / 2; // Calculate X position directly as it adapts to the parent container.
        int logoY = parent.getHeight() / 10; // Calculate Y position directly as it adapts to the parent container.
        logo.setBounds(logoX, logoY, logoSize, logoSize); // Displays the logo with the previous calculated coordinates and size.
        
        // ------------------------------Placing Buttons --------------------------------
        int buttonWidth = (int)(parent.getWidth() * 0.18); // Initial width of Button adapting to parent container.
	    int buttonHeight = (int)(parent.getHeight() * 0.08); // Initial height of Button adapting to parent container.
	    buttonWidth = Math.max(buttonWidth, 120); // Setting minimum width of the button.
	    buttonHeight = Math.max(buttonHeight, 40); // Setting minimum height of the button.
	    
	    int spacing = (int)(parent.getHeight() * 0.03); // Sets spacing between the buttons.
	    int totalWidth = 2 * buttonWidth + spacing; // Calculates total space that the 4 buttons will take because we will need it. 
        int buttonX = (parent.getWidth() - totalWidth) / 2; // Initial X value.
        int buttonY = logoY + logoSize + spacing * 2; // Initial Y value.
        
        // Displaying all buttons in 2x2
        for (int i = 0; i < buttons.size(); i++) {
            int row = i / 2; // Getting the row value.
            int col = i % 2; // Getting the column value.
            
            int x = buttonX + col * (buttonWidth + spacing); // Calculating current button's X value with initial value and column value.
            int y = buttonY + row * (buttonHeight + spacing); // Calculating current button's Y value with initial value and column value.
            
            buttons.get(i).setBounds(x, y, buttonWidth, buttonHeight); // Displaying the current button.
        }
	}
	
	@Override
	public void addLayoutComponent(String name, Component comp) {	
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		if (comp == logo) {
			logo = null; // Removes the logo (that's just in case it doesn't really matter). 
		}
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		return null;
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		return null;
	}
}
