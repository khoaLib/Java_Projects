package util;

/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 5 ( Lab5)
 *Due: 6/12/2018
 *date submitted: 6/13/2018
 */
import model.*;
import java.io.*;
import java.util.Properties;

public class FileIO {
	private boolean DEBUG = false;

	public Automobile readProperty(Properties prop1) {
		Automobile automobiles = new Automobile();

		try {

			String carmake = prop1.getProperty("CarMake");

			if (!carmake.equals(null)) { // In other words, if the property is not empty
				String carModel = prop1.getProperty("CarModel");
				String price = prop1.getProperty("CarPrice");
				float carPrice = Float.parseFloat(price);
				String optionSetCap = prop1.getProperty("OptSetSize");
				int optSetSize = Integer.parseInt(optionSetCap);

				// now set the values into Automobile class
				automobiles = new Automobile(carmake, carModel, carPrice, optSetSize);

				for (int i = 0; i < optSetSize; i++) {
					String optionName = prop1.getProperty("OptSet" + (i + 1));
					int sizeOfOptionSet = Integer.parseInt(prop1.getProperty("OptSet" + (i + 1) + "Size"));
					// set OptionSet Name
					automobiles.setOption(optionName, i, sizeOfOptionSet);

					for (int j = 0; j < sizeOfOptionSet; j++) {
						String optName = prop1.getProperty("Opt" + (i + 1) + "Choice" + (j + 1));
						automobiles.setOptionName(optName, i, j);
						float carValue = Float.parseFloat(prop1.getProperty("Opt" + (i + 1) + "Price" + (j + 1)));
						automobiles.setOptionPrice(carValue, i, j);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return automobiles;
	}

	public Automobile readFile(String fileName) {
		Automobile auto1 = new Automobile();
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader buff = new BufferedReader(file);
			boolean eof = false; // help the loop runs to the final line
			int counter = 0;
			int optCount = 0;
			while (!eof || optCount > 5) {
				String line = buff.readLine();
				if (line == null) {
					eof = true; // end the process because of empty text file
					return auto1;
				} else {
					if (counter == 0) {
						String modelName = line;
						line = buff.readLine();
						float modelPrice = Float.parseFloat(line);
						line = buff.readLine();
						int sizeOfOptionSet = Integer.parseInt(line);

						// set name + price + size of OptionSet
						auto1 = new Automobile(modelName, modelPrice, sizeOfOptionSet);
						// System.out.println("++++++Cheking weird model name: "+ auto1.getName());
						line = buff.readLine();
						if (DEBUG) {
							System.out
									.println("Checking line: " + modelName + " " + modelPrice + ", " + sizeOfOptionSet);
						}
						counter = 2;
					}
					// lines starting with '!' are the name of Optionset
					if (line.charAt(0) == '!') {
						String optSetName = line.substring(1);
						line = buff.readLine();
						int sizeOfOption = Integer.parseInt(line);

						// set name of optionSet, and size of array of option with index
						auto1.setOption(optSetName, optCount, sizeOfOption);

						for (int i = 0; i < sizeOfOption; i++) {
							line = buff.readLine();
							auto1.setOptionName(line, optCount, i);
							line = buff.readLine();
							float numb = Float.parseFloat(line);
							auto1.setOptionPrice(numb, optCount, i);
						} // end for loop
					}

				}
				optCount += 1;
			}
			buff.close();
		} catch (Exception e) {
			System.out.println("Error -- " + e.toString()); // warning statement
		}
		return auto1;
	}

	public void serializable(Automobile o1, String textFile) {
		try {
			ObjectOutputStream serializer = new ObjectOutputStream(new FileOutputStream(textFile));
			serializer.writeObject(o1);
			serializer.close();
		} catch (Exception e) {
			System.out.println("Error -- " + e.toString());
		}
	}

	public Automobile deserialize(String textFile) {
		try {
			ObjectInputStream deser = new ObjectInputStream(new FileInputStream(textFile));
			Automobile o2 = (Automobile) deser.readObject();
			deser.close();
			return o2;
		} catch (Exception e) {
			System.out.println("Error -- " + e.toString());
			return null;
		}
	}
}
