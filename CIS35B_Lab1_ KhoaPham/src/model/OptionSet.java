package model;

/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 1
 *Due: 04/24/2018
 *date submitted: 04/23/2018
 */
import java.io.Serializable;

public class OptionSet implements Serializable {
	private String name;
	private Option option[];

	OptionSet() {
		// constructor
	}

	// set OptionSet's name and size of array of Options
	protected void setOptionSet(String aName, int size) {
		name = aName;
		option = new Option[size];
		for (int i = 0; i < option.length; i++) {
			option[i] = new Option();
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
		option[indexOfOption].setOptionName(name);
	}

	// set price for Option with index
	protected void setOptionPrice(float price, int indexOfOption) {
		option[indexOfOption].setOptionPrice(price);
	}

	// get Option's name with index
	protected String getOptionName(int index) {
		return option[index].getOptionName();
	}

	// get Option's price with index
	protected float getOptionPrice(int index) {
		return option[index].getOptionPrice();
	}

	// method print
	protected void print() {
		System.out.println("\n\t++OptionSet name: " + name);
		if (option != null) {
			for (int i = 0; i < option.length; i++) {
				option[i].print();
			}
		}
	}

	// method finding Option with name1
	protected void findOption(String name1) {
		for (int i = 0; i < option.length; i++) {
			if (option[i].getOptionName().equalsIgnoreCase(name1)) {
				System.out.println("We found option with name: " + name1);
				option[i].print();
				return;
			}
		}
		System.out.println("We can't find option with name: " + name1);
	}

	// method delete option with name
	protected void delOption(String name1) {
		for (int i = 0; i < option.length; i++) {
			if (option[i].getOptionName().equalsIgnoreCase(name1)) {
				option[i] = new Option();
			}
		}
	}

	// here is inner class name Option
	public class Option implements Serializable {
		private String optionName;
		private float optionPrice;

		Option() {
		}

		public Option(String name, float price) {
			super();
			optionName = name;
			optionPrice = price;
		}

		// getter
		protected void setOptionName(String name) {
			optionName = name;
		}

		protected void setOptionPrice(float price) {
			optionPrice = price;
		}

		// setter
		protected String getOptionName() {
			return optionName;
		}

		protected float getOptionPrice() {
			return optionPrice;
		}

		// method print()
		protected void print() {
			System.out.println("\tOption name: " + optionName);
			System.out.println("\tOption price: " + optionPrice);
		}
	}
}
