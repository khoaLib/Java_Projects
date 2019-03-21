package exception;

/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 3 ( Lab3)
 *Due: 5/15/2018
 *date submitted: 5/15/2018
 */

import model.Automobile;
import util.FileIO;

public class Fix1to100 {
	FileIO read = new FileIO();
	private Automobile au1 = read
			.readFile("C:\\Users\\hp\\eclipse-workspace\\CIS35B_Lab2_ KhoaPham\\src\\inputText02.txt");

	// Problem of missing the Model name
	public void fix1() {
		boolean flag = false;
		do {
			try {
				solvingModelName();
				flag = true;
			} catch (FixProblem e) {
				System.out.println("Before fixing: " + au1.getName());
				au1.setName(e.fixModelNameMissing());
				System.out.println("After that: " + au1.getName() + "\n");
			}
		} while (flag == false);
	}

	public void solvingModelName() throws FixProblem {
		if (au1.getName().equalsIgnoreCase("#")) {
			throw new FixProblem("Missing model name", 1);
		}
	}

	// Problem of missing the base Price and it was set at 0 as default
	public void fix2() {
		boolean flag = false;
		do {
			try {
				solvingBasePrice();
				flag = true;
			} catch (FixProblem a) {
				System.out.println("Before fixing: " + au1.getBasePrice());
				au1.setBasePrice(a.fixCarBasePrice());
				System.out.println("After that: " + au1.getBasePrice() + "\n");
			}
		} while (flag == false);
	}

	public void solvingBasePrice() throws FixProblem {
		if (au1.getBasePrice() == 0) {
			throw new FixProblem("Missing Base Price", 2);
		}
	}

	// Problem of missing the OptionSetName
	public void fix3() {
		boolean flag = false;
		do {
			try {
				solvingMissingOptionSetname(2);
				flag = true;
			} catch (FixProblem c) {
				System.out.println("Before fixing: " + au1.getOpSetName(2));
				au1.setOpSetName(c.fixMissingOptionSetName(2), 2);
				System.out.println("After that: " + au1.getOpSetName(2) + "\n");
			}
		} while (flag == false);
	}

	public void solvingMissingOptionSetname(int index) throws FixProblem {
		if (au1.getOpSetName(index).equalsIgnoreCase("#")) {
			throw new FixProblem("MissingOptionSetName", 3);
		}
	}

	//Problem of Missing the Option Name in color set
	public void fix4() {
		boolean flag = false;
		do {
			try {
				solvingMissingOptionNameInColor(0, 0);
				flag = true;
			} catch (FixProblem d) {
				System.out.println("Before fixing: " + au1.getOptionName(0, 0));
				au1.setOptionName(d.fixMissingOptionNameInColor(0), 0, 0);
				System.out.println("AFter that: " + au1.getOptionName(0, 0) + "\n");
			}
		} while (flag == false);
	}

	public void solvingMissingOptionNameInColor(int indexOfSet, int indexOfOption) throws FixProblem {
		if (au1.getOptionName(indexOfSet, indexOfOption).equalsIgnoreCase("#")) {
			throw new FixProblem("MissingOneCOlor", 4);
		}
	}

	// Problem of missing the option Name in transition
	public void fix5() {
		boolean flag = false;
		do {
			try {
				solvingMissingOptionNameInTransition(1, 0);
				flag = true;
			} catch (FixProblem e) {
				System.out.println("Before fixing: " + au1.getOptionName(1, 0));
				au1.setOptionName(e.fixMissingOptionNameInTransmission(0), 1, 0);
				System.out.println("After that: " + au1.getOptionName(1, 0) + "\n");
			}
		} while (flag == false);
	}

	public void solvingMissingOptionNameInTransition(int indexOfSet, int indexOfOption) throws FixProblem {
		if (au1.getOptionName(indexOfSet, indexOfOption).equalsIgnoreCase("#")) {
			throw new FixProblem("MissingOneTransition", 5);
		}
	}
}
