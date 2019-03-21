package driver;

/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 1
 *Due: 04/24/2018
 *date submitted: 04/23/2018
 */
import model.*;
import util.*;

public class Driver {

	public static void main(String[] args) {
		FileIO f = new FileIO();
		Automotive car1 = f.readFile("C:\\Users\\hp\\eclipse-workspace\\CIS35B_Lab1_ KhoaPham\\src\\inputText.txt");
		car1.print();

		// serializable the data
		f.serializable(car1, "Auto1.ser");
		// deserialize the data back
		f.deserialize("Auto1.ser");

		// Finding optionset with name
		int num = car1.findOptionSet("Color", 1);
		// Finding option with name and index of optionset
		car1.findOption("Cloud 9 White", num);

		// delete optionSet with name
		car1.deleteOptionSet("Power Moonroof");
		car1.print();

		// delete Option with Name
		car1.deleteOption("Cloud 9 White", "Color");
		car1.print();

		// update OptionSet name
		car1.updateoptionSet("Color", "Painting");
		car1.print();

		// deserialize data again and print
		// so, we can recover data from memories
		Automotive car2 = f.deserialize("Auto1.ser");
		car2.print();
	}
}
