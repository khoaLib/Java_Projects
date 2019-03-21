package exception;

/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 3 ( Lab3)
 *Due: 5/15/2018
 *date submitted: 5/15/2018
 */

public class FixProblem extends Exception {
	private static final long serialVersionUID = 1L;
	private String erroName;
	private int erroNo;

	public FixProblem(String name, int index) {
		super();
		erroName = name;
		erroNo = index;
		printProblem();
	}

	// setter
	public void setErroName(String name) {
		erroName = name;
	}

	public void setErroNo(int counter) {
		erroNo = counter;
	}

	// getter
	public String getErroName() {
		return erroName;
	}

	public int getErroNo() {
		return erroNo;
	}

	public void printProblem() {
		System.out.println("Error #" + erroNo + ": " + erroName);
	}

	// fixing methods
	public String fixModelNameMissing() {
		String temp = "Forcus Wagon ZTW";
		System.out.println("Filling missing Model name with Forcus Walgon ZTW");
		return temp;
	}

	public float fixCarBasePrice() {
		System.out.println("Filling missing base Price with a default price for Forcus Walgon ZTW: $20.897");
		return 20897;
	}

	public String fixMissingOptionSetName(int indexOfMissingOptionSetName) {
		String temp = "";
		switch (indexOfMissingOptionSetName) {
		case 0: {
			temp = "Color";
			break;
		}
		case 1: {
			temp = "Transmission";
			break;
		}
		case 2: {
			temp = "Brakes/Traction Control";
			break;
		}
		case 3: {
			temp = "Side Impact Air Bags";
			break;
		}
		case 4: {
			temp = "Power Moonroof";
			break;
		}
		default: {
			System.out.println("The data is wrong!");
			temp = "Unexpected value";
			break;
		}
		}
		return temp;
	}

	public String fixMissingOptionNameInColor(int indexOfMissinfOptionName) {
		String color = "";
		switch (indexOfMissinfOptionName) {
		case 0:
			color = "FortKnox Gold";
			break;
		case 1:
			color = "Liquid Grey";
			break;
		case 2:
			color = "Infra-Red";
			break;
		case 3:
			color = "Grabber Green";
			break;
		case 4:
			color = "Sangria red";
			break;
		case 5:
			color = "french Blue";
			break;
		case 6:
			color = "Twilight Blue and Black";
			break;
		case 7:
			color = "CD Silver";
			break;
		case 8:
			color = "Unicorn RainBow colors";
			break;
		case 9:
			color = "Pitch Black";
			break;
		case 10:
			color = "Cloud 9 White";
			break;
		}
		return color;
	}

	public String fixMissingOptionNameInTransmission(int indexOfMissingOptionName) {
		String trans = "";
		if (indexOfMissingOptionName == 0) {
			trans = "automatic";
		} else if (indexOfMissingOptionName == 1) {
			trans = "Standard";
		} else {
			System.out.println("Undifined Transmission data! Return option name with blank.");
		}
		return trans;
	}

}
