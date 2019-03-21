package adapter;
/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 2 ( Lab2)
 *Due: 5/4/2018
 *date submitted: 5/4/2018
 */

import model.*;
import util.*;

public abstract class proxyAutomobile {
	private static Automobile autoB1;

	public void BuildAuto(String filename) {
		FileIO f = new FileIO();
		autoB1 = f.readFile(filename);
	}

	public void printAutoWithoutName() {
		autoB1.print();
	}

	public void printAuto(String modelName) {
		if (autoB1.getName().equals(modelName)) {
			autoB1.print();
		} else {
			System.out.print("We don't have any Automobile with the input name!");
		}
	}

	public void UpdateOptionSetName(String newOpSetName, String oldOpSetName) {
		autoB1.updateoptionSetName(oldOpSetName, newOpSetName);
	}

	public void UpdateOptionPrice(String optionSetToSearch, String optionNameToSearching, float numb) {
		int posOfOptionSet = autoB1.findOptionSet(optionSetToSearch, 0); // key 0 to skip printing the finding OptionSet
		if (posOfOptionSet == -1) {
			System.out.println("Can't find the name of the OptionSet!");
			return;
		} else {
			int posOfOption = autoB1.findOption(optionNameToSearching, posOfOptionSet);
			if (posOfOption == -2) {
				System.out.println("Can't find the name of the Option!");
				return;
			} else {
				autoB1.updateOptionPrice(posOfOptionSet, numb, posOfOption);
			}
		}
	}

	public void fix(int errorNo) {

	}
}
