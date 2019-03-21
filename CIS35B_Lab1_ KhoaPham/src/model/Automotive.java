package model;

/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 1
 *Due: 04/24/2018
 *date submitted: 04/23/2018
 */
import java.io.*;

public class Automotive implements Serializable {
	private String name;
	private float basePrice;
	private OptionSet opSet[];

	public Automotive() {
		// constructor
	}

	public Automotive(String aName, float basePrices, int opSetSize) {
		name = aName;
		basePrice = basePrices;
		opSet = new OptionSet[opSetSize];
		for (int i = 0; i < opSet.length; i++) {
			opSet[i] = new OptionSet();
		}
	}

	public void setOption(String optionSetName, int index1, int sizeOfOption) {
		opSet[index1].setOptionSet(optionSetName, sizeOfOption);
	}

	public void setName(String a) {
		name = a;
	}

	public String getName() {
		return name;
	}

	public void setBasePrice(float price) {
		basePrice = price;
	}

	public float getBasePrice() {
		return basePrice;
	}

	// get full optionSet
	public OptionSet getOptionSet(int order) {
		return opSet[order];
	}

	// set name for optionSet
	public void setOpSetName(String aName, int index) {
		opSet[index].setName(aName);
	}

	// get optionSetName with specific index
	public String getOpSetName(int index) {
		return opSet[index].getname();
	}

	// set values for Option name and price with specific index
	public void setOptionName(String optionName, int index, int indexOfOption) {
		opSet[index].setOptionName(optionName, indexOfOption);
	}

	public void setOptionPrice(float money, int index, int indexOfOption) {
		opSet[index].setOptionPrice(money, indexOfOption);
	}

	// FIND OptionSet and Option with specific name
	// key 1 to print the optionSet
	// key 0 will skip the printing
	public int findOptionSet(String name, int key) {
		System.out.println("\nFinding OptionSet with name!!");
		for (int i = 0; i < opSet.length; i++) {
			// System.out.println("Checking : " +opSet[i].getname()+","+name+ "\n");
			if (opSet[i].getname().equalsIgnoreCase(name)) {
				if (key == 1) {
					System.out.println("We found the set of Options");
					opSet[i].print();
					System.out.println("*****************************************************************");
					System.out.println("\n");
				}
				return i;
			}
		}
		System.out.println(" We can't find that Option Set");
		return -1;
	}

	// method find option having name and index of OptionSet
	public void findOption(String name, int counter) {
		System.out.println("\nFinding Option with name and with index of OptionSet!!");
		opSet[counter].findOption(name);
	}

	// Update
	public void updateoptionSet(String oldName, String changeToThisName) {
		int index = findOptionSet(oldName, 0);
		if (index == -1) {
			System.out.println("Nothing to update");
		} else {
			opSet[index].setName(changeToThisName);
		}
	}

	// delete
	public void deleteOptionSet(String target) {
		System.out.println("\nDelete OptionSet with name: " + target);
		for (int i = 0; i < opSet.length; i++) {
			if (opSet[i].getname().equalsIgnoreCase(target)) {
				opSet[i] = new OptionSet();
				return;
			}
		}
	}

	public void deleteOption(String target, String targetOptionSet) {
		System.out.println("\nDelete Option with name: " + target);
		for (int i = 0; i < opSet.length; i++) {
			if (opSet[i].getname().equalsIgnoreCase(targetOptionSet)) {
				opSet[i].delOption(target);
				return;
			}
		}
	}

	// method of printing
	public void print() {
		System.out.println("Name of Model: " + name);
		System.out.print("Base Price of Model: " + basePrice);
		if (opSet[0] != null) {
			for (int i = 0; i < opSet.length; i++) {
				opSet[i].print();
			}
		}
		System.out.println("*****************************************************************");
	}

}// end class Automotive
