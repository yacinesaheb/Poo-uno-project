package cardgame_fw.Components;

import javax.swing.JRadioButton;
import java.awt.Font;

public class MyRadioButton extends JRadioButton {
    public MyRadioButton(String text) {
        super(text);
        this.setFont(new Font("Arial", Font.PLAIN, 15));
        this.setFocusable(false); 
    }
}