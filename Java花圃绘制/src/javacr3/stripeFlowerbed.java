
/**
 * @ID 1718663 Name:Zhi.Li
 *
 */
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
public class stripeFlowerbed extends JPanel{
	private int Width,Height,X,Y,flowerchoice,flowerchoice2;
	private BufferedImage background=Fileprocess.loadImage("pictureSource/grass1.png");//read the background image
	public stripeFlowerbed(int flowerbedHeight,int flowerbedWidth,int X,int Y,int flowerchoice,int flowerchoice2){
		Width=flowerbedWidth;
		Height=flowerbedHeight;
		this.X=X;
		this.Y=Y;
		this.flowerchoice=flowerchoice;
		this.flowerchoice2=flowerchoice2;
		this.setLayout(new GridLayout(15,10));
	}//constructor used to assign value 
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, Width, Height, this);
				
	}
	
	public boolean equals(stripeFlowerbed other) {
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
	}//this is not the override equal function
	public boolean paintstripeFlowerbeds(stripeFlowerbed stripe) {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 10; j++) {
				if (j % 2 == 0)
					stripe.add(new Flowers(flowerchoice, i * 20,
							j * 20));
				else {
					stripe.add(new Flowers(flowerchoice2, i * 20, j * 20));
				}
			}
		}//the grid layout firstly draw the rows then draw the columns, thus we should add a if-statement to control the columns
		Garden.GardenWindow.add(stripe);
		stripe.updateUI();
		Garden.GardenWindow.repaint();
		if(Userinterace.getStripeFlowerbeds().isEmpty()){ Userinterace.getStripeFlowerbeds().add(stripe);}
		else if(!Userinterace.getStripeFlowerbeds().isEmpty()) {
			for(stripeFlowerbed i:Userinterace.getStripeFlowerbeds()) {
				 if(i.equals(stripe)) {
					 System.out.println("the element failed added into ArrayList ");
						return false;
				 }
			}
			Userinterace.getStripeFlowerbeds().add(stripe);
		}
		System.out.println("the element was successfully added into ArrayList");
		return true;//these few rows used to add the element into the ArrayList
	}
@Override
	public String toString() {
		return "stripeFlowerbed"+","+Width+","+Height+","+X+","+Y+","+flowerchoice+","+flowerchoice2;
	}//Override the function in Jpanel
@Override
	public int getWidth() {
		return Width;
	}//Override the function in Jpanel
@Override
	public int getHeight() {
		return Height;
	}//Override the function in Jpanel
@Override
	public int getX() {

		return X;
	}
@Override
	public int getY() {
		return Y;
	}//Override the function in Jpanel

	
	
}
