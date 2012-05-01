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
import baseUse.searchData.DiseaseDetailInfo;
import baseUse.searchData.DiseaseShortInfoList;
import baseUse.searchData.UserDetailInfo;
import baseUse.searchData.UserShortInfo;
import baseUse.searchData.UserShortInfoList;
import businessServices.searchSystem.SearchSystemProxy;

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
		try {
			if (request.getParameter("searchType") != null) {
				if (request.getParameter("searchType").equals("diseases")) {
					searchDisease(request, response);
				} else if (request.getParameter("searchType").equals("patients")) {
					searchUser(request, response);
				}
			} else if (request.getParameter("diseasename") != null) {
				selectDisease(request, response);
			} else if (request.getParameter("username") != null) {
				selectUser(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	private void searchDisease(HttpServletRequest request,
			HttpServletResponse response) throws SQLException,
			ServletException, IOException, ClassNotFoundException {
		ISearchSystem itf = new SearchSystemProxy();
		String keyword = request.getParameter("keyword");
		if(keyword == null){
			keyword = "";
		}
		DiseaseShortInfoList result;

		String website = "http://localhost:8080/bingle";
		String currentWeb = website + "/SearchControlServlet?searchType=" + request.getParameter("searchType") + "&keyword=" + keyword;
		int perPage = 25;
		int page;

		if (request.getParameter("page") != null) {
			page = Integer.getInteger(request.getParameter("page"));
			if(page > 0){
				result = itf.searchDisease(keyword, page, perPage);
			}
			else{
				page = 1;
				result = itf.searchDisease(keyword, 1, perPage);
			}
		} else {
			page = 1;
			result = itf.searchDisease(keyword, 1, perPage);
		}
		
		int num = result.getNum();
		if(num > 0){
			String table = "";
			for (int i = 0; i < result.getDiseaseResult().size(); i++) {
				table = table + "<tr class='search-result'>";
				table = table + "<td><a href='" + website
						+ "/SearchControlServlet?diseasename="
						+ result.getDiseaseResult().get(i).getDiseasename() + "'>"
						+ result.getDiseaseResult().get(i).getDiseasename() + "</a></td>";
				table = table + "<td>";
				for(int j = 0 ; j < result.getDiseaseResult().get(i).getTagname().size(); j++){
					table = table +"<div class='tag'><a href='#'>" + result.getDiseaseResult().get(i).getTagname().get(j) + "</a></div>";
				}
				table = table + "</td>";
			}
			request.setAttribute("table", table);
		}
		else{
			request.setAttribute("table", "<p>没有匹配信息</p>");
		}
		//nav		
		int pageNum = num / perPage + 1;
		boolean point = false;
		String nav = "";
					
		if(page == 1){
			nav = nav + "<span class='disabled'><=</span>";
		}else{
			nav = nav + "<span href='" +	currentWeb + "&page=" + String.valueOf(page - 1) + "' class='frontPage'><=</span>";
		}
		for(int i = 1; i < pageNum + 1; i++){
			if(i < 3 || (i - page < 2 && page - i < 2) || pageNum - i < 3){
				if(i == page){
					nav = nav + "<span class='current'>" + page + "</span>";
					point = false;
				}
				else{
					nav = nav + "<a href='" + currentWeb + "&page=" + i + "'>" + i + "</a>";
					point = false;
				}
			}
			else if(!point){
				nav = nav + "<span class='gap'>...</span>";
				point = true;
			}
		}
		if(page == pageNum){
			nav = nav + "<span class='disabled'>=></span>";
		}else{
			nav = nav + "<span href='" +	currentWeb + "&page=" + String.valueOf(page + 1) + "' class='frontPage'>=></span>";
		}
		
		request.setAttribute("nav", nav);
		request.setAttribute("total", num);

		String address = "jsp/search/searchDisease.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	private void selectUser(HttpServletRequest request,
			HttpServletResponse response) throws SQLException,
			ServletException, IOException, ClassNotFoundException {
		ISearchSystem itf = new SearchSystemProxy();
		String username = request.getParameter("username");
		UserDetailInfo result = itf.getDetailUserInfo(username);
		request.setAttribute("result", result);
		
		//tag
		String tag = "";
		for(int i = 0; i < result.getTags().size(); i++){
			tag = tag + "<div class='tag'>" + result.getTags().get(i) + "</div>";
		}
		request.setAttribute("tag", tag);
		
		String address = "jsp/search/userDetail.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	private void selectDisease(HttpServletRequest request,
			HttpServletResponse response) throws SQLException,
			ServletException, IOException, ClassNotFoundException {
		ISearchSystem itf = new SearchSystemProxy();
		String diseasename = request.getParameter("diseasename");
		DiseaseDetailInfo result = itf.getDiseaseDetail(diseasename);
		request.setAttribute("result", result);

		String address = "jsp/search/diseaseDetail.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	private void searchUser(HttpServletRequest request,
			HttpServletResponse response) throws SQLException,
			ServletException, IOException, ClassNotFoundException {
		ISearchSystem itf = new SearchSystemProxy();
		String keyword = request.getParameter("keyword");
		if(keyword == null){
			keyword = "";
		}
		UserShortInfoList result;

		String website = "http://localhost:8080/bingle";
		String currentWeb = website + "/SearchControlServlet?searchType=" + request.getParameter("searchType") + "&keyword=" + keyword;
		int perPage = 25;
		int page;

		if (request.getParameter("page") != null) {
			page = Integer.getInteger(request.getParameter("page"));
			if(page > 0){
				result = itf.searchUser(keyword, page, perPage);
			}
			else{
				page = 1;
				result = itf.searchUser(keyword, 1, perPage);
			}
		} else {
			page = 1;
			result = itf.searchUser(keyword, 1, perPage);
		}
		
		int num = result.getNum();
		if(num > 0){
		String table = "";
			for (int i = 0; i < result.getUserResult().size(); i++) {
				UserShortInfo current = result.getUserResult().get(i); 
				//username
				table = table + "<tr class='search-result'>";
				table = table + "<td><a href='" + website
						+ "/SearchControlServlet?username="
						+ current.getUsername() + "'>"
						+ current.getUsername() + "</a></td>";
				//gender
				if(current.getGender()){
					table += "<td>female</td>";
				}else{
					table += "<td>male</td>";
				}
				//age
				table = table + "<td>" + current.getAge() + "</td>";
				//currentDisease
				table = table + "<td>" + current.getCurrentDisease() + "</td>";
				//tag
				table = table + "<td>";
				for(int j = 0 ; j < current.getTagname().size(); j++){
					table = table + "<div class='tag'><a href='#'>"+ current.getTagname().get(j) + "</a></div>";
				}
				table = table + "</td>";
			}
			request.setAttribute("table", table);
		}
		else{
			request.setAttribute("table","<p>没有匹配的信息</p>");
		}
		//nav
		int pageNum = num / perPage + 1;
		boolean point = false;
		String nav = "";
					
		if(page == 1){
			nav = nav + "<span class='disabled'><=</span>";
		}else{
			nav = nav + "<span href='" +	currentWeb + "&page=" + String.valueOf(page - 1) + "' class='frontPage'><=</span>";
		}
		for(int i = 1; i < pageNum + 1; i++){
			if(i < 3 || (i - page < 2 && page - i < 2) || pageNum - i < 3){
				if(i == page){
					nav = nav + "<span class='current'>" + page + "</span>";
					point = false;
				}
				else{
					nav = nav + "<a href='" + currentWeb + "&page=" + i + "'>" + i + "</a>";
					point = false;
				}
			}
			else if(!point){
				nav = nav + "<span class='gap'>...</span>";
				point = true;
			}
		}
		if(page == pageNum){
			nav = nav + "<span class='disabled'>=></span>";
		}else{
			nav = nav + "<span href='" +	currentWeb + "&page=" + String.valueOf(page + 1) + "' class='frontPage'>=></span>";
		}
		
		request.setAttribute("nav", nav);
		request.setAttribute("total", num);
		

		String address = "jsp/search/searchUser.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

}
