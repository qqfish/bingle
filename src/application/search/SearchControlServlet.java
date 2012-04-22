package application.search;

import java.io.IOException;
import java.sql.SQLException;

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
	
	private Globalization g;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchControlServlet() {
		super();
		try {
			g = new Globalization();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	private void searchDisease(String keyword,HttpServletResponse response) {
		//g.diseaseData.searchDisease(keyword)
	}

	
	private void selectUser(int username,HttpServletResponse response) {
		// TODO: implement
	}

	private void selectDisease(String diseasename,HttpServletResponse response) {
		// TODO: implement
	}


	private void searchUser(String keyword,HttpServletResponse response) {
		// TODO: implement
	}

}
