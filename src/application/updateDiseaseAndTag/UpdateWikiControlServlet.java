package application.updateDiseaseAndTag;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import baseUse.Global;
import baseUse.IWikiSystem;
import baseUse.searchData.DiseaseDetailInfo;
import baseUse.wikiData.DiseaseData;
import baseUse.wikiData.DiseaseDataList;
import baseUse.wikiData.TagData;
import baseUse.wikiData.TagDataList;
import businessServices.datamanager.diseasedata.DiseaseDataProxy;
import businessServices.datamanager.tagdata.TagDataProxy;
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
		getTag(request.getParameter("tagname"),request,response);
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
		String func = request.getParameter("func");
		if(func.equals("tag")){
			sendEditTag(request.getParameter("tagname"), request.getParameter("content"));
		}
		else if(func.equals("disease")){
			//sendEditDisease(request,response);
		}
		else
			response.sendRedirect("error404.jsp");
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

	public void sendEditDisease(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException{
		IWikiSystem iws = new WikiProxy();
		DiseaseDataProxy ddp = new DiseaseDataProxy();
		String diseasename = request.getParameter("diseasename");
		String content = request.getParameter("content");
		DiseaseDetailInfo ddl = ddp.getDiseaseDetail(diseasename);
		if(!ddl.getDiseaseIntro().equals(content))
			iws.sendEditDisease(new DiseaseData(diseasename, content, new Date(), 'c'));
		
	}

	public void getTag(String tagname,HttpServletRequest request, HttpServletResponse response){
		try {
			PrintWriter out = response.getWriter();
			TagDataProxy tdp = new TagDataProxy();		
			TagData td = tdp.getTagData(tagname,'n');
			JSONObject json = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			json.put("tagname", tagname);
			json.put("intro", td.getTagIntro());
			json.put("type", td.getType());
			for(int i=0;i<td.getAlterName().size();i++){
				jsonArray.add(td.getAlterName().get(i).getAlternateName());
			}
			json.element("altername", jsonArray);
			out.print(json.toString());
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendEditTag(String tagname,String content){
		IWikiSystem iws = new WikiProxy();
		TagData td;
		try {
			System.out.println(tagname);
			TagDataProxy tdp = new TagDataProxy();
			td = tdp.getTagData(tagname, 'n');
			//td = iws.getTagData(tagname);
			if(td.getTagIntro()!=content){
				td.setTagIntro(content);
				td.setStatus('c');
			}
			iws.sendEditTag(td);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
