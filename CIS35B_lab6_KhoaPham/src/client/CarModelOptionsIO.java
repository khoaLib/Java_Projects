package client;
/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 5 ( Lab5)
 *Due: 6/12/2018
 *date submitted: 6/13/2018
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CarModelOptionsIO {
	public Properties readProper(String namefile) {
		Properties proper = new Properties();

		// try to load the data in the properties upload
		try {
			FileInputStream input = new FileInputStream(namefile);
			proper.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return proper;
	}
}
