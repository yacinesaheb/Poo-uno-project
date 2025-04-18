package cardgame_fw.Components;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;


public class MySpinner extends JSpinner {
    public MySpinner(int min, int max, int step, int initial) {
        super(new SpinnerNumberModel(initial, min, max, step));
        this.setFont(new Font("Monospaced", Font.PLAIN, 16));
    }
    public MySpinner( MySpinnerNumberModel mys) {
    	super();
    }
}