package driverclient;

/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 5 ( Lab5)
 *Due: 6/12/2018
 *date submitted: 6/13/2018
 */
import client.CarClient;

public class driverclient {

	public static void main(String[] args) {
		CarClient c = new CarClient();
		c.processClient();
		c.closeClient();

	}

}
