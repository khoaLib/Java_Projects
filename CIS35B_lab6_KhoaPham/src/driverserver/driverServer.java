package driverserver;

/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 5 ( Lab5)
 *Due: 6/12/2018
 *date submitted: 6/13/2018
 */
import server.CarServer;

public class driverServer {

	public static void main(String[] args) {
		CarServer createNewServer = new CarServer();
		createNewServer.receiveAndProcess();
		createNewServer.handleConnection();
		createNewServer.closeSever();
	}

}
