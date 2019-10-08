package adapter;
/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 4 ( Lab4)
 *Due: 5/29/2018
 *date submitted: 5/29/2018
 */

import java.io.IOException;

import model.Automobile;

public interface CreateAuto {
	public void BuildAuto(String fileName, String k) throws IOException;

	public void printAuto(String modelName, String k);

	public Automobile getK(String key);
}
