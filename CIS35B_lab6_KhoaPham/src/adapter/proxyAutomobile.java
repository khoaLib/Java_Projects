package adapter;
/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 4 ( Lab4)
 *Due: 5/29/2018
 *date submitted: 5/29/2018
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Properties;

import model.*;
import scale.EditOption;
import util.*;

public abstract class proxyAutomobile {
	// private static Automobile autoB1;
	private static LinkedHashMap<String, Automobile> autoB1 = new LinkedHashMap<String, Automobile>();

	// Create ArrayModel for lab 5
	public String[] arrayModel(int NumberOfAutoInLHM) {
		String[] temp = new String[NumberOfAutoInLHM];
		for (int i = 0; i < NumberOfAutoInLHM; i++) {
			temp[i] = autoB1.get(Integer.toString(i + 1)).getModel();
		}
		return temp;
	}

	public LinkedHashMap<String, Automobile> getLHM() {
		return autoB1;
	}

	public void setUpUpdateData(int decisionOpt, String[] arrayData) {
		new EditOption(decisionOpt, arrayData);
	}

	public void editNewOptionName(String optSetName, String OptionName, String newOptionName, String k) {
	}

	public void editNewOptionPrice(String optSetName, float OptionPrice, float newNum, String k) {

	}

	// since we can't access private proxy we need to create a path
	public Automobile getK(String aKey) {
		return autoB1.get(aKey);
	}

	// public void setNewOptionName()
	/*
	 * public void BuildAuto(String filename, String key) { FileIO f = new FileIO();
	 * // autoB1 = f.readFile(filename); autoB1.put(key, f.readFile(filename)); }
	 */
	public void BuildAuto(String filename, String key) throws IOException {
		System.out.println(filename + "^^^^^^^^^^^^^^^^^^^^^^^");
		FileIO f = new FileIO();

		File test = new File(filename);
		if (test.exists()) {
			System.out.println("Exit prop");
		}
		Properties props = new Properties();
		FileInputStream in = new FileInputStream(filename);
		props.load(in);
		autoB1.put(key, f.readProperty(props));
	}

	public void printAutoWithoutName(String key) {
		autoB1.get(key).print();
	}

	public void printAuto(String modelName, String key) {
		if (autoB1.get(key).getName().equals(modelName)) {
			autoB1.get(key).print();
		} else {
			System.out.print("We don't have any Automobile with the input name!");
		}
	}

	public void UpdateOptionSetName(String newOpSetName, String oldOpSetName, String key) {
		autoB1.get(key).updateoptionSetName(oldOpSetName, newOpSetName);
	}

	public void UpdateOptionPrice(String optionSetToSearch, String optionNameToSearching, float numb, String key) {
		int posOfOptionSet = autoB1.get(key).findOptionSet(optionSetToSearch, 0); // key 0 to skip printing the finding
																					// OptionSet
		if (posOfOptionSet == -1) {
			System.out.println("Can't find the name of the OptionSet!");
			return;
		} else {
			int posOfOption = autoB1.get(key).findOption(optionNameToSearching, posOfOptionSet);
			if (posOfOption == -2) {
				System.out.println("Can't find the name of the Option!");
				return;
			} else {
				autoB1.get(key).updateOptionPrice(posOfOptionSet, numb, posOfOption);
			}
		}
	}

	public void fix(int errorNo) {
	}

	// implements AutoServer
	public void addCreatedAutoToLHM(Automobile anAuto) {
		autoB1.put(Integer.toString(autoB1.size() + 1), anAuto);
	}

}
