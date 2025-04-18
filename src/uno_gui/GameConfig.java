package uno_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;


import cardgame_fw.Layouts.gameconfig.GameConfigLayout;
import cardgame_fw.Components.MyTextField;
import cardgame_fw.Components.MySpinner;
import cardgame_fw.Components.MySpinnerNumberModel;
import cardgame_fw.Components.MyRadioButton;
import cardgame_fw.Components.MyCheckBox;
import cardgame_fw.Components.MyButton;
import cardgame_fw.Components.MyFrame;
import cardgame_fw.Components.MyLabel;

import java.util.ArrayList;
import java.util.List;
public class GameConfig extends MyFrame implements ActionListener {
    
    // Maximum number of players
    private static final int MAX_PLAYERS = 4;
    
    // Components for game configuration
    private MyLabel titleLabel;
    private MyTextField gameNameField;
    
    // Arrays to hold player components
    private MyTextField[] playerNameFields;
    private ButtonGroup[] playerTypeGroups;
    private MyRadioButton[] humanButtons;
    private MyRadioButton[] robotButtons;
    private ButtonGroup[] difficultyGroups;
    private MyRadioButton[] easyButtons;
    private MyRadioButton[] mediumButtons;
    private MyRadioButton[] hardButtons;
    private MyLabel[] playerLabels;
    private MyCheckBox[] playerActiveCheckboxes;
    
    // Number of cards spinner
    private MyLabel cardsLabel;
    private MySpinner cardsSpinner;
    
    // Control buttons
    private MyButton confirmButton;
    private MyButton cancelButton;
    
