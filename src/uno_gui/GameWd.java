package uno_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cardgame_fw.Components.ImageLabel;
import cardgame_fw.Components.MyButton;
import cardgame_fw.Components.MyFrame;
import cardgame_fw.Components.PlayerHand;

public final class GameWd extends MyFrame implements ActionListener {
	
	private MyButton exitGame;
	private MyButton options;
	private MyButton play;
	
	
	private GameWd(String Title, ImageIcon Icon, String BackgroundImagePath) {
		
		super(Title, Icon, BackgroundImagePath); // Calls the parent MyFrame constructor
		this.setMinimumSize(new Dimension(300,300)); 
		this.setLayout(null);
		
		// Instantiating custom Buttons.
		exitGame = new MyButton("Exit Game");
		options = new MyButton("Options");
		play = new MyButton("Play");
		
		// Adding Action Listeners to Buttons
		exitGame.addActionListener(this);
		play.addActionListener(this);
		options.addActionListener(this);
		
		ImageLabel playedCard = new ImageLabel("src\\Images\\Cards\\Returned.png"); // To Display the currently played card.
		PlayerHand hand = new PlayerHand(); // To display the currently playing player's hand.
		
		// --------------------- TESTING THE HAND WITH THESE, WILL BE DELETED---------------------
		ImageLabel card1 = new ImageLabel("src\\Images\\Cards\\Red\\1.png");
		ImageLabel card2 = new ImageLabel("src\\Images\\Cards\\Red\\3.png");
		ImageLabel card3 = new ImageLabel("src\\Images\\Cards\\Yellow\\Skip.png");
		ImageLabel card4 = new ImageLabel("src\\Images\\Cards\\Green\\Rev.png");
		
		
		hand.addCard(card1);
		hand.addCard(card2);
		hand.addCard(card3);
		hand.addCard(card4);
		hand.setBounds(500, 800, 800, 190);
		 // ---------------------------------------------------------------------------------------
		
		
		
		
		// Adding components to the menu.
		//this.add(playedCard);
		//this.add(exitGame);
		//this.add(options);
		//this.add(play);
		this.add(hand);
		
		this.setVisible(true);
		
	}
	
	private static GameWd instance = null; // This prevents the user from instantiating more than one Game Window.
	
	public static GameWd getInstance() {
		return instance;
	}

	public static void setInstance(GameWd instance) {
		GameWd.instance = instance;
	}
	
	public static GameWd instantiate(String Title, ImageIcon Icon, String BackgroundImagePath) { // This here is to get only one instance of GameWd
		if (instance == null) {
			instance = new GameWd(Title,Icon,BackgroundImagePath);
		}
		return instance;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == options) {
			// Opens a window to choose between 4 background colors (Red/Blue/Yellow/Green)
			// When the background is chosen, even the buttons should change colors.
		}
		
		if (e.getSource() == play) {
			// Plays a selected card.
		}
		
		if (e.getSource() == exitGame) {
			// Opens a little window to choose between returning to MainMenu or exiting the whole game.
		}
		
	}

}
