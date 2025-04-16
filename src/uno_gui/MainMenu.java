package uno_gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;

import cardgame_fw.Components.ImageLabel;
import cardgame_fw.Components.MyButton;
import cardgame_fw.Components.MyFrame;
import cardgame_fw.Layouts.Mainmenu.MMLbase;
import cardgame_fw.Layouts.Mainmenu.MMLnarrow;
import cardgame_fw.Layouts.Mainmenu.MMLshort;

public final class MainMenu extends MyFrame implements ActionListener {
	
	private static ImageIcon logoUno = new ImageIcon("src\\Images\\Extra\\uno.png");
	private MyButton newGame;
	private MyButton loadGame;
	private MyButton options;
	private MyButton exit;
	
	public MainMenu(String Title, ImageIcon Icon, String BackgroundImagePath) {
		
		super(Title, Icon, BackgroundImagePath); // Calls MyFrame constructor.
		this.setMinimumSize(new Dimension(300,300));
		this.setSize(1920,1080);
		this.setLocationRelativeTo(null);
		
		newGame = new MyButton("New Game"); // Creating a custom "New Game" Button.
		loadGame = new MyButton("Load Game"); // Creating a custom "Load Game" Button.
		options = new MyButton("Options"); // Creating a custom "Options" Button.
		exit = new MyButton("Exit"); // Creating a custom "Exit" Button.
		ImageLabel unologo = new ImageLabel(logoUno); // Creating a new ImageLabel with the UNO Logo.
		
		// Adding the components
		this.add(unologo);
		this.add(newGame);
		this.add(loadGame);
		this.add(options);
		this.add(exit);
		
		// Adjusting the layout the first time to display components correctly.
		this.adjustLayout();
		
		// Adjusting the layout whenever the size of the menu changes.
		this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                adjustLayout();
            }
        });
		
		
		// Configuration of Exit Button
		exit.addActionListener(this);
		
		this.setVisible(true); // Sets the Menu to visible in the end to avoid painting problems.
	}
	
	@Override
	public void adjustLayout() { // This method is called to adjust the layout of the main menu depending on the size of the window.
		if (this.getWidth() > this.getHeight() * 2.7){ // Width is 2.2 times bigger than Height
			this.setLayout(new MMLnarrow());
		} else if (this.getHeight() > this.getWidth() * 1.5) { // Height is 2.7 times bigger than Width
			this.setLayout(new MMLshort());
		} else { // Any other window size.
			this.setLayout(new MMLbase());
		}
		this.revalidate(); // This is here because we had a problem with the Windowed full screen button that made the layout not update.
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) { // When clicking on the exit button.
			this.dispose(); // Close the window.
		}
		
		if (e.getSource() == options) {
			// Opens a window to choose between 4 background colors (Red/Blue/Yellow/Green)
			// When the background is chosen, even the buttons should change colors.
		}
		
		if (e.getSource() == newGame) {
			// Opens the game config window. 
		}
		
		if (e.getSource() == loadGame) {
			// Opens the list of the previous left and saves games.
		}
		
	}

	
	public static void main(String[] args) {
		
		ImageIcon unoicon = new ImageIcon("src\\Images\\Extra\\Logo_Uno.png");
				
		MainMenu mainmenu = new MainMenu("Main Menu",unoicon,"src\\Images\\Extra\\DarkRed Background.jpg"); // Creates the main menu.
	}

}
