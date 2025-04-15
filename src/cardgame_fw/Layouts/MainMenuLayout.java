package cardgame_fw.Layouts;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import cardgame_fw.Components.ImageLabel;
import cardgame_fw.Components.MyButton;

public class MainMenuLayout implements LayoutManager {
	
	private ImageLabel logo;

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

	@Override
	public void layoutContainer(Container parent) {

		int width = parent.getWidth(); // Gets the parent's width.
		int height = parent.getHeight(); // Gets the parent's height.
		Insets insets = parent.getInsets(); // Gets the parent's insets (top/bottom/left/right)
		
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
		
		// Logo placement : Center Left of the parent component.
		int logowidth = (width / 2) - 50; // Sets the width of the logo to fit its supposed position.
        int logoheight = (height / 2); // Sets the height of the logo to fit its supposed position.
        Dimension logoSize = logo.getPreferredSize();
        int logoX = insets.left + 50; // This here basically leaves an equivalent space of 50 pixels from the left.
        int logoY = (height - logoSize.height) / 2;
        logo.setBounds(logoX, logoY, logowidth, logoheight);
        
        // Button placement : Center right of the parent component , one on top of each other, all facing the logo.
        int buttonX = width - 250;
        int buttonwidth = 180;
        int buttonheight = 50;
        int totalHeight = buttons.size() * buttonheight + (buttons.size() - 1) * 20;
        int buttonY = (height - totalHeight) / 2;

        for (Component btn : buttons) {
            btn.setBounds(buttonX, buttonY, buttonwidth, buttonheight);
            buttonY += buttonheight + 20;
        }
		
	}

}
