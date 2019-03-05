
/**
 * @ID 1718663 Name:Zhi.Li
 *
 */
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
public class squareFlowerbeds extends JPanel{
	private int Height,Width,X,Y,flowerchoice;
	private BufferedImage background=Fileprocess.loadImage("pictureSource/grass1.png");//read the background image
	public squareFlowerbeds(int inputHeight,int inputWidth,int X,int Y,int flowerchoice){
		Height=inputHeight;
		Width=inputWidth;
		this.X=X;
		this.Y=Y;
		this.flowerchoice=flowerchoice;
		this.setLayout(new GridLayout(15,10));//use the GridLayout to auto layout the flowers into 15 rows 10 colums
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, Width, Height, this);
		}
@Override
	public String toString() {
		return "squareFlowerbed"+","+Width+","+Height+","+X+","+Y+","+flowerchoice;
	}

	public boolean equals(squareFlowerbeds other) {
	
		if(this.Width!=other.Width) {
			return false;
		}
		if(this.Height!=other.Height) {
			return false;
		}
		if(this.X!=other.X) {
			return false;
		}
		if(this.Y!=other.Y) {
			return false;
		}
		if(this.flowerchoice!=other.flowerchoice) {
			return false;
		}
		
		return true;
	}//this function isn't the override function!!But used to judge whether the object is the same
	

	
	public boolean paintsquareFlowerbeds(squareFlowerbeds square) {
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 10; j++) {
				square.add(new Flowers(flowerchoice, i * 20, j * 20));
			}
		}//use for-loop to add flowers
		Garden.GardenWindow.add(square);
		square.updateUI();
		Garden.GardenWindow.repaint();
		if(Userinterace.getSquareFlowerbeds().isEmpty()){ Userinterace.getSquareFlowerbeds().add(square);}
		else if(!(Userinterace.getSquareFlowerbeds().isEmpty())) {
			for(squareFlowerbeds squ:Userinterace.getSquareFlowerbeds()) {
				if( squ.equals(square)) {
					System.out.println("the element failed added into ArrayList ");
					return false;
				}
			}
				Userinterace.getSquareFlowerbeds().add(square);//add the flowerbed into the array to synchronize the number of flowerbed
		}
		System.out.println("the element was successfully added into ArrayList");
		return true;
		
		
	}//use the function to draw the image of flower
	@Override
	public int getHeight() {
		return Height;
	}//Override the function in Jpanel
	@Override
	public int getWidth() {
		return Width;
	}//Override the function in Jpanel
	@Override
	public int getX() {
		return X;
	}//Override the function in Jpanel
	@Override
	public int getY() {
		return Y;
	}//Override the function in Jpanel
	
	
	
	
}
