package application.updateSelfInfo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import baseUse.IUserData;
import baseUse.searchData.UserDetailInfo;
import businessServices.datamanager.userdata.UserDataProxy;

@WebServlet("/UpdateInfoControlServlet")
public class UpdateInfoControlServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public UpdateInfoControlServlet() {
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
		String type = (String) request.getAttribute("type");
		if(type == null){
			type = request.getParameter("type");
		}
		try{
			if(session.getAttribute("udi") == null){
				getInfo(request, response);
			}
			
			if(type == null){
				response.sendRedirect("error404.jsp");
			}
			else{
				if(type.equals("login") || type.equals("mainPage")){
					mainPage(request, response);
				}
				else if(type.equals("disease")){
					diseasePage(request, response);
				}
				else{
					response.sendRedirect("error404.jsp");
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
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
	
	private void getInfo(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		IUserData ud;
		ud = new UserDataProxy();
		UserDetailInfo udi = ud.getDetailUserInfo(username);
		session.setAttribute("udi", udi);
	}
	
	private void mainPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/jsp/info/selfInfo.jsp").forward(request, response);
	}
	
	private void diseasePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/jsp/info/userDisease.jsp").forward(request, response);
	}
	
	private void updateBaseInfo(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		IUserData itf = new UserDataProxy();
		String username = request.getParameter("username");
		short age = Short.valueOf(request.getParameter("age"));
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		itf.updateUserInfo(username, age, address, email);
	}
	
	private void editUserDisease(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		IUserData itf = new UserDataProxy();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String diseasename = request.getParameter("diseasename");
		String treatmentIntro = request.getParameter("treatmentIntro");
		String reason = request.getParameter("reason");
		String tips = request.getParameter("tips");
		itf.editUserDisease(username, diseasename, treatmentIntro, reason, tips);
	}
	
	private void deleteUserDisease(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		IUserData itf = new UserDataProxy();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String diseasename = request.getParameter("diseasename");
		itf.deleteUserDisease(username, diseasename);
	}
	
	private void addUserDisease(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		IUserData itf = new UserDataProxy();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String diseasename = request.getParameter("diseasename");
		String treatmentIntro = request.getParameter("treatmentIntro");
		String reason = request.getParameter("reason");
		String tips = request.getParameter("tips");
		itf.addUserDisease(username, diseasename, treatmentIntro, reason, tips);
	}
	
	private void addUserTag(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		IUserData itf = new UserDataProxy();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String tagname = request.getParameter("tagname");
		List<String> tag = new ArrayList<String>();
		tag.add(tagname);
		itf.addTag(username, tag);
	}
	
	private void deleteUserTag(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		IUserData itf = new UserDataProxy();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String tagname = request.getParameter("tagname");
		List<String> tag = new ArrayList<String>();
		tag.add(tagname);
		itf.deleteTag(username, tag);
	}
	
	private void addUserDiseaseDrug(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		IUserData itf = new UserDataProxy();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String diseasename = request.getParameter("diseasename");
		String drugname = request.getParameter("drugname");
		List<String> drug = new ArrayList<String>();
		drug.add(drugname);
		itf.addUserDiseaseDrug(username, diseasename, drug);
	}
	
	private void deleteUserDiseaseDrug(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		IUserData itf = new UserDataProxy();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String diseasename = request.getParameter("diseasename");
		String drugname = request.getParameter("drugname");
		List<String> drug = new ArrayList<String>();
		drug.add(drugname);
		itf.deleteUserDiseaseDrug(username, diseasename, drug);
	}

}
