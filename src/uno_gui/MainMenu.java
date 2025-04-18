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
import uno_gui.Options.DisplayColor;

public final class MainMenu extends MyFrame implements ActionListener {
	
	private MyButton newGame;
	private MyButton loadGame;
	private MyButton options;
	private MyButton exit;
	
	private MainMenu(String Title, ImageIcon Icon, String BackgroundImagePath) {
		
		super(Title, Icon, BackgroundImagePath); // Calls MyFrame constructor.
		this.setMinimumSize(new Dimension(300,300)); // Sets minimum size of the window because otherwise components are just not displayed.
		
		// Instantiating the Buttons from MyButton.
		newGame = new MyButton("New Game"); 
		loadGame = new MyButton("Load Game"); 
		options = new MyButton("Options"); 
		exit = new MyButton("Exit"); 
		
		// Adding Action Listeners to Buttons
		newGame.addActionListener(this);
		loadGame.addActionListener(this);
		options.addActionListener(this);
		exit.addActionListener(this);
		
		ImageLabel unologo = new ImageLabel("src\\Images\\Extra\\uno.png"); // Creating a new ImageLabel with the UNO Logo.
		
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
		
		
		this.setVisible(true); // Sets the Menu to visible in the end to avoid painting problems.
	}
	
	private static MainMenu instance = null; // This prevents the user from instantiating more than one MainMenu. 
	
	public static MainMenu getInstance() {
		return instance;
	}


	public static void setInstance(MainMenu instance) {
		MainMenu.instance = instance;
	}
	
	public static MainMenu instantiate(String Title, ImageIcon Icon, String BackgroundImagePath) { // This here is to get only one instance of mainmenu
		if (instance == null) {
			instance = new MainMenu(Title,Icon,BackgroundImagePath);
		}
		return instance;
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
			this.dispose(); // Dispose of the mainmenu window
			
			if (Options.getInstance() != null) {
			Options.getInstance().dispose(); // Dispose of the option window.
			}
			
			if (GameWd.getInstance() != null) {
			GameWd.getInstance().dispose(); // Dispose of the InGame window.
			}
		}
		
		if (e.getSource() == options) {
			if (Options.getInstance() == null) { // If it is the first time we open the Options menu
				ImageIcon unoicon = new ImageIcon("src\\Images\\Extra\\Logo_Uno.png"); 
				Options.instantiate("UNO - Options", unoicon,null); // Instantiate the menu
			} else {
				Options.getInstance().setVisible(true); // Just sets the window to visible again (when confirm/exit on options menu it becomes non-visible)
			}
		}
		
		if (e.getSource() == newGame) { // THIS IS TEMPORARY TO WORK ON THE GAME MENU,OTHERWISE THERE WILL BE A GAME CONFIG MENU BEFORE
			if (GameWd.getInstance() == null) { // If it is the first time we open the Game menu
				ImageIcon unoicon = new ImageIcon("src\\Images\\Extra\\Logo_Uno.png"); 
				GameWd.instantiate("UNO - In Game", unoicon,"src\\Images\\Bg\\" + DisplayColor.getColorName() + ".jpg"); // Instantiate the menu
			} else {
				GameWd.getInstance().setVisible(true); // Just sets the window to visible again (when confirm/exit on options menu it becomes non-visible)
			} 
		}
		
		if (e.getSource() == loadGame) {
			// Opens the list of the previous left and saves games.
		}
		
	}

}
