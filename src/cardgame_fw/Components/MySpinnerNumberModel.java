package cardgame_fw.Components;

import javax.swing.SpinnerNumberModel;

public class MySpinnerNumberModel extends SpinnerNumberModel {
    public MySpinnerNumberModel(int initialValue, int min, int max, int stepSize) {
        super(initialValue, min, max, stepSize);
    }
}
