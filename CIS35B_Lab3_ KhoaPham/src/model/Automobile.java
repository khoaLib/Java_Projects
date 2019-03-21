package model;

/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 3 ( Lab3)
 *Due: 5/15/2018
 *date submitted: 5/15/2018
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Automobile implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private float basePrice;
	private String make;
	private String model;
	private ArrayList<OptionSet> optionSet = new ArrayList<OptionSet>();
	private ArrayList<Option> choice = new ArrayList<Option>();

	public Automobile() {
		// constructor
	}

	public Automobile(String aName, float basePrices, int opSetSize) {
		name = aName;
		basePrice = basePrices;
		for (int i = 0; i < opSetSize; i++) {
			OptionSet opSet = new OptionSet();
			optionSet.add(opSet);
		}
	}

	public void setOption(String optionSetName, int index1, int sizeOfOption) {
		optionSet.get(index1).setOptionSet(optionSetName, sizeOfOption);
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

	// new things in Lab 3:
	public void setMake(String a) {
		make = a;
	}

	public void setModel(String a) {
		model = a;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public void setoptionChoice(String setName, String optionName) {
		int counter = findOptionSet(setName, 0);
		if (counter == -1) {
			System.out.println("We found no OptionSet with that name");
		} else {
			optionSet.get(counter).setOptionChoice(optionName);
			choice.add(optionSet.get(counter).getOptionChoice());
		}
	}

	public String getOptionChoiceName(String setName) {
		Iterator<OptionSet> a = optionSet.iterator();
		String temp = "";
		while (a.hasNext()) {
			OptionSet newSet = a.next();
			temp = newSet.getname();
			if (temp.equals(setName)) {
				return newSet.getOptionChoice().getOptionName();
			}
		}
		System.out.println("There is no " + setName + " ");
		return null;
	}

	public float getOptionChoicePrice(String setName) {
		Iterator<OptionSet> a = optionSet.iterator();
		String temp = "";
		while (a.hasNext()) {
			OptionSet newSet = a.next();
			temp = newSet.getname();
			if (temp.equals(setName)) {
				return newSet.getOptionChoice().getOptionPrice();
			}
		}
		System.out.println("There is no " + setName + "'s Price ");
		return 0;
	}

	public float getTotalPrice() {
		float totalPrice = basePrice;
		for (int i = 0; i < choice.size(); i++) {
			totalPrice += choice.get(i).getOptionPrice();
		}
		return totalPrice;
	}

	// get full optionSet
	public OptionSet getOptionSet(int order) {
		return optionSet.get(order);
	}

	// set name for optionSet
	public void setOpSetName(String aName, int index) {
		optionSet.get(index).setName(aName);
	}

	// get optionSetName with specific index
	public String getOpSetName(int index) {
		return optionSet.get(index).getname();
	}

	// set values for Option name and price with specific index
	public void setOptionName(String optionName, int index, int indexOfOption) {
		optionSet.get(index).setOptionName(optionName, indexOfOption);
	}

	public void setOptionPrice(float money, int index, int indexOfOption) {
		optionSet.get(index).setOptionPrice(money, indexOfOption);
	}

	public String getOptionName(int indexOfSet, int indexOfOption) {
		return optionSet.get(indexOfSet).getOptionName(indexOfOption);
	}

	// FIND OptionSet and Option with specific name
	// key 1 to print the optionSet
	// key 0 will skip the printing
	public int findOptionSet(String name, int key) {
		// System.out.println("\nFinding OptionSet with name!!");
		for (int i = 0; i < optionSet.size(); i++) {
			if (optionSet.get(i).getname().equalsIgnoreCase(name)) {
				if (key == 1) {
					System.out.println("We found the set of Options");
					optionSet.get(i).print();
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
		int temp = optionSet.get(counter).findOption(name);
		return temp;
	}

	// Update
	public void updateoptionSetName(String oldName, String changeToThisName) {
		int index = findOptionSet(oldName, 0);
		if (index == -1) {
			System.out.println("Nothing to update");
		} else {
			optionSet.get(index).setName(changeToThisName);
		}
	}

	public void updateOptionPrice(int indexOfOptionSet, float newValuePrice, int positionOfOption) {
		if (indexOfOptionSet == -1) {
			System.out.println("Nothing to Update");
		} else {
			optionSet.get(indexOfOptionSet).setOptionPrice(newValuePrice, positionOfOption);
		}
	}

	// delete
	public void deleteOptionSet(String target) {
		System.out.println("\nDelete OptionSet with name: " + target);
		for (int i = 0; i < optionSet.size(); i++) {
			if (optionSet.get(i).getname().equalsIgnoreCase(target)) {
				optionSet.remove(i);
				return;
			}
		}
	}

	public void deleteOption(String target, String targetOptionSet) {
		System.out.println("\nDelete Option with name: " + target);
		for (int i = 0; i < optionSet.size(); i++) {
			if (optionSet.get(i).getname().equalsIgnoreCase(targetOptionSet)) {
				optionSet.get(i).delOption(target);
				return;
			}
		}
	}

	// method of printing
	public void print() {
		System.out.println("Name of Model: " + name);
		System.out.print("Base Price of Model: " + basePrice);
		if (optionSet.get(0) != null) {
			for (int i = 0; i < optionSet.size(); i++) {
				optionSet.get(i).print();
			}
		}
		System.out.println("*****************************************************************");
	}

}// end class Automotive
