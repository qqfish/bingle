package application.updateDiseaseAndTag;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import baseUse.Global;
import baseUse.IWikiSystem;
import baseUse.wikiData.DiseaseDataList;
import baseUse.wikiData.TagData;
import baseUse.wikiData.TagDataList;
import businessServices.wikiSystem.WikiProxy;

@WebServlet("/UpdateWikiControlServlet")
public class UpdateWikiControlServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public UpdateWikiControlServlet() {
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
		System.out.println(request.getParameter("tagname"));
		try {
			getTag(request.getParameter("tagname"),request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		submitEditDisease();
		try {
			getTag(request.getParameter("tagname"),request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		submitEditTag();
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

	public void submitEditDisease(){
		IWikiSystem iws = new WikiProxy();
		DiseaseDataList ddl = null;
		try {
			iws.submitDisease(ddl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getTag(String tagname,HttpServletRequest request, HttpServletResponse response) throws SQLException{
		IWikiSystem iws = new WikiProxy();
		TagData td = iws.getTagData(tagname,'N');		
		try {
			PrintWriter out = response.getWriter();
			JSONObject json = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			json.put("intro", td.getTagIntro());
			json.put("type", td.getType());
			for(int i=0;i<td.getAlterName().size();i++){
				jsonArray.add(td.getAlterName().get(i).getAlternateName());
			}
			json.element("altername", jsonArray);
			out.print(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void submitEditTag(){
		IWikiSystem iws = new WikiProxy();
		TagDataList td = null;
		try {
			iws.submitTag(td);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
