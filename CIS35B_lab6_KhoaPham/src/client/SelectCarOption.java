package client;
/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 5 ( Lab5)
 *Due: 6/12/2018
 *date submitted: 6/13/2018
 */
import java.util.Scanner;

import model.Automobile;

public class SelectCarOption {
	Scanner scanner = new Scanner(System.in);

	public SelectCarOption() {

	}

	public int requestListOfModels(DefaultSocketClient socketclient) {
		System.out.println("Requesting the list of Models...");
		socketclient.sendOutput("Configure");

		String[] arrayOfModels = (String[]) socketclient.getOutput();
		for (int i = 0; i < arrayOfModels.length; i++) {
			System.out.println("\t" + (i + 1) + ". " + arrayOfModels[i]);
		}
		System.out.println("Please enter decision in integer: ");
		String temp = scanner.nextLine();
		int flagNum = Integer.parseInt(temp);
		// scanner.nextLine();

		return flagNum;
	}

	public void performOptionChoice(int choice, DefaultSocketClient socketclient) {
		socketclient.sendOutput(choice);
		char signal = ' ';
		float price = 0;

		Automobile auto = (Automobile) socketclient.getOutput();
		auto.printWithoutName();
		try {
			do {
				System.out.println("Please Enter option set: ");
				String optionSetName = scanner.nextLine();
				System.out.println("Please next enter Option: ");
				String optionName = scanner.nextLine();
				auto.setoptionChoice(optionSetName, optionName);
				price = auto.getTotalPrice();
				System.out.println("\nDo you want to add more option? (Press Y or y to continue)");
				signal = scanner.next().charAt(0);
				scanner.nextLine();
			} while (signal == 'Y' || signal == 'y');
			System.out.println("Total price of the Option choices and car: " + price + "\n");
		} catch (Exception e) {
			System.out.println("No model with the given choice in the system");
			e.printStackTrace();
		}
	}
}
