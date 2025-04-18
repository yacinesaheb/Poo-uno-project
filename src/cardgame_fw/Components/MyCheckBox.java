package cardgame_fw.Components;
import javax.swing.JCheckBox;
import java.awt.Font;

public class MyCheckBox extends JCheckBox {
    public MyCheckBox(String text) {
        super(text);
        this.setFont(new Font("Arial", Font.PLAIN, 15));
        this.setFocusable(false);
    }
}