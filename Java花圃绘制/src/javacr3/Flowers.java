
/**
 * @ID 1718663 Name:Zhi.Li
 *
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Flowers extends JPanel{//this class is used to print the flower itself
	private BufferedImage flowerType;
	private int X,Y;
	private int Width=20,Height=20;//set the fixed size of flower
	
	public Flowers(int choice,int X,int Y) {
		 flowerType=Fileprocess.loadImage("pictureSource/"+choice+".png");
		 this.setOpaque(false);
		 this.setBackground(null);
		 this.X=X;
		 this.Y=Y;
	}//constructor 
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(flowerType, 0, 0,20,20,this);
	}//Override the paintComponent function to draw flowers
	
	public BufferedImage getFlowerType() {
		return flowerType;
	}
	public void setX(int x) {
		X = x;
	}

	public void setY(int y) {
		Y = y;
	}
	

	@Override
	public int getX() {
		return X;
	}
	@Override
	public int getY() {
		return Y;
	}
	@Override
	public int getWidth() {
		return Width;
	}
	@Override
	public int getHeight() {
		return Height;
	}
	public BufferedImage getFlowers(int choice) {
		flowerType=Fileprocess.loadImage("pictureSource/"+choice+".png");
		
		return flowerType;
		
	}
	
}
