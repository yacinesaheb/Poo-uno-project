package cardgame_fw.Components;

import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cardgame_fw.Layouts.LayoutManagement;
import uno_gui.Options.DisplayColor;

public class MyFrame extends JFrame implements LayoutManagement { // This Class instantiates a window with a title,icon and background image as entry.

	private Background bgr;
	
	public MyFrame(String Title,ImageIcon Icon,String BackgroundImagePath) {
		
		if (BackgroundImagePath != null) {
			bgr = new Background(BackgroundImagePath); // Gets the image path from the constructor's entry and instantiates a "Background" class.
			this.setContentPane(bgr); // Sets the background of the window.
		}
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // User can't exit the frame until he presses a button that is included in the frame itself.
		this.setResizable(true); // Window can be resized.
		this.setTitle(Title); // Sets the title of the window from the constructor's entry.
		this.setIconImage(Icon.getImage()); // Set the Icon of the Window from the constructor's entry.
		this.setSize(1920,1080); // Sets the default size of the frame.
		this.setLocationRelativeTo(null); // When opening the window, it is centered in the screen.
		
	}
	
	public class Background extends JPanel {

		private BufferedImage bgImg; // The image that will be set as a background.
		
		public void setBgImg(String imgpath) {
			 try {
				this.bgImg = ImageIO.read(new File(imgpath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 repaint();
		}
		
		public Background(String imgPath) { // the constructor basically reads the Image with an exception handler.
			
			if (imgPath != null) {
			try {
	            bgImg = ImageIO.read(new File(imgPath));
	        } catch (IOException e) {
	            System.err.println("Could not load Image : " + e.getMessage());
	        }
	        setLayout(null); // Sets the layout to null to display the image.
			}
			
		}
		

		public void paintComponent(Graphics g) { 
			super.paintComponent(g); // Calls the function of the parent JPanel.
			g.drawImage(bgImg,0,0,getWidth(),getHeight(),this); // Draws the image to let it resize with the PAnel.
		}
		
	}

	public void repaintBg(String imgpath) {
		this.bgr.setBgImg(imgpath);
	}
	
	@Override
	public void adjustLayout() {
		// This will be called in the instantiations of the MyFrame class.
	}
}
