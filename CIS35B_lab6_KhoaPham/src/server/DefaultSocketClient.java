package server;

/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 5 ( Lab5)
 *Due: 6/12/2018
 *date submitted: 6/13/2018
 */
import java.net.*;
import java.io.*;

public class DefaultSocketClient extends Thread implements SocketClientsConstance, SocketClientsInter {
	private ObjectInputStream reader;
	private ObjectOutputStream writer;
	private int iPort;
	private String strHost;
	private Socket sock;

	public DefaultSocketClient() {

	}

	public DefaultSocketClient(Socket s) {
		sock = s;
	}

	public DefaultSocketClient(String host, int port) {
		strHost = host;
		iPort = port;
	}

	public void run() {
		if (openConnection()) {
			handleSession();
			closeSession();
		}
	}

	/*
	 * try { sock = new Socket(strHost, iPort); } catch (IOException socketError) {
	 * if (DEBUG) { System.err.println("No Connecion to " + strHost); } return
	 * false; }
	 */
	public boolean openConnection() {
		try {
			writer = new ObjectOutputStream(sock.getOutputStream());
			reader = new ObjectInputStream(sock.getInputStream());
		} catch (IOException e) {
			if (DEBUG) {
				System.err.println("Unable to obtain stream to/from " + strHost);
			}
			return false;
		}
		return true;
	}

	public void handleSession() {
		String input = "";
		if (DEBUG) {
			System.out.println("Handling Seesion with " + strHost + ": " + iPort);
		}

		try {
			while ((input = (String) reader.readObject()) != null) {
				handleInput(input);
			}
		} catch (IOException e) {
			if (DEBUG) {
				System.out.println("fail to handle!");
			}
		} catch (ClassNotFoundException e) {
			if (DEBUG) {
				System.out.println("Fail to find class");
				e.printStackTrace();
			}
		}
	}

	private void handleInput(String input) {
		System.out.println(" " + input);
	}

	public void closeSession() {
		try {
			reader.close();
			writer.close();
			writer = null;
			reader = null;
			sock.close();
		} catch (IOException e) {
			if (DEBUG) {
				System.err.println("Fail to close the socket");
			}
		}
	}

	public void setHost(String host) {
		strHost = host;
	}

	public void setPort(int indexPort) {
		iPort = indexPort;
	}

	public void setSocket(Socket a) {
		sock = a;
	}

	public Socket getSocket() {
		return sock;
	}

	public String getHost() {
		return strHost;
	}

	public int getPort() {
		return iPort;
	}

	public void sendOutput(Object output) {
		try {
			writer.writeObject(output);
			writer.flush();
		} catch (IOException e) {
			System.out.println("Error writing to " + strHost);
			e.printStackTrace();
		}
	}

	public Object getOutput() {
		Object theObj = null;
		try {
			theObj = reader.readObject();
		} catch (IOException e) {
			System.out.println("Error getObject output");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return theObj;
	}
}
