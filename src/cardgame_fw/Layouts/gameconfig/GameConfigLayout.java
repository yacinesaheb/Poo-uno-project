package cardgame_fw.Layouts.gameconfig;
import java.awt.*;

//Un LayoutManager personnalisé pour la fenêtre de configuration du jeu
public class GameConfigLayout implements LayoutManager {
 
 private static final int PADDING = 25;
 private static final int COMPONENT_GAP = 20;
 
 @Override
 public void addLayoutComponent(String name, Component comp) {
	 
 }

 @Override
 public void removeLayoutComponent(Component comp) {
 }

 @Override
 public Dimension preferredLayoutSize(Container parent) {
     return new Dimension(1920,1080); //i just did it 
 }

 @Override
 public Dimension minimumLayoutSize(Container parent) {
     return new Dimension(650,985);// same
 }

 @Override
 public void layoutContainer(Container parent) {
     int width = parent.getWidth();
     int height = parent.getHeight();
     
     // Dimensions pour les composants
     int fieldWidth = Math.min(300, width - 2 * PADDING);
     int fieldHeight = 30;
     int radioButtonWidth = 100;
     int radioButtonHeight = 25;
     int buttonWidth = 120;
     int buttonHeight = 40;
     
     // Position pour chaque composant
     int currentY = PADDING;
     
     // Titre
     Component titleLabel = getComponentByName(parent, "titleLabel");
     if (titleLabel != null) {
         titleLabel.setBounds(PADDING, currentY, width - 2 * PADDING, 40);
         currentY += 50;
     }
     
     // Nom du jeu
     Component gameNameField = getComponentByName(parent, "gameNameField");
     if (gameNameField != null) {
         gameNameField.setBounds(PADDING, currentY, fieldWidth, fieldHeight);
         currentY += fieldHeight + COMPONENT_GAP;
     }
     
     // Composants des joueurs
     currentY += 20; // Espace supplémentaire avant la section des joueurs
     
     for (int i = 0; i < 4; i++) {
         Component playerLabel = getComponentByName(parent, "playerLabel_" + i);
         Component playerNameField = getComponentByName(parent, "playerNameField_" + i);
         Component playerActiveCheckbox = getComponentByName(parent, "playerActiveCheckbox_" + i);
         Component humanButton = getComponentByName(parent, "human_" + i);
         Component robotButton = getComponentByName(parent, "robot_" + i);
         Component easyButton = getComponentByName(parent, "easy_" + i);
         Component mediumButton = getComponentByName(parent, "medium_" + i);
         Component hardButton = getComponentByName(parent, "hard_" + i);
         
         int rowY = currentY;
         
         if (playerLabel != null) {
             playerLabel.setBounds(PADDING, rowY, 100, fieldHeight);
         }
         
         if (playerNameField != null) {
             playerNameField.setBounds(PADDING + 110, rowY, fieldWidth - 110, fieldHeight);
         }
         
         if (playerActiveCheckbox != null) {
             playerActiveCheckbox.setBounds(PADDING + fieldWidth + 20, rowY, 100, fieldHeight);
         }
         
         rowY += fieldHeight + 5;
         
         if (humanButton != null && robotButton != null) {
             humanButton.setBounds(PADDING, rowY, radioButtonWidth, radioButtonHeight);
             robotButton.setBounds(PADDING + radioButtonWidth + 10, rowY, radioButtonWidth, radioButtonHeight);
         }
         
         rowY += radioButtonHeight + 5;
         
         if (easyButton != null && mediumButton != null && hardButton != null) {
             easyButton.setBounds(PADDING, rowY, radioButtonWidth, radioButtonHeight);
             mediumButton.setBounds(PADDING + radioButtonWidth + 10, rowY, radioButtonWidth, radioButtonHeight);
             hardButton.setBounds(PADDING + 2 * (radioButtonWidth + 10), rowY, radioButtonWidth, radioButtonHeight);
         }
         
         currentY += 100; // Hauteur pour chaque section de joueur
     }
     
     // Nombre de cartes initiales
     Component cardsLabel = getComponentByName(parent, "cardsLabel");
     Component cardsSpinner = getComponentByName(parent, "cardsSpinner");
     
     if (cardsLabel != null && cardsSpinner != null) {
         cardsLabel.setBounds(PADDING, currentY, 120, fieldHeight);
         cardsSpinner.setBounds(PADDING + 130, currentY, 80, fieldHeight);
         currentY += fieldHeight + 20;
     }
     
     // Boutons de contrôle
     Component confirmButton = getComponentByName(parent, "confirmButton");
     Component cancelButton = getComponentByName(parent, "cancelButton");
     
     if (confirmButton != null && cancelButton != null) {
         cancelButton.setBounds(width - 2 * buttonWidth - PADDING - 10, currentY, buttonWidth, buttonHeight);
         confirmButton.setBounds(width - buttonWidth - PADDING, currentY, buttonWidth, buttonHeight);
     }
 }
 
 // Méthode utilitaire pour trouver un composant par son nom
 private Component getComponentByName(Container container, String name) {
     for (Component comp : container.getComponents()) {
         if (name.equals(comp.getName())) {
             return comp;
         }
     }
     return null;
 }
}

