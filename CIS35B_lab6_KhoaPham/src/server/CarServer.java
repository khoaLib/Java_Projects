package server;

/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 5 ( Lab5)
 *Due: 6/12/2018
 *date submitted: 6/13/2018
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.Properties;

import adapter.BuildAuto;
import model.Automobile;

public class CarServer {

	private ServerSocket serSocket = null;
	private Socket clientSocket = null;
	private DefaultSocketClient defaultSock = null;
	private static LinkedHashMap<String, Automobile> a1 = null;
	private int keyCount = 0;

	public CarServer(ServerSocket a) {
		serSocket = a;
	}

	// constructor constantiates Car
	public CarServer() {
		int port = 1995;
		a1 = new LinkedHashMap<String, Automobile>();
		clientSocket = new Socket();
		try {
			serSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.err.println("Could not listen to port: " + port);
			System.err.println(
					"Please turn off Eclipse and try to start it again!\n It should work.. \n closing the program...");
			System.exit(100);
		}
	}

	public ServerSocket getServerSocket() {
		return serSocket;
	}

	public void setServerSocket(ServerSocket ser) {
		serSocket = ser;
	}

	public void receiveAndProcess() {
		try {
			clientSocket = serSocket.accept();
			defaultSock = new DefaultSocketClient(clientSocket);
			defaultSock.openConnection();
		} catch (IOException e) {
			System.err.println("Fail to accept the socket from sever");
			System.exit(100);
		}
	}

	public void handleConnection() {
		Automobile au01 = new Automobile();
		BuildCarModelOptions buildACar = new BuildCarModelOptions();
		BuildAuto bAuto = new BuildAuto();

		while (true) {
			Object object = defaultSock.getOutput();
			// now we compare the class since the client will send a property type
			// .getClass() will return the class type of the Object such as String ,
			// properties
			Properties property = new Properties();
			if (property.getClass().equals(object.getClass())) {
				property = (Properties) object;
				au01 = buildACar.makeAuto(property);
				a1 = buildACar.addAutoToLHM(au01);
				keyCount += 1;

				// Test printing the automobile success!
				for (int i = 0; i < keyCount; i++) {
					a1.get(Integer.toString(i + 1)).printWithoutName();
				}
				// respond back to client
				defaultSock.sendOutput("ConfirmedUpload");
			} else {
				if (object.equals("Configure")) {
					String[] arrayOfModel = bAuto.arrayModel(keyCount);
					defaultSock.sendOutput(arrayOfModel);
				} else if (object.equals("Quit")) {
					defaultSock.closeSession();
					break;
				} else if (object.equals("NumberOfModel")) {
					defaultSock.sendOutput(keyCount);
				} else if (object.equals(1)) {
					defaultSock.sendOutput(a1.get(Integer.toString(1)));
				} else if (object.equals(2)) {
					defaultSock.sendOutput(a1.get(Integer.toString(2)));
				}
			}
		}
	}

	public void closeSever() {
		try {
			serSocket.close();
			// clientSocket.close();
		} catch (IOException e) {
			System.out.println("Fail to perform the closing progress");
			e.printStackTrace();
		}
	}
}
