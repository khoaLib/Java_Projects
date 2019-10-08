package client;
/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 5 ( Lab5)
 *Due: 6/12/2018
 *date submitted: 6/13/2018
 */
import java.io.File;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Scanner;

public class CarClient {
	private static boolean DEBUG = true;
	private Scanner scan = new Scanner(System.in);
	private DefaultSocketClient defaultSocket;
	private SelectCarOption selectcar = new SelectCarOption();
	
	public CarClient() {
		String hostAddress;
		try {
			hostAddress = Inet4Address.getLocalHost().getHostAddress();// help to get IPv4 of the current Host internet
																		// using Inet4Address in library
			defaultSocket = new DefaultSocketClient(hostAddress, 1995);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		defaultSocket.openConnection();
	}

	public void choiceMenu() {
		System.out.println("\t*******************************************");
		System.out.println("\t*Menu of choices                          *");
		System.out.println("\t*******************************************");
		System.out.println("\t*1. Upload File                           *");
		System.out.println("\t*2.Configure                              *");
		System.out.println("\t*3. Afk for Number of Models in the system*");
		System.out.println("\t*4.Quit Program                           *");
		System.out.println("\t*******************************************");
	}

	public void processClient() {
		boolean flag = false;
		boolean signal = false;
		int flagNum = 0;
		do {
			choiceMenu();
			do {
				System.out.println("Please enter decision from 1 to 4 by integer: ");

				String temp = scan.nextLine();
				flagNum = Integer.parseInt(temp);
				scan.nextLine();
				if (flagNum != 1 && flagNum != 2 && flagNum != 3 && flagNum != 4) {
					System.out.println("You supposed to enter integer from 1-4 \n Let's try again!");
					signal = false;
				}
			} while (signal == true);

			// perform a small switch with 3 choices
			switch (flagNum) {
			case 1: { // load property and send to sever then wait for signal
				printExampleFileName(DEBUG);
				uploadFile();

				break;
			}
			case 2: {
				int choice = selectcar.requestListOfModels(defaultSocket);
				selectcar.performOptionChoice(choice, defaultSocket);
				break;
			}

			case 3:
				requestNumberOfModel();
				break;

			case 4: {
				flag = true;
				closeClient();
				break;
			}
			}
		} while (!flag);
	}

	public void requestNumberOfModel() {
		defaultSocket.sendOutput("NumberOfModel");
		// String temp = (String) defaultSocket.getOutput();
		int NumberofModel = (int) defaultSocket.getOutput();
		System.out.println("The system currently have: " + NumberofModel + "\n");
	}

	public void printExampleFileName(boolean a) {
		if (a) {
			System.out.println("Since the Window need you to provide address of the Properties files");
			System.out.println("We have 2 example Property file below: ");
			for (int i = 1; i <= 2; i++) {
				if (i == 1) {
					System.out.println("\t" + i + ". "
							+ "C:\\\\Users\\\\hp\\\\eclipse-workspace\\\\CIS35B_lab6_KhoaPham\\\\src\\\\PropertyText101.properties");
				} else {
					System.out.println("\t" + i + ". "
							+ "C:\\\\Users\\\\hp\\\\eclipse-workspace\\\\CIS35B_lab6_KhoaPham\\\\src\\\\property02.properties");
				}
			}
		}
	}

	public void uploadFile() {
		CarModelOptionsIO c = new CarModelOptionsIO();
		System.out.println("Please enter the address of the property file below: ");
		String tempLine = scan.nextLine();
		// scan.nextLine()
		// System.out.println(tempLine);
		File testingf = new File(tempLine);
		if (!testingf.exists()) {
			System.out.println("There is no file with the given name");
		} else {
			Properties proper = c.readProper(tempLine);
			if (proper == null) {
				System.out.println("Empty file");
			} else {
				defaultSocket.sendOutput(proper);

				if (defaultSocket.getOutput().equals("ConfirmedUpload")) {
					System.out.println("Done Upload");
				} else {
					System.out.println("Fail to upload");
				}
			}
		}
	}

	public void closeClient() {
		System.out.println("CLose");
		defaultSocket.sendOutput("Quit");
		defaultSocket.closeSession();
	}
}
