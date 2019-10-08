package server;

/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 5 ( Lab5)
 *Due: 6/12/2018
 *date submitted: 6/13/2018
 */
import model.Automobile;

public interface AutoServer {
	public void addCreatedAutoToLHM(Automobile anAuto);

	public String[] arrayModel(int index);
}
