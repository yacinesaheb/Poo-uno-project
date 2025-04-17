package cardgame_fw.Components;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.*;

public class ImageLabel extends JLabel { // This class instantiates any type of image in our interface.
	
	private ImageIcon img; // The image that will be displayed.
	private boolean hoverBorder = false;
	private Color hoverBorderColor = new Color(0xe65050); // Light red Color

	public ImageLabel(String Imagepath) {
		
		this.img = new ImageIcon(Imagepath); // Retrieve the image from the constructor's entry.
		this.setSize(img.getIconWidth(),img.getIconHeight()); // To begin with, the label will be the same size of it's image.
		this.setOpaque(false);
	}
	
	public void setHoverBorder(boolean hoverBorder) { // Transparency setter
		this.hoverBorder = hoverBorder; 
	}
	
	public void paintComponent(Graphics g) { // Painting the image.
		super.paintComponent(g); // Calling the parent paintComponent method to paint the label.
		
		Graphics2D g2 = (Graphics2D) g.create(); // Casting to Graphics2D to use its methods.
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Activates Anti Aliasing for better colors.
		g2.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this); // The image scales with the label's size.
		
		if (hoverBorder) { // Displays the border if the value of hoverBorder is true
			g2.setColor(hoverBorderColor);
			g2.setStroke(new BasicStroke(3));
			g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, 15, 15);
		}
	}
	
	public ImageIcon getImg() { // img's getter.
		return img;
	}

	public void setImg(ImageIcon img) { // img's setter.
		this.img = img;
	}
	
}