    public GameConfig(String title, ImageIcon icon, String backgroundImagePath) {
        super(title, icon, backgroundImagePath);
        
        // Initialize components
        initComponents();
        
        // Set  frame properties
    
        this.setMinimumSize(new Dimension(650,985));
        this.setSize(1920,1080);
        this.setLocationRelativeTo(null);
        
        // Add component resize listener
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                adjustLayout();
            }
        });
        
        this.setVisible(true);
     
    }
    
    
    private void initComponents() {
        //  define our layout
    	
        this.setLayout(new GameConfigLayout());
        
        //  create title and space for game name 
        titleLabel = new MyLabel("Game Configuration");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(titleLabel.getFont().deriveFont(24.0f));
        titleLabel.setName("titleLabel");
        
        gameNameField = new MyTextField("New Game");
        gameNameField.setName("gameNameField");
        
        //  initialize tables for players components
        playerNameFields = new MyTextField[MAX_PLAYERS];
        playerTypeGroups = new ButtonGroup[MAX_PLAYERS];
        humanButtons = new MyRadioButton[MAX_PLAYERS];
        robotButtons = new MyRadioButton[MAX_PLAYERS];
        difficultyGroups = new ButtonGroup[MAX_PLAYERS];
        easyButtons = new MyRadioButton[MAX_PLAYERS];
        mediumButtons = new MyRadioButton[MAX_PLAYERS];
        hardButtons = new MyRadioButton[MAX_PLAYERS];
        playerLabels = new MyLabel[MAX_PLAYERS];
        playerActiveCheckboxes = new MyCheckBox[MAX_PLAYERS];
        
        //  create components for each player
        for (int i = 0; i < MAX_PLAYERS; i++) {
            playerLabels[i] = new MyLabel("Player " + (i + 1));
            playerLabels[i].setForeground(Color.WHITE);
            playerLabels[i].setName("playerLabel_" + i);
            
            playerNameFields[i] = new MyTextField("Player " + (i + 1));
            playerNameFields[i].setName("playerNameField_" + i);
            
            playerTypeGroups[i] = new ButtonGroup();
            humanButtons[i] = new MyRadioButton("Human");
            humanButtons[i].setForeground(Color.WHITE);
            humanButtons[i].setOpaque(false);
            humanButtons[i].setName("human_" + i);
            
            robotButtons[i] = new MyRadioButton("Robot");
            robotButtons[i].setForeground(Color.WHITE);
            robotButtons[i].setOpaque(false);
            robotButtons[i].setName("robot_" + i);
            
            playerTypeGroups[i].add(humanButtons[i]);
            playerTypeGroups[i].add(robotButtons[i]);
            
            // define default selection
            if (i == 0) {
                humanButtons[i].setSelected(true);
            } else {
                robotButtons[i].setSelected(true);
            }
            
            difficultyGroups[i] = new ButtonGroup();
            easyButtons[i] = new MyRadioButton("Easy");
            easyButtons[i].setForeground(Color.WHITE);
            easyButtons[i].setOpaque(false);
            easyButtons[i].setName("easy_" + i);
            
            mediumButtons[i] = new MyRadioButton("Medium");
            mediumButtons[i].setForeground(Color.WHITE);
            mediumButtons[i].setOpaque(false);
            mediumButtons[i].setName("medium_" + i);
            
            hardButtons[i] = new MyRadioButton("Hard");
            hardButtons[i].setForeground(Color.WHITE);
            hardButtons[i].setOpaque(false);
            hardButtons[i].setName("hard_" + i);
            
            difficultyGroups[i].add(easyButtons[i]);
            difficultyGroups[i].add(mediumButtons[i]);
            difficultyGroups[i].add(hardButtons[i]);
            
            // define default difficulty
            mediumButtons[i].setSelected(true);
            
            //  apply difficulty only for robots players
            easyButtons[i].setEnabled(i != 0);
            mediumButtons[i].setEnabled(i != 0);
            hardButtons[i].setEnabled(i != 0);
            
            playerActiveCheckboxes[i] = new MyCheckBox("Active");
            playerActiveCheckboxes[i].setForeground(Color.WHITE);
            playerActiveCheckboxes[i].setOpaque(false);
            playerActiveCheckboxes[i].setSelected(i < 2); // at least 2 player
            playerActiveCheckboxes[i].setName("playerActiveCheckbox_" + i);
            
            //  the two first players must be active
            if (i < 2) {
                playerActiveCheckboxes[i].setEnabled(false); 
            }
            //  add listeners to activate and dis'activate difficulty
            final int playerIndex = i;
            humanButtons[i].addActionListener(e -> {
                easyButtons[playerIndex].setEnabled(false);
                mediumButtons[playerIndex].setEnabled(false);
                hardButtons[playerIndex].setEnabled(false);
            });
            
            robotButtons[i].addActionListener(e -> {
                easyButtons[playerIndex].setEnabled(true);
                mediumButtons[playerIndex].setEnabled(true);
                hardButtons[playerIndex].setEnabled(true);
            });
            
            // add components to the frame
            this.add(playerLabels[i]);
            this.add(playerNameFields[i]);
            this.add(humanButtons[i]);
            this.add(robotButtons[i]);
            this.add(easyButtons[i]);
            this.add(mediumButtons[i]);
            this.add(hardButtons[i]);
            this.add(playerActiveCheckboxes[i]);
        }
        
        // create components to cards 
        cardsLabel = new MyLabel("Initial Cards:");
        cardsLabel.setForeground(Color.WHITE);
        cardsLabel.setName("cardsLabel");
        
        cardsSpinner = new MySpinner(new MySpinnerNumberModel(7, 5, 15, 1));
        cardsSpinner.setName("cardsSpinner");
        
        // create control buttons
        confirmButton = new MyButton("Confirm");
        confirmButton.setName("confirmButton");
        
        cancelButton = new MyButton("Cancel");
        cancelButton.setName("cancelButton");
        
        //  add actions listeners
        confirmButton.addActionListener(this);
        cancelButton.addActionListener(this);
        
        // add others components
        this.add(titleLabel);
        this.add(gameNameField);
        this.add(cardsLabel);
        this.add(cardsSpinner);
        this.add(confirmButton);
        this.add(cancelButton);
    }
    
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            
        	startGame();
        } else if (e.getSource() == cancelButton) {
            this.dispose();
            MainMenu.getInstance().setVisible(true);
        }
    }
    
    private void startGame() {
        //   grab configuration
    	
        String gameName = gameNameField.getText();
        int initialCards = (Integer) cardsSpinner.getValue();
        
        // creat a list to stock  active players configurations
        List<PlayerConfig> playerConfigs = new ArrayList<>();
        
        // grab data of active players
        for (int i = 0; i < MAX_PLAYERS; i++) {
            if (playerActiveCheckboxes[i].isSelected()) {
                String playerName = playerNameFields[i].getText();
                boolean isHuman = humanButtons[i].isSelected();
                String difficulty = "Medium"; // default
               
                if (!isHuman) {
                    if (easyButtons[i].isSelected()) difficulty = "Easy";
                    else if (mediumButtons[i].isSelected()) difficulty = "Medium";
                    else difficulty = "Hard";
                }
                
                playerConfigs.add(new PlayerConfig(playerName, isHuman, difficulty));
            }
        }
        
       
        
      //  Game game = new Game(gameName, initialCards, playerConfigs);
     //   game.setVisible(true);
        
       
        this.dispose();
    }      
  
}

