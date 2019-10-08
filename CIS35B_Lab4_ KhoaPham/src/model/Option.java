package model;

/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 3 ( Lab3)
 *Due: 5/15/2018
 *date submitted: 5/15/2018
 */
import java.io.Serializable;

public class Option implements Serializable {
	private static final long serialVersionUID = 1L;
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
		// System.out.println("Testing line: "+ price);

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
