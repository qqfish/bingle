package application.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import baseUse.Global;
import baseUse.IUserData;
import baseUse.searchData.UserDetailInfo;
import businessServices.datamanager.userdata.UserDataProxy;

@WebServlet("/LoginControlServlet")
public class LoginControlServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public LoginControlServlet() {
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
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UserDetailInfo udi = null;
		HttpSession session = null;
		try {
			IUserData ud = new UserDataProxy();
			if(ud.confirmUser(userName, password)){
				udi = ud.getDetailUserInfo(userName);
				session = request.getSession();
				//groupName = udi.getGroupname();
				//age = udi.getAge();
				//address = udi.getAddress();
				//email = udi.getEmail();
				//gender = udi.getGender()?"Å®":"ÄÐ";
				//mind = udi.getMindStatus();
				//body = udi.getBodyStatus();
				//disease = udi.getUserDiseaseInfo().get(udi.getUserDiseaseInfo().size()-1).getDiseaseName();
				
				//request.setAttribute("username", userName);
				//request.setAttribute("groupname", groupName);
				//request.setAttribute("age", age);
				//request.setAttribute("address", address);
				//request.setAttribute("email", email);
				//request.setAttribute("gender", gender);
				//request.setAttribute("disease", disease);
				//request.setAttribute("mind", mind);
				//request.setAttribute("body", body);
				session.setAttribute("udi", udi);
				request.getRequestDispatcher("/jsp/info/selfInfo.jsp").forward(request, response);
			}
			else
				response.sendRedirect("error404.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
