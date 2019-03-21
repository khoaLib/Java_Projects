package util;

/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 1
 *Due: 04/24/2018
 *date submitted: 04/23/2018
 */
import model.*;
import java.io.*;

public class FileIO {
	private boolean DEBUG = false;

	public Automotive readFile(String fileName) {
		Automotive auto1 = new Automotive();
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
						auto1 = new Automotive(modelName, modelPrice, sizeOfOptionSet);
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

	public void serializable(Automotive o1, String textFile) {
		try {
			ObjectOutputStream serializer = new ObjectOutputStream(new FileOutputStream(textFile));
			serializer.writeObject(o1);
			serializer.close();
		} catch (Exception e) {
			System.out.println("Error -- " + e.toString());
		}
	}

	public Automotive deserialize(String textFile) {
		try {
			ObjectInputStream deser = new ObjectInputStream(new FileInputStream(textFile));
			Automotive o2 = (Automotive) deser.readObject();
			deser.close();
			return o2;
		} catch (Exception e) {
			System.out.println("Error -- " + e.toString());
			return null;
		}
	}
}
