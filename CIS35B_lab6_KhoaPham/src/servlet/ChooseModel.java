package servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebService("/start")
public class ChooseModel extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		Socket socket =null;
		
		try {
			socket = new Socket("192.158.1.65",1995);
		}catch (UnknownHostException e) {
			out.println("no host: taranis");
			System.exit(100);
		}catch (IOException e) {
			out.println("We have IO exception");
			System.exit(100);
		}
		
		Properties a = new Properties();
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		
		try {
			String modelReq = (String) input.readObject();
			String[] temp = modelReq.split("/");
			request.setAttribute("1", temp[0]);
			request.setAttribute("2", temp[0]);
			request.getRequestDispatcher("ChooseModel.jsp").forward(request, response);
		}catch(ClassNotFoundException a1) {
			a1.printStackTrace();
		}
		
		out.print(request.getParameter("submit"));
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request,response);
	}
}
