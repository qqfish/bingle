package application.talking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import baseUse.IBTalkSystem;
import baseUse.bTalkData.FriendList;
import baseUse.bTalkData.MessageList;
import businessServices.bTalkSystem.BTalkProxy;

@WebServlet("/BTalkControlServlet")
public class BTalkControlServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BTalkControlServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		requestFriendList(username);
		sendMessage(username,request.getParameter("name"),request.getParameter("content"));
		getMessage(username);
		deleteFriend(username,request.getParameter("name"));
		addFriend(username,request.getParameter("name"));
	}

	/**
	 * The doPut method of the servlet. <br>
	 *
	 * This method is called when a HTTP put request is received.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Put your code here
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

	public void requestFriendList(String username){
		IBTalkSystem ibs = new BTalkProxy();
		try {
			FriendList fl = ibs.getFriendList(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String from, String to,String content){
		IBTalkSystem ibs = new BTalkProxy();
		try {
			ibs.sendMessage(from, to, content);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getMessage(String username){
		IBTalkSystem ibs = new BTalkProxy();
		MessageList ml = ibs.getMessage(username);
	}
	
	public void deleteFriend(String username,String friendname){
		IBTalkSystem ibs = new BTalkProxy();
		try {
			ibs.deleteFriend(username, friendname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addFriend(String username,String friendname){
		IBTalkSystem ibs = new BTalkProxy();
		try {
			ibs.addFriend(username, friendname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
