package cardgame_fw.Layouts.Mainmenu;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import java.util.ArrayList;
import java.util.List;


import cardgame_fw.Components.ImageLabel;
import cardgame_fw.Components.MyButton;

public class MMLnarrow implements LayoutManager { // Layout for the MainMenu. Will be used for when the window is narrow and long.
	
	private ImageLabel logo;

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
		
		// ----------------------- Placing Logo ------------------------------
	    int logoSize = Math.min(parent.getHeight() / 2, parent.getWidth() / 2); // Taking an initial logo size (maximum value between width,height / 2 of parent container)
	    int logoX; // X coordinates of the logo.
	    int logoY; // Y coordinates of the logo.
	    int logoheight = logoSize; // Sets initial logo height.
	    int logowidth = logoSize; // Sets initial logo width.
	    logoX = parent.getInsets().left + parent.getWidth()/ 10; // X Coordinate of the logo adapts to the width of the parent component.
	    logoY = (parent.getHeight() - logoheight) / 2; // Y Coordinate of the logo adapts to the height of the parent component.   
	    logo.setBounds(logoX, logoY, logowidth, logoheight); // Displays the logo with the previous calculated coordinates and size.
	    
	    
	    // ---------- Placing buttons --------------
	    int buttonWidth = (int)(parent.getWidth() * 0.15); // Initial width of Button adapting to parent container.
	    int buttonHeight = (int)(parent.getHeight() * 0.10); // Initial height of Button adapting to parent container.
	    buttonWidth = Math.max(buttonWidth, 100); // Setting minimum width of the button.
	    buttonHeight = Math.max(buttonHeight, 50); // Setting minimum height of the button.
	    
	    int spacing = (int)(parent.getWidth() * 0.02); // Sets spacing between the buttons.
	    int totalWidth = buttons.size() * buttonWidth + (buttons.size() - 1) * spacing; // Calculates total space that the 4 buttons will take because we will need it.
	    int buttonX = parent.getWidth() - totalWidth - parent.getWidth() / 12; // X value of the first button to be displayed.
	    int buttonY = (parent.getHeight() - buttonHeight) / 2; // Y value for all the buttons.

	    int x = buttonX;
	    
	    // Displaying all buttons one on top of the other.
	    for (Component btn : buttons) { 
	        btn.setBounds(x, buttonY, buttonWidth, buttonHeight);
	        x += buttonWidth + spacing; // Spacing the buttons.
	    }
		
	}

	
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
