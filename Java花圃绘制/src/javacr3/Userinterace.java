/**
 * @ID 1718663 Name:Zhi.Li
 *
 */
import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
public class Userinterace extends Garden{
	private static Scanner a = new Scanner(System.in);//establish an instance of Scanner, and used to receive the input
	private static String userinput;//used to receive input by the user
	private static ArrayList<stripeFlowerbed> stripeFlowerbeds =new ArrayList();
	private static ArrayList<squareFlowerbeds> squareFlowerbeds=new ArrayList();//declare two ArrayLists to store different flowerbeds
	//these two ArrayLists used to store the documents and also to delete
	protected static void userInterface() throws InterruptedException {
		char userchoice = CheckWrongInput();//pass the choice of user into the function to check whether the input is legal
		switch (userchoice) {
		case 'a':
			addFlowerbed();
			userInterface();
			break;
		case 'b':
			deleteFlowerbed();
			break;
		case 'c':
			Fileprocess.saveflowerToFile();
			exitwindow();
			System.exit(0);//the exit process including 2 step: 1 exit the window,2 exit the System
			break;
		}//use switch decide the choice of user and to enter the corresponding function
	}//used to represent the userInterface
	
	private static char CheckWrongInput() {

		System.out.println("Please make a command among the three choices");
		System.out.println("a.add flowersbed\t b.delete flowers \tc.save and exit");
		while (true) {
			try {
				userinput = a.next();

				if (!(userinput.equals("a") || userinput.equals("b") || userinput.equals("c"))) {
					throw new Exception();//if the input does not match 'a''b''c', initiative throw an Exception
				}
				break;

			} catch (Exception e) {
				System.out.println("Your input is illegal,please input again");
				continue;
			}
		}//use while-loop to repetitively check the user input
		return userinput.charAt(0);
	}//used to check the user input whether right or not

	private static void addFlowerbed() {
		System.out.println("Please tell me which kind of flowerbed you want to add?");
		System.out.println("1.squareFlowerbed\t2.stripeFlowerbed");
		int input, flowerbedWidth, flowerbedHeight, X, Y, flowerchoice,flowerchoice2;
		// the followings are the repetitive while-loop to judge the input whether illegal.
		while (true) {
			try {
				input = Integer.valueOf(a.next());//prevent the character input
				if (input != 1 && input != 2) {
					throw new Exception();
				}
				break;

			} catch (Exception e) {
				System.out.println("Your input is illegal,please input again");

				continue;
			}
		}
		System.out.println("Please input the flowerbed width,please be attention that the proper value is 100-250");
		while (true) {
			try {
				flowerbedWidth =Integer.valueOf(a.next());
				if (flowerbedWidth < 100 || flowerbedWidth > 250) {
					throw new Exception();
				}

				break;
			} catch (Exception e) {
				System.out.println("Your input is illegal ,please reinut a proper value");

				continue;
			}
		}
		System.out.println("Please input the flowerbed Height,please be attention that the proper value is 100-250");
		while (true) {
			try {
				flowerbedHeight = Integer.valueOf(a.next());
				if (flowerbedHeight < 100 || flowerbedHeight > 250) {
					throw new Exception();
				}

				break;
			} catch (Exception e) {
				System.out.println("Your input is illegal ,please reinut a proper value");

				continue;
			}
		}
		System.out.println("Please input the flowerbed X,please be attention that the proper value is 250-750");
		while (true) {
			try {
				X = Integer.valueOf(a.next());
				if (X < 250 || X > 750) {
					throw new Exception();
				}

				break;
			} catch (Exception e) {
				System.out.println("Your input is illegal ,please reinut a proper value");

				continue;
			}
		}
		System.out.println("Please input the flowerbed Y,please be attention that the proper value is 250-750");
		while (true) {
			try {
				Y = Integer.valueOf(a.next());
				if (Y < 250 | Y > 750) {
					throw new Exception();
				}

				break;
			} catch (Exception e) {
				System.out.println("Your input is illegal ,please reinut a proper value");

				continue;
			}
		}
		System.out.println("Please choose a flower from the choices below:1,2,3");

		while (true) {
			try {
				flowerchoice = Integer.valueOf(a.next());
				if (flowerchoice < 1 && X > flowerchoice) {
					throw new Exception();
				}

				break;
			} catch (Exception e) {
				System.out.println("Your input is illegal ,please reinut a proper value");

				continue;
			}
		}

		switch (input) {
		case 1:
			squareFlowerbeds square = new squareFlowerbeds(flowerbedHeight, flowerbedWidth, X, Y,flowerchoice);//each time new the instance,pass the input of user to construct the object
			square.paintsquareFlowerbeds(square);
			break;
		case 2:
			System.out.println("Please choose the other flower to form the stripe flowerbed");
			System.out.println("Please choose a flower from the choices below:1,2,3");
			System.out.println("Notice:If you choose the same flower, the result is the same as the square flowerbed");
			while (true) {
				try {
					flowerchoice2 = Integer.valueOf(a.next());
					if (flowerchoice2 < 1 && X > flowerchoice2) {
						throw new Exception();
					}

					break;
				} catch (Exception e) {
					System.out.println("Your input is illegal ,please reinut a proper value");
					continue;
				}
			}
			stripeFlowerbed stripe = new stripeFlowerbed(flowerbedHeight, flowerbedWidth, X, Y,flowerchoice,flowerchoice2);
			stripe.paintstripeFlowerbeds(stripe);//call the paint way and pass in the instance to draw image
			break;
		}

	}

