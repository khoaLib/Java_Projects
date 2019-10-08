package driver;

/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 4 ( Lab4)
 *Due: 5/29/2018
 *date submitted: 5/29/2018
 */

import adapter.*;
import scale.Scalable;

public class Driver {

	public static void main(String[] args) {
		CreateAuto auto01 = new BuildAuto();
		auto01.BuildAuto("C:\\Users\\hp\\eclipse-workspace\\CIS35B_Lab3_ KhoaPham\\src\\inputText.txt", "1");
		String[] dataArr = { "Color", "Grabber Green", "SuperGreenTea", "1" };
		String[] priceArr = { "Transmission", "0", "100", "1" };
		String[] priceArr1 = { "Color", "0", "100", "1" };
		String[] wrongSizeArr= {"1"};
		Scalable e = new BuildAuto();

		e.setUpUpdateData(0, dataArr);
		e.setUpUpdateData(1, priceArr);
		e.setUpUpdateData(3, priceArr1);
		e.setUpUpdateData(1, priceArr1);
		e.setUpUpdateData(0, wrongSizeArr);
		auto01.printAuto("Focus Wagon ZTW", "1");

	}
}

/*
 * FileIO file = new FileIO(); Automobile au1 = file.
 * readFile("C:\\Users\\hp\\eclipse-workspace\\CIS35B_Lab3_ KhoaPham\\src\\inputText.txt"
 * ); // au1.print();
 * 
 * LinkedHashMap<String, Automobile> mapAuto = new LinkedHashMap<String,
 * Automobile>(); System.out.println(mapAuto.size());
 * 
 * mapAuto.put("m1", au1); mapAuto.put("m2", au1); mapAuto.put("m3", au1);
 * System.out.println(mapAuto.size()); System.out.println(mapAuto);
 * mapAuto.get("m1").setMake("Ford"); mapAuto.get("m1").setModel("Flying Cat");
 * mapAuto.remove("m3"); System.out.println(mapAuto.size());
 * 
 * try { // show based price before nay caculation
 * System.out.println("Base Price: " + mapAuto.get("m1").getBasePrice()); // add
 * 2 choice for m1 mapAuto.get("m1").setoptionChoice("Color", "French Blue");
 * System.out.println("Choice name: " +
 * mapAuto.get("m1").getOptionChoiceName("Color"));
 * System.out.println("Choice Price: " +
 * mapAuto.get("m1").getOptionChoicePrice("Color"));
 * 
 * mapAuto.get("m1").setoptionChoice("Transmission", "standard");
 * 
 * System.out.println("Total price of m1: " +
 * mapAuto.get("m1").getTotalPrice());
 * 
 * // add 2 choices for m2 and an expected error from printing "m3" after it was
 * // deleted mapAuto.get("m2").setoptionChoice("Brakes/Traction Control",
 * "ABS"); System.out.println("Choice name: " +
 * mapAuto.get("m1").getOptionChoiceName("Brakes/Traction Control"));
 * System.out.println("Choice Price: " +
 * mapAuto.get("m1").getOptionChoicePrice("Brakes/Traction Control"));
 * 
 * mapAuto.get("m2").setoptionChoice("Power Moonroof", "selected");
 * 
 * // print basePrice System.out.println("Base Price: " +
 * mapAuto.get("m1").getBasePrice());
 * 
 * // print total price of all the choices and the base price
 * System.out.println("Total price of m2: " +
 * mapAuto.get("m2").getTotalPrice()); System.out.println("Total price of m2: "
 * + mapAuto.get("m3").getTotalPrice());
 * 
 * } catch (NullPointerException e) {
 * System.out.println("There is error on mapping"); }
 * 
 */
