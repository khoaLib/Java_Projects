package driver;

/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 2 ( Lab2)
 *Due: 5/4/2018
 *date submitted: 5/4/2018
 */

import adapter.*;
import exception.AutoException;

public class Driver {

	public static void main(String[] args) {
		BuildAuto auto = new BuildAuto();
		auto.BuildAuto("C:\\Users\\hp\\eclipse-workspace\\CIS35B_Lab2_ KhoaPham\\src\\inputText.txt");

		auto.printAuto("Focus Wagon ZTW");

		// Now we update optionSetName Color to Paint and OptionPrice of "Unicorn
		// Rainbow colors"
		// From 0.0 to 10000
		auto.UpdateOptionSetName("Paint", "Color");
		auto.UpdateOptionPrice("Paint", "Unicorn Rainbow colors", 10000);
		auto.printAuto("Focus Wagon ZTW");
		
		
		//reading and fixing a new inputText02.txt
		AutoException except = new AutoException();
		except.fix(1);
		except.fix(2);
		except.fix(3);
		except.fix(4);
		except.fix(5);
	}
}

/*
 * FileIO f = new FileIO(); Automobile car1 = f.
 * readFile("C:\\Users\\hp\\eclipse-workspace\\CIS35B_Lab1_ KhoaPham\\src\\inputText.txt"
 * ); auto.print(); // serializable the data f.serializable(auto, "Auto1.ser");
 * // deserialize the data back f.deserialize("Auto1.ser");
 * 
 * // Finding optionset with name int num = auto.findOptionSet("Color", 1); //
 * Finding option with name and index of optionset int numOfOption =
 * auto.findOption("Cloud 9 White", num);
 * 
 * // delete optionSet with name auto.deleteOptionSet("Power Moonroof");
 * auto.print();
 * 
 * // delete Option with Name auto.deleteOption("Cloud 9 White", "Color");
 * auto.print();
 * 
 * // update OptionSet name auto.updateoptionSetName("Color", "Painting");
 * auto.print();
 * 
 * // deserialize data again and print // so, we can recover data from memories
 * Automobile car2 = f.deserialize("Auto1.ser"); car2.print();
 */