	private static void exitwindow() {
		Garden.GardenWindow.dispose();
	}//used to exit the window
	protected static void deleteFlowerbed() throws InterruptedException {
		int userinput;
		System.out.println("please choose the one you want to delete and enter press to delete");
		if(stripeFlowerbeds.isEmpty()&&squareFlowerbeds.isEmpty()) {
			System.out.println("now there are not any flowerbeds on the window");
			System.out.println("please wait for a second, the program shall go back to the userInterface");
			Thread.sleep(1000);
			System.out.println();
			userInterface();
		}
		
		displayFlowerbeds();
		System.out.println();
		System.out.println("Please choose the flowerbed type you want to delete and press 'Enter' key\n1.for square type,2.for stripe type");
		while(true) {
		try{
			userinput=Integer.valueOf(a.next());
			if(userinput==1||userinput==2) break;
			else throw new Exception();
		}catch(Exception e) {
			System.out.println("Your input is illgal, please check and input again");
			continue;
		}
		}
		if(userinput==1&&!squareFlowerbeds.isEmpty()) {
			System.out.println("please input the number of the square flowerbed you want to delete");
			int counter=1;
			for(squareFlowerbeds square:squareFlowerbeds) {
				System.out.println(counter+".squareflowerbed at X "+square.getX()+" Y "+square.getY());
				counter++;
			}
			while(true) {
			try{
				userinput=Integer.valueOf(a.next());
				if(userinput<squareFlowerbeds.size()||userinput>0) break;
				else throw new Exception();
			}catch(Exception e) {
				System.out.println("Your input is illgal, please check and input again");
				continue;
			}
			}
			squareFlowerbeds.remove(userinput-1);
			
			Userinterace.clearthewindow();
		}
		else if(userinput==2&&!stripeFlowerbeds.isEmpty()) {
			int counter=1;
			for(stripeFlowerbed stripe:stripeFlowerbeds) {
				System.out.println(counter+".stripeflowerbed at X "+stripe.getX()+" Y "+stripe.getY());
				counter++;
			}
			while(true) {try{
				userinput=Integer.valueOf(a.next());
				if(userinput<stripeFlowerbeds.size()||userinput>0) break;
				else throw new Exception();
			}catch(Exception e) {
				System.out.println("Your input is illgal, please check and input again");
				continue;
			}
			}
			stripeFlowerbeds.remove(userinput-1);
			
			Userinterace.clearthewindow();
			
		}
		else {
			System.out.println("the flowerbed type you choose is none!,please make sure the type you want to delete exist");
			userInterface();
			
		}
		System.out.println("You have successfully deleted the flowerbed");
		userInterface();
		
	}
	protected static void displayFlowerbeds() {

		int counter=1;
		System.out.println("Now you have "+(stripeFlowerbeds.size()+squareFlowerbeds.size())+" flowerbeds in the windows");
		System.out.println("following are the flowerbeds on the window");
		for(stripeFlowerbed stripe : stripeFlowerbeds) {
			System.out.println(counter+".stripeflowerbed at X "+stripe.getX()+" Y "+stripe.getY());
			counter++;
		}
		for(squareFlowerbeds square:squareFlowerbeds) {
			System.out.println(counter+".squareflowerbed at X "+square.getX()+" Y "+square.getY());
			counter++;
		}
		
	}
	private static void clearthewindow() {
			Garden.GardenWindow.dispose();
			Garden.GardenWindow=new JFrame();
			GardenWindow.setVisible(true);
			Garden.GardenWindow.getContentPane().setBackground(new Color(10,90,20));
			Garden.GardenWindow.setSize(1000,1000);
			GardenWindow.setLocation(0, 50);
			Garden.GardenWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			try {
				Fileprocess.saveflowerToFile();
				stripeFlowerbeds.clear();
				squareFlowerbeds.clear();
				Fileprocess.readData();
			} catch (InterruptedException e) {
				System.out.println("There is problem with thread, the program has exited");
			}
	}
/*Remove flowerbed is based on the way that each time remove, synchronize the ArrayList item; and close the window, store the data into file;
Reloading the data from the file and creat a new window.Thus this function is used to clear the window	
	*/
	public static ArrayList<stripeFlowerbed> getStripeFlowerbeds() {
		return stripeFlowerbeds;
	}
//get stripeFlowerbedArrayList function

	public static ArrayList<squareFlowerbeds> getSquareFlowerbeds() {
		return squareFlowerbeds;
	}
	//get squareFlowerbedArrayList function




}

