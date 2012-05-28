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

import baseUse.ITagData;
import baseUse.IUserData;
import baseUse.searchData.UserDetailInfo;
import businessServices.datamanager.tagdata.TagDataProxy;
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
			System.out.println(type);
			if(type == null){
				response.sendRedirect("error404.jsp");
			}
			else{
				if(type.equals("login") || type.equals("mainPage")){
					mainPage(request, response);
				}
				else if(type.equals("baseInfo")){
					updateBaseInfo(request, response);
				}
				else if(type.equals("disease")){
					diseasePage(request, response);
				}
				else if(type.equals("normalTag")){
					normalTag(request, response);
				}
				else if(type.equals("updateDisease")){
					editUserDisease(request,response);
				}
				else if(type.equals("deleteNormalTag")){
					deleteUserTag(request,response);
				}
				else if(type.equals("addNormalTag")){
					addUserTag(request, response);
				}
				else if(type.equals("addFriend")){
					addFriend(request, response);
				}
				else if(type.equals("deleteFriend")){
					deleteFriend(request, response);
				}
				else if(type.equals("addUserDisease")){
					addUserDisease(request, response);
				}
				else if(type.equals("deleteUserDisease")){
					deleteUserDisease(request, response);
				}
				else if(type.equals("updateDiseaseDrug")){
					updateDiseaseDrug(request, response);
				}
				else if(type.equals("deleteDiseaseDrug")){
					deleteDiseaseDrug(request, response);
				}
				else if(type.equals("addDiseaseDrug")){
					addDiseaseDrug(request, response);
				}
				else if(type.equals("body")){
					updateBodyStatus(request,response);
				}
				else if(type.equals("mind")){
					updateMindStatus(request,response);
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
	
	private void normalTag(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		ITagData itf = new TagDataProxy();
		List<String> normalTag = itf.searchTagName("", 'N');
		request.setAttribute("normalTag", normalTag);
		for(int i = 0; i < normalTag.size(); i++){
			System.out.println(normalTag.get(i));
		}
		
		request.getRequestDispatcher("/jsp/info/normalTag.jsp").forward(request, response);
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
	
	private void updateBaseInfo(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		IUserData itf = new UserDataProxy();
		String username = (String) request.getSession().getAttribute("username");
		short age = Short.valueOf(request.getParameter("age"));
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		itf.updateUserInfo(username, age, address, email);
		
		getInfo(request,response);
		
		mainPage(request, response);
	}
	
	private void editUserDisease(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		IUserData itf = new UserDataProxy();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String diseasename = request.getParameter("diseasename");
		String treatmentIntro = request.getParameter("treatment");
		String reason = request.getParameter("reason");
		String tips = request.getParameter("tips");
		System.out.println(diseasename + " " + treatmentIntro + " " + reason);
		itf.editUserDisease(username, diseasename, treatmentIntro, reason, tips);
		
		getInfo(request,response);
		
		diseasePage(request, response);
	}
	
	private void deleteUserDisease(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		IUserData itf = new UserDataProxy();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String diseasename = request.getParameter("diseasename");
		itf.deleteUserDisease(username, diseasename);
		
		getInfo(request, response);
		
		diseasePage(request, response);
	}
	
	private void addUserDisease(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		IUserData itf = new UserDataProxy();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String diseasename = request.getParameter("diseasename");
		itf.addUserDisease(username, diseasename, "", "", "");
		
		getInfo(request, response);
		
		String url ="/SearchControlServlet?diseasename=" + diseasename;
		System.out.println(url);
		
		request.getRequestDispatcher(url).forward(request, response);		
		
	}
	
	private void addUserTag(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		IUserData itf = new UserDataProxy();
		HttpSession session = request.getSession();
		UserDetailInfo tmp = (UserDetailInfo) session.getAttribute("udi");
		List<String> currentTag = tmp.getTags();
		String username = (String) session.getAttribute("username");
		String tagname = request.getParameter("tagname");
		if(!currentTag.contains(tagname)){
			List<String> tag = new ArrayList<String>();
			tag.add(tagname);
			itf.addTag(username, tag);
		}
		
		getInfo(request,response);
		
		normalTag(request,response);
		
	}
	
	private void deleteUserTag(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		IUserData itf = new UserDataProxy();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String tagname = request.getParameter("tagname");
		List<String> tag = new ArrayList<String>();
		tag.add(tagname);
		itf.deleteTag(username, tag);
		
		getInfo(request,response);
		
		normalTag(request,response);
		
		
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
	
	private void addFriend(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		IUserData itf = new UserDataProxy();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String friendname = request.getParameter("friendname");
		
		itf.addFriend(username, friendname);
		String url = request.getParameter("url");
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	private void deleteFriend(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		IUserData itf = new UserDataProxy();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String friendname = request.getParameter("friendname");
		
		itf.deleteFriend(username, friendname);
	}
	
	private void updateDiseaseDrug(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		String diseasenum = request.getParameter("diseasenum");
		request.setAttribute("diseasenum", diseasenum);
		
		ITagData itf = new TagDataProxy();
		List<String> drug = itf.searchTagName("",'D');
		request.setAttribute("drug", drug);
		UserDetailInfo udi = (UserDetailInfo) request.getSession().getAttribute("udi");
		System.out.println(udi.getUserDiseaseInfo().get(Integer.valueOf(diseasenum)).getDrugName());
		//System.out.println(drug);
		request.getRequestDispatcher("/jsp/info/diseaseTag.jsp").forward(request, response);
	}
	
	private void deleteDiseaseDrug(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		IUserData itf = new UserDataProxy();
		String username = (String) request.getSession().getAttribute("username");
		UserDetailInfo udi = (UserDetailInfo) request.getSession().getAttribute("udi");
		int diseasenum = Integer.valueOf(request.getParameter("diseasenum"));
		String diseasename = udi.getUserDiseaseInfo().get(diseasenum).getDiseaseName();
		String drug = request.getParameter("drugname");
		List<String> drugname = new ArrayList();
		drugname.add(drug);
		itf.deleteUserDiseaseDrug(username, diseasename, drugname);
		
		getInfo(request, response);
		
		updateDiseaseDrug(request, response);
		
	}
	
	private void addDiseaseDrug(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		IUserData itf = new UserDataProxy();
		String username = (String) request.getSession().getAttribute("username");
		UserDetailInfo udi = (UserDetailInfo) request.getSession().getAttribute("udi");
		int diseasenum = Integer.valueOf(request.getParameter("diseasenum"));
		String diseasename = udi.getUserDiseaseInfo().get(diseasenum).getDiseaseName();
		String drug = request.getParameter("drugname");
		List<String> drugname = new ArrayList();
		drugname.add(drug);
		itf.addUserDiseaseDrug(username, diseasename, drugname);
		
		getInfo(request, response);
		
		updateDiseaseDrug(request, response);	
	}
	
	private void updateBodyStatus(HttpServletRequest request, HttpServletResponse response){
		IUserData itf;
		try {
			itf = new UserDataProxy();
			String username = (String) request.getSession().getAttribute("username");
			int rate = Integer.parseInt(request.getParameter("rate"));
			if(itf.getDetailUserInfo(username).getBodyStatus()%10 == 0){
				itf.updateBodyStatus(username, rate);
			}
			getInfo(request,response);
			mainPage(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void updateMindStatus(HttpServletRequest request, HttpServletResponse response){
		IUserData itf;
		try {
			itf = new UserDataProxy();
			String username = (String) request.getSession().getAttribute("username");
			int rate = Integer.parseInt(request.getParameter("rate"));
			if(itf.getDetailUserInfo(username).getMindStatus() % 10 == 0){
				itf.updateMindStatus(username, rate);
			}
			getInfo(request,response);
			mainPage(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

