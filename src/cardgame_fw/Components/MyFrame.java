package cardgame_fw.Components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cardgame_fw.Layouts.MainMenuLayout;

public class MyFrame extends JFrame {

	
	public MyFrame(String Title,ImageIcon Icon,String BackgroundImagePath) {
		
		Background bgImg = new Background(BackgroundImagePath);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // User can't exit the frame until he presses a button that is included in the frame itself.
		this.setResizable(true); // Window can be resized.
		this.setTitle(Title);
		this.setMinimumSize(new Dimension(600,600));
		this.setIconImage(Icon.getImage()); // Set the Icon of the Window.
		this.setContentPane(bgImg);
	}
	
	public class Background extends JPanel {

		private BufferedImage bgImg;
		
		public Background(String imgPath) {
			
			try {
	            bgImg = ImageIO.read(new File(imgPath));
	        } catch (IOException e) {
	            System.err.println("Erreur lors du chargement de l'image : " + e.getMessage());
	        }
	        setLayout(null);
			
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // Calls the function of JPanel.
			g.drawImage(bgImg,0,0,getWidth(),getHeight(),this);
		}
		
	}
}
