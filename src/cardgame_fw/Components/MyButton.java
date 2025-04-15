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

public class MyButton extends JButton implements MouseListener {
	
	Font myFont = new Font("Monospaced",Font.BOLD,25);
	
	public MyButton(String Text) {
		
		this.setText(Text); // Sets the text that will be written on the Button.
		this.setFocusable(false); // Removes the box around the text.
		this.setSize(350,80);
		this.addMouseListener(this);
		
		// Removing all the default swing rendering to create our own 3D rendering.
		this.setOpaque(false); 
        this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		
	}
	
	private boolean pressed = false;
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g.create(); // Casting to Graphics2D to use its methods.
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Setting the Shape : Oval shape
        g2.setColor(new Color(255, 255, 255, pressed ? 90 : 60));
        g2.fillOval(0, 0, getWidth(), getHeight());

        // Setting some shadow 
        g2.setColor(new Color(0, 0, 0, 50));
        g2.setStroke(new BasicStroke(2));
        g2.drawOval(1, 1, getWidth() - 2, getHeight() - 2);

        // Setting the Font of the Text.
        g2.setFont(myFont);
        FontMetrics fm = g2.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
        g2.setColor(Color.WHITE);
        g2.drawString(getText(), x, y);

        g2.dispose();
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
