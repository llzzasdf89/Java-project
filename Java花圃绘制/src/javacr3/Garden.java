
/**
 * @ID 1718663 Name:Zhi.Li
 *
 */
import java.awt.Color;
import javax.swing.JFrame;

public class Garden {
		static JFrame GardenWindow;
		
		public static void main(String args[]) {// the entrance of the program
				{GardenWindow=new JFrame("myGarden");
				GardenWindow.setVisible(true);
				GardenWindow.setSize(1000, 1000);
				GardenWindow.setLocation(0, 50);
				GardenWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				GardenWindow.getContentPane().setBackground(new Color(10,90,20));}//draw the window
				try {
					Fileprocess.readData();
					Userinterace.userInterface();//switch to userInterface
				}catch(InterruptedException e) {
					System.out.println("Problems occured in the thread,the program exited");
					System.exit(1);
				}catch(Exception e) {
					System.out.println("There is another problem occured in the program,the program exited");
					e.printStackTrace();
					System.exit(1);
				}//Since this program has used the thread, thus we have to deal with the Thread Exception occurred in the thread.
				;
		}
		

	
	
}
