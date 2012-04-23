package application.search;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import baseUse.*;

/**
 * Servlet implementation class SearchControlServlet
 */
@WebServlet("/SearchControlServlet")
public class SearchControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchControlServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	private void searchDisease(HttpServletRequest request,
			HttpServletResponse response) throws SQLException {
		String keyword = request.getParameter("searchDisease");
		DiseaseShortInfoList result = Global.iDiseaseData().searchDisease(
				keyword);
		request.setAttribute("result", result);
		
		//String address = 
		RequestDispatcher dispatcher = request.getRequestDispatcher("123");
	}

	private void selectUser(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO: implement
	}

	private void selectDisease(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO: implement
	}

	private void searchUser(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO: implement
	}

}
