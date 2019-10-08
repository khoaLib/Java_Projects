package scale;
/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 4 ( Lab4)
 *Due: 5/29/2018
 *date submitted: 5/29/2018
 */
import adapter.proxyAutomobile;

public class EditOption extends proxyAutomobile implements Runnable, Scalable {
	int index;
	int threadNum;
	String[] array;
	Thread athread;

	EditOption() {
		// constructor
	};

	// acting when we create new EditOption with passing value
	public EditOption(int optNum, String[] array2) {
		index = optNum;
		array = array2;
		athread = new Thread();
		run();
	}

	@Override
	public void setUpUpdateData(int decisionOpt, String[] arrayData) {
	}

	public void stop() {
		System.out.println("DOne Thread");
		athread = null;
	}

	@Override
	public void run() {
		switch (index) {
		case 0: {
			try {
				editNewOptionName(array[0], array[1], array[2], array[3]);
				System.out.println("changed name to "+ array[2]);
				stop();
				break;
			} catch (ArrayIndexOutOfBoundsException a) {
				System.out.println("Wrong size of String array!");
				return;
			}

		}

		case 1: {
			try {
				float no2 = Float.parseFloat(array[1]);
				float no3 = Float.parseFloat(array[2]);
				editNewOptionPrice(array[0], no2, no3, array[3]);
				System.out.println("changed price to "+ no3);
				stop();
				break;
			} catch (ArrayIndexOutOfBoundsException a) {
				System.out.println("Wrong size of String array!\n Error Mark here");
				return;
			}
		}

		default: {
			System.out.println("\nError!! in making updating decision!\n\n");
			return;
		}

		}
	}

	// synchronized
	@Override
	public synchronized void editNewOptionName(String optSetName, String OptionName, String newOptionName, String k) {
		try {
			getK(k).updateOptionName(optSetName, OptionName, newOptionName);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Got interupted at setting new Option Name");
		}
		notify();
	}

	@Override
	public synchronized void editNewOptionPrice(String optSetName, float OptionPrice, float newNum, String k) {
		try {
			getK(k).updateOptionPrice(optSetName, OptionPrice, newNum);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Got interupted at setting new Option price");
		}
		notify();
	}
}
