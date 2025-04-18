import javax.swing.ImageIcon;

import uno_gui.GameWd;
import uno_gui.MainMenu;
import uno_gui.Options;
import uno_gui.Options.DisplayColor;

public class UnoGame {

public static void main(String[] args) {
		
		ImageIcon unoicon = new ImageIcon("src\\Images\\Extra\\Logo_Uno.png");
				
		MainMenu.instantiate("UNO - Main Menu",unoicon,"src\\Images\\Bg\\Dark Red.jpg"); // Creates the main menu.
	}

}
