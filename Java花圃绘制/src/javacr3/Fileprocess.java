

/**
 * @ID 1718663 Name:Zhi.Li
 *
 */
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.imageio.ImageIO;
public class Fileprocess{
	public static BufferedImage loadImage(String imagePath) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(imagePath));
			System.out.println("Image loaded: " + imagePath);
		} catch (IOException e) {
			System.out.println("Problem loading image: " + imagePath);
			e.printStackTrace();
		}
		return image;
	}//used to load image from a picture
	   public static boolean saveflowerToFile() {
		   ArrayList<squareFlowerbeds> a=Userinterace.getSquareFlowerbeds();
		   ArrayList<stripeFlowerbed> b= Userinterace.getStripeFlowerbeds();//get the objects from two ArrayList,ready to write into data
	        try (FileWriter fw = new FileWriter("data.txt", false);
	                BufferedWriter bw = new BufferedWriter(fw);
	                PrintWriter out = new PrintWriter(bw)) {
	                    for(squareFlowerbeds squflowerbed: a){
	                        out.println(squflowerbed.toString());}//first write into the data in the squareFlowerbed
	                    for(stripeFlowerbed stripebed: b){
		                   out.println(stripebed.toString());//first write into the data in the stripeFlowerbed
	                    }
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	        System.out.println("flowerebeds saved to file");
	        return true; 
	    }//save the data to the document
	
	 
	public static void readData() throws InterruptedException {
	
		        Path filePath = Paths.get("data.txt");
		        if(!Files.exists(filePath)){
		            System.out.println("There is no file to read from.");
		           Userinterace.userInterface();
		        }//if the document does not exist, give out the warnings
		        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
		            String line = null;
		            while ((line = reader.readLine()) != null) {
		                System.out.println(line);
		                if(line.startsWith("squareFlowerbed")){
		                	imageFromSquareFlowerbed(line);//pass the data reading from text to the function to compose the String data
		                }
		                else if(line.startsWith("stripeFlowerbed")) {
		                	imageFromStripeFlowerbed(line);
		                }
		                else{
		                    System.out.println("Bad line in file: "+line);
		                }   
		            }
		        } catch (IOException e) {
		            System.out.println("Error reading file:" + filePath);
		            e.printStackTrace();
		            Userinterace.userInterface();
		        }
		    
	}//read the data from the document.
	public static void imageFromSquareFlowerbed(String line) {
		String data[]=line.split(",");
    	int Height,Width,Y,X,flowerchoice;
    	Height=Integer.parseInt(data[2]);
    	Width=Integer.parseInt(data[1]);
    	Y=Integer.parseInt(data[3]);
    	X=Integer.parseInt(data[4]);//get the data from the String array
    	flowerchoice=Integer.parseInt(data[5]);
    	squareFlowerbeds square = new squareFlowerbeds(Height, Width, X, Y,flowerchoice);
    	square.paintsquareFlowerbeds(square);//pass the data into the structure function to make up instance
	}//used to read the SquareFlowerbed from the document
	public static void imageFromStripeFlowerbed(String line) {
		String data[]=line.split(",");
    	int Height,Width,Y,X,flowerchoice,flowerchoice2;
    	Height=Integer.parseInt(data[2]);
    	Width=Integer.parseInt(data[1]);
    	Y=Integer.parseInt(data[3]);
    	X=Integer.parseInt(data[4]);
    	flowerchoice=Integer.parseInt(data[5]);
    	flowerchoice2=Integer.parseInt(data[6]);
    	stripeFlowerbed stripe=new stripeFlowerbed(Height,Width,X,Y,flowerchoice,flowerchoice2);
    	stripe.paintstripeFlowerbeds(stripe);
	}//used to read the StripeFlowerbed from the document
	
}
