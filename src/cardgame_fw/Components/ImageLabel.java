package cardgame_fw.Components;

import java.awt.Dimension;

import javax.swing.*;

public class ImageLabel extends JLabel {

	public ImageLabel(ImageIcon Img) {
		
		this.setSize(Img.getIconWidth(),Img.getIconHeight());
		this.setIcon(Img);
		this.setOpaque(false);
	}
	
}
