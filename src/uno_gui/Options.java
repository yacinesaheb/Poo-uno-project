package uno_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;


import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import cardgame_fw.Components.ImageLabel;
import cardgame_fw.Components.MyFrame;
import uno_gui.Options.DisplayColor;

public final class Options extends MyFrame { // This class is here to set some display options.
	
	private String tempcolor; // This will be used to choose the bg color.
	
	private Options(String Title, ImageIcon Icon, String BackgroundImagePath) {
		super(Title, Icon, BackgroundImagePath);
		this.setSize(500,500); // Sets the default size of the frame.
		this.setResizable(false);
		this.getContentPane().setBackground(Color.lightGray);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		// Panel that will display "Select Display Color" and the buttons under
		JPanel selectDisplay = new JPanel();
		selectDisplay.setLayout(new BoxLayout(selectDisplay, BoxLayout.Y_AXIS)); // Box Layout puts components one on top of the other (Y_AXIS)
		selectDisplay.setOpaque(false);
		selectDisplay.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0)); // To let some space on top 
		
		// The Usual Text Label to write text
		JLabel textPolice = new JLabel("Select Display Color :");
		textPolice.setAlignmentX(Component.CENTER_ALIGNMENT);
		textPolice.setFont(new Font("Arial", Font.BOLD, 18));
		textPolice.setForeground(Color.WHITE); 
		selectDisplay.add(textPolice); // Adds the label to the Panel
		selectDisplay.add(Box.createRigidArea(new Dimension(0, 20))); // Create space between the text and the buttons.

		// Instantiating Radio Buttons
		JRadioButton darkRedBtn = new JRadioButton("DarkRed");
		JRadioButton redBtn = new JRadioButton("Red");
		JRadioButton darkBlueBtn = new JRadioButton("DarkBlue");
		JRadioButton yellowBtn = new JRadioButton("Yellow");
		JRadioButton greenBtn = new JRadioButton("Green");

		// Creating the ButtonGroup that will hold the Buttons and add them to it.
		ButtonGroup colors = new ButtonGroup();
		colors.add(darkRedBtn);
		colors.add(redBtn);
		colors.add(darkBlueBtn);
		colors.add(yellowBtn);
		colors.add(greenBtn);

		JRadioButton[] buttons = {darkRedBtn, redBtn, darkBlueBtn, yellowBtn, greenBtn};
		for (JRadioButton b : buttons) { // Adding the buttons to the panel one on top of the other.
			b.setOpaque(false);
			b.setFocusable(false); // Remove the box around the text
			b.setAlignmentX(Component.CENTER_ALIGNMENT); // Centers the buttons in the Panel
			b.setForeground(Color.WHITE); // Color of the text besides the button.
			selectDisplay.add(b); // Adding the button itself to the panel.
			selectDisplay.add(Box.createRigidArea(new Dimension(0, 20))); // Adding space between the radio buttons (we did not find any other good way)
		}

		// Buttons to confirm or exit the options window
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Instanciate a Panel with flow layout that displays components from the right.
		bottomPanel.setOpaque(false);
		JButton confirm = new JButton("Confirm");
		confirm.setFocusable(false);
		JButton exit = new JButton("Exit");
		exit.setFocusable(false);
		bottomPanel.add(confirm);
		bottomPanel.add(exit);
		
		// ---------------------------- Adding action listeners ---------------------------------
		
		// Exit Button
		exit.addActionListener(e -> this.setVisible(false)); // Exits the window (this is a shortcut to directly associate a little action to a button)
		
		// Color choosing buttons
		darkRedBtn.addActionListener(e -> this.tempcolor = "Dark Red");
		redBtn.addActionListener(e -> this.tempcolor = "Red");
		darkBlueBtn.addActionListener(e -> this.tempcolor = "Dark Blue");
		yellowBtn.addActionListener(e -> this.tempcolor = "Yellow");
		greenBtn.addActionListener(e -> this.tempcolor = "Green");
		
		// Confirm Button
		confirm.addActionListener(e -> {
			if (tempcolor != null) { // To not confirm before selecting any button.
		    DisplayColor.setColorName(tempcolor);
		    ImageLabel.changeBorderColor(DisplayColor.color);
		    
		    MainMenu.getInstance().repaintBg("src\\Images\\Bg\\" + DisplayColor.getColorName() + ".jpg"); // Repaints the background.
		    
		    if (GameWd.getInstance() != null) { // Repaints the background.
		    GameWd.getInstance().repaintBg("src\\Images\\Bg\\" + DisplayColor.getColorName() + ".jpg");
		    }
		    
		    this.setVisible(false);
			}
		});
			
		this.add(selectDisplay, BorderLayout.CENTER); // Displays the Panel in the center of the window
		this.add(bottomPanel, BorderLayout.SOUTH); // Displays the Panel in the bottom of the window
		this.setVisible(true);
	}
	
	
	private static Options instance = null;
	
	public static Options getInstance() {
		return instance;
	}

	public static void setInstance(Options instance) {
		Options.instance = instance;
	}
	
	public static Options instantiate(String Title, ImageIcon Icon, String BackgroundImagePath) { // This here is to get only one instance of options
		if (instance == null) {
			instance = new Options(Title,Icon,BackgroundImagePath);
		}
		return instance;
	}
	
	public final class DisplayColor { // The First Setting is the display Color. It will change background image and card's hover color.
		
		private static Color color = new Color(0xe65050); // Color Value for the hover effect. (set to red by default)
		private static String colorName = "Dark Red"; // Color Name for the background or anything else that could be added. (set to dark red by default)
		
		public static Color getColor() {
			return color;
		}
		public static void setColor(Color color) {
			DisplayColor.color = color;
		}
		public static String getColorName() {
			return colorName;
		}
		public static void setColorName(String colorName) {
			DisplayColor.colorName = colorName;
			
			if (DisplayColor.colorName == "Dark Red" || DisplayColor.colorName == "Red" ) {
				DisplayColor.setColor(new Color(0xe65050)); // Light Red Hover.
			} else if (DisplayColor.colorName == "Dark Blue") {
				DisplayColor.setColor(new Color(0x5eb2eb)); // Light Blue Hover.
			} else if (DisplayColor.colorName == "Yellow") {
				DisplayColor.setColor(new Color(0xf7f179)); // Yellow Hover.
			} else if (DisplayColor.colorName == "Green") {
				DisplayColor.setColor(new Color(0x6cd471)); // Green Hover.
			}
		} 
		
	}
	
}
