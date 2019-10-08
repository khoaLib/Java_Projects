package server;

/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 5 ( Lab5)
 *Due: 6/12/2018
 *date submitted: 6/13/2018
 */
import java.util.LinkedHashMap;
import java.util.Properties;

import adapter.BuildAuto;
import model.Automobile;
import util.FileIO;

public class BuildCarModelOptions implements AutoServer {
	// step a, receive and accept the object from clientsocket over an ObjectStream
	// then create automobile
	public Automobile makeAuto(Properties prop) {
		Automobile autoA1 = new Automobile();
		FileIO r = new FileIO();
		autoA1 = r.readProperty(prop);
		return autoA1;
	}

	// step b, add the Automobile we made to LHM
	public LinkedHashMap<String, Automobile> addAutoToLHM(Automobile autoA1) {
		BuildAuto buildAu = new BuildAuto();
		buildAu.addCreatedAutoToLHM(autoA1);
		return buildAu.getLHM();
	}

	public void addCreatedAutoToLHM(Automobile anAuto) {

	}

	@Override
	public String[] arrayModel(int index) {
		// TODO Auto-generated method stub
		return null;
	}
}
