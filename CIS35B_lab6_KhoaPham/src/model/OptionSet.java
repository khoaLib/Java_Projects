package model;

/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 5 ( Lab5)
 *Due: 6/12/2018
 *date submitted: 6/13/2018
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class OptionSet implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<Option> option1 = new ArrayList<Option>();
	private Option choiceInOptSet;

	OptionSet() {
		// constructor
	}

	// set OptionSet's name and size of array of Options
	protected void setOptionSet(String aName, int size) {
		name = aName;
		for (int i = 0; i < size; i++) {
			Option op = new Option();
			option1.add(op);
		}
	}

	protected void setName(String a) {
		name = a;
	}

	protected String getname() {
		return name;
	}

	// set name for Option with index
	protected void setOptionName(String name, int indexOfOption) {
		option1.get(indexOfOption).setOptionName(name);
	}

	// set price for Option with index
	protected void setOptionPrice(float price, int indexOfOption) {
		option1.get(indexOfOption).setOptionPrice(price);
	}

	// get Option's name with index
	protected String getOptionName(int index) {
		return option1.get(index).getOptionName();
	}

	// get Option's price with index
	protected float getOptionPrice(int index) {
		return option1.get(index).getOptionPrice();
	}

	// method print
	protected void print() {
		System.out.println("\n\t++OptionSet name: " + name);
		if (option1 != null) {
			for (int i = 0; i < option1.size(); i++) {
				option1.get(i).print();
			}
		}
	}

	// method finding Option with name1 
	protected int findOption(String name1) {
		for (int i = 0; i < option1.size(); i++) {
			if (option1.get(i).getOptionName().equalsIgnoreCase(name1)) {
				System.out.println("We found option with name: " + name1);
				return i;
			}
		}
		System.out.println("We can't find option with name: " + name1);
		return -2;
	}

	protected int findOptionByPrice(float price) {
		for (int i = 0; i < option1.size(); i++) {
			if (option1.get(i).getOptionPrice() == price) {
				System.out.println("We found option with name: " + price);
				return i;
			}
		}
		System.out.println("We can't find option with name: " + price);
		return -2;
	}

	// ***************************************
	protected void updateOptionName(String oldOptionName, String newOptionName) {
		int count = findOption(oldOptionName);
		option1.get(count).setOptionName(newOptionName);
	}

	protected void updateOptionPrice(float oldPrice, float newPrice) {
		int count = findOptionByPrice(oldPrice);
		option1.get(count).setOptionPrice(newPrice);
	}
	// *******************************************

	// method delete option with name
	protected void delOption(String name1) {
		for (int i = 0; i < option1.size(); i++) {
			if (option1.get(i).getOptionName().equalsIgnoreCase(name1)) {
				option1.remove(i);
			}
		}
	}

	// new methods for lab 3 as requirement
	protected void setOptionChoice(String optionName) {
		Iterator<Option> iter1 = option1.iterator();
		String temp = " ";
		while (iter1.hasNext()) {
			Option newOp = iter1.next();
			temp = newOp.getOptionName();
			if (temp.equals(optionName)) {
				choiceInOptSet = newOp;
			}
		}
	}

	protected float getOptionChoicePrice(String optionName) {
		String temp = "";
		float value = 0;
		Iterator<Option> iter2 = option1.iterator();
		while (iter2.hasNext()) {
			Option newOp = iter2.next();
			temp = newOp.getOptionName();
			if (temp.equals(optionName)) {
				value = newOp.getOptionPrice();
			}
		}
		return value;
	}

	protected Option getOptionChoice() {
		if (option1 != null) {
			return choiceInOptSet;
		} else {
			return null;
		}
	}

}
