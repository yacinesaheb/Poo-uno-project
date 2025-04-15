package uno_gui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import cardgame_fw.Components.ImageLabel;
import cardgame_fw.Components.MyButton;
import cardgame_fw.Components.MyFrame;
import cardgame_fw.Layouts.MainMenuLayout;

public class MainMenu {
	
	private static ImageIcon unoicon = new ImageIcon (new ImageIcon("src\\Images\\Extra\\Logo_Uno.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
	//private static ImageIcon logoUno = new ImageIcon("src\\Images\\Extra\\uno.png");
	private static ImageIcon logoUno = new ImageIcon (new ImageIcon("src\\Images\\Extra\\uno.png").getImage().getScaledInstance(250, 250, Image.SCALE_AREA_AVERAGING));

	public static void main(String[] args) {
		
		
		
		// Main Menu
		MyFrame mainmenu = new MyFrame("Main Menu",unoicon,"src\\Images\\Extra\\DarkRed Background.jpg");
		MyButton newGame = new MyButton("New Game");
		MyButton loadGame = new MyButton("Load Game");
		MyButton options = new MyButton("Options");
		MyButton exit = new MyButton("Exit");
		ImageLabel unologo = new ImageLabel(logoUno);
		mainmenu.setLayout(new MainMenuLayout());
		mainmenu.add(unologo);
		mainmenu.add(newGame);
		mainmenu.add(loadGame);
		mainmenu.add(options);
		mainmenu.add(exit);
		
		mainmenu.setVisible(true);

	}

}
