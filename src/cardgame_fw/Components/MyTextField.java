package cardgame_fw.Components;

import javax.swing.JTextField;
import java.awt.Font;

public class MyTextField extends JTextField {
    public MyTextField(int columns) {
        super(columns);
        this.setFont(new Font("Arial", Font.PLAIN, 15));
    }
    public MyTextField (String str) {
    	super(str);
    }
}
