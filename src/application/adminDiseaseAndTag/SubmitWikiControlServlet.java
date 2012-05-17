package application.adminDiseaseAndTag;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseUse.IWikiSystem;
import baseUse.wikiData.DiseaseDataList;
import baseUse.wikiData.TagDataList;
import businessServices.wikiSystem.WikiProxy;

/**
 * Servlet implementation class SubmitWikiControlServlet
 */
@WebServlet("/SubmitWikiControlServlet")
public class SubmitWikiControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TagDataList tagResult;

	private DiseaseDataList diseaseResult;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubmitWikiControlServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("type").equals("disease")) {
			getDiseaseList(request, response);
		} else if (request.getParameter("type").equals("tag")) {
			getTagList(request, response);
		} else {
			String address = "error404.jsp";
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			if (request.getParameter("submitTag") != null) {
				submitTag(request, response);
			} else if (request.getParameter("submitDisease") != null) {
				submitDisease(request, response);
			} else {
				String address = "index.jsp";
				RequestDispatcher dispatcher = request
						.getRequestDispatcher(address);
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * @pdOid 04925bd6-7f30-4beb-8a42-d3ff1268d2c9
	 */
	public void getTagList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (tagResult == null) {
			IWikiSystem itf = new WikiProxy();
			tagResult = itf.showTagList();
		}
		request.setAttribute("result", tagResult);

		String address = "jsp/wiki/adminWikiDisease.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * @pdOid 82235467-6cc1-4aa1-9ab7-196100e87181
	 */
	public void getDiseaseList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (diseaseResult == null) {
			IWikiSystem itf = new WikiProxy();
			diseaseResult = itf.showDiseaseList();
		}
		request.setAttribute("result", diseaseResult);

		String address = "jsp/wiki/adminWikiTag.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @throws SQLException
	 * @pdOid 07c32454-0d51-42ac-aa16-a671f5c886df
	 */
	public void submitTag(HttpServletRequest request,
			HttpServletResponse response) throws SQLException {
		String[] order = request.getParameterValues("submitTag");
		TagDataList submitResult = new TagDataList();
		for (int i = 0; i < order.length; i++) {
			submitResult.addTagData(tagResult.getTag().get(
					Integer.parseInt(order[i])));
		}
		tagResult = null;
		IWikiSystem itf = new WikiProxy();
		itf.submitTag(submitResult);
	}

	/**
	 * @throws SQLException
	 * @pdOid 98695eda-5e8b-4dc3-bb01-5c910fc07d1f
	 */
	public void submitDisease(HttpServletRequest request,
			HttpServletResponse response) throws SQLException {
		String[] order = request.getParameterValues("submitDisease");
		DiseaseDataList submitResult = new DiseaseDataList();
		for (int i = 0; i < order.length; i++) {
			submitResult.addDisease(diseaseResult.getDisease().get(
					Integer.parseInt(order[i])));
		}
		diseaseResult = null;
		IWikiSystem itf = new WikiProxy();
		itf.submitDisease(submitResult);
	}

}
