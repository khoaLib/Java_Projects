package model;

/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 2 ( Lab2)
 *Due: 5/4/2018
 *date submitted: 5/4/2018
 */
import java.io.*;

public class Automobile implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private float basePrice;
	private OptionSet opSet[];

	public Automobile() {
		// constructor
	}

	public Automobile(String aName, float basePrices, int opSetSize) {
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
	
	public String getOptionName(int indexOfSet, int indexOfOption) {
		return opSet[indexOfSet].getOptionName(indexOfOption);
	}

	// FIND OptionSet and Option with specific name
	// key 1 to print the optionSet
	// key 0 will skip the printing
	public int findOptionSet(String name, int key) {
		System.out.println("\nFinding OptionSet with name!!");
		for (int i = 0; i < opSet.length; i++) {
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

	// method find option having name and counter of OptionSet
	public int findOption(String name, int counter) {
		System.out.println("\nFinding Option with name and with index of OptionSet!!");
		int temp = opSet[counter].findOption(name);
		return temp;
	}

	// Update
	public void updateoptionSetName(String oldName, String changeToThisName) {
		int index = findOptionSet(oldName, 0);
		if (index == -1) {
			System.out.println("Nothing to update");
		} else {
			opSet[index].setName(changeToThisName);
		}
	}

	public void updateOptionPrice(int indexOfOptionSet, float newValuePrice, int positionOfOption) {
		// int index = findOptionSet(optionSetName,0);
		if (indexOfOptionSet == -1) {
			System.out.println("Nothing to Update");
		} else {
			opSet[indexOfOptionSet].setOptionPrice(newValuePrice, positionOfOption);
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
