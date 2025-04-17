import javax.swing.ImageIcon;

import uno_gui.GameWd;
import uno_gui.MainMenu;

public class UnoGame {

public static void main(String[] args) {
		
		ImageIcon unoicon = new ImageIcon("src\\Images\\Extra\\Logo_Uno.png");
				
		//MainMenu.getInstance("UNO - Main Menu",unoicon,"src\\Images\\Bg\\Dark Red.jpg"); // Creates the main menu.
		GameWd.getInstance("UNO - In Game",unoicon,"src\\Images\\Bg\\Dark Red.jpg");
		
	}

}
