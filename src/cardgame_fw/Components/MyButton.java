package cardgame_fw.Components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class MyButton extends JButton implements MouseListener { // This class instantiates a custom button for the GUI interface.
	
	
	public MyButton(String Text) {
		
		this.setText(Text); // Sets the text that will be written on the Button.
		this.setFocusable(false); // Removes the box around the text.
		this.setSize(350,80); // Sets a default size to the button.
		this.addMouseListener(this); // Adding a mouse listener to implement actions and animations.
		
		// Removing all the default swing rendering to create our own rendering with shadows etc...
		this.setOpaque(false); 
        this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		
	}
	
	private boolean pressed = false; // This here will help know if the button is pressed or not in the MouseListener methods.
	
	public void paintComponent(Graphics g) { // Redefining completely the paintComponent method without calling the parent constructor.
		
		Graphics2D g2 = (Graphics2D) g.create(); // Casting to Graphics2D to use its methods.
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Setting Anti Aliasing to a better display of the button.

        // Setting the Oval Shape and the color 
        g2.setColor(new Color(255, 255, 255, pressed ? 90 : 60));
        g2.fillOval(0, 0, getWidth(), getHeight());

        // Setting some shadow 
        g2.setColor(new Color(0, 0, 0, 50));
        g2.setStroke(new BasicStroke(2));
        g2.drawOval(1, 1, getWidth() - 2, getHeight() - 2);
        
        
        // Setting Font size adaptability to the size of the button :
        float fontSize = getHeight() * 0.4f;
        fontSize = Math.max(fontSize, 8f); // Minimum size
        fontSize = Math.min(fontSize, 42f); // Maximum size

        Font myFont = new Font("Monospaced",Font.BOLD,(int)fontSize); // Creating the Button's Font (choosing the police and making it bold)
        
        // Setting the Font of the Text.
        g2.setFont(myFont);
        FontMetrics fm = g2.getFontMetrics(); // Render the text with it's font on the button.
        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
        g2.setColor(Color.WHITE); // Sets the text color to white.
        g2.drawString(getText(), x, y); // Displaying the text on the button.

        g2.dispose(); // Disposed of the context to free resources.
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// This will be set in the frames as an action.
	}

	@Override
	public void mousePressed(MouseEvent e) {
		pressed = true; // Sets pressed value to true so that the color changes when repainting.
		repaint(); // Recalls the paintComponent method.
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		pressed = false; // Sets pressed value to false so that the color changes when repainting.
		repaint(); // Recalls the paintComponent method.
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setSize(this.getWidth() - 5,this.getHeight() - 5); // Makes the button smaller when the mouse passes.
		this.repaint(); // Recalls the paintComponent method.
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setSize(this.getWidth() + 5,this.getHeight() + 5); // Makes the button bigger when the mouse passes.
		this.repaint();	// Recalls the paintComponent method.
	}

}
