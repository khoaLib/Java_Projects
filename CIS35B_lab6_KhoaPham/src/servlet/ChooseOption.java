package servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChooseOption extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Socket socket =null;
		PrintWriter outprint = response.getWriter();
		try {
			socket = new Socket("192.168.1.65", 1995);
		}catch(UnknownHostException e){
			outprint.println("Don't know the host");
			System.exit(100);
		}catch(IOException e) {
			outprint.println("COuldn;t get Io exception");
			System.exit(100);
		}
		
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
	}
	
	//String choice = request.get
}
