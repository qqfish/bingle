package application.visitForum;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import baseUse.*;
import baseUse.forumData.ForumList;
import baseUse.forumData.TopicDetail;
import baseUse.forumData.TopicListDetail;
import businessServices.forumSystem.ForumProxy;

@WebServlet("/ForumControlServlet")
public class ForumControlServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public ForumControlServlet() {
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
		this.doPost(request, response);
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
		if(func.equals("ini"))
			getForumList(request,response);
		else if(func.equals("topicList")){
			getTopicList(request.getParameter("topic"),request,response);
		}
		else if(func.equals("topic")){	
			getTopic(Integer.parseInt(request.getParameter("id")),request,response);
		}
		else if(func.equals("newtopicpage")){
			HttpSession session = request.getSession();
			LastPageBean lpb = new LastPageBean();
			String url = request.getContextPath() + request.getServletPath() + "?func=topicList&topic=";
			TopicListDetail tld = (TopicListDetail) session.getAttribute("tld");
			url += tld.getTopicListName();
			lpb.setUrl(url);
			session.setAttribute("lpb", lpb);
			request.setAttribute("user", request.getParameter("user"));
			request.setAttribute("list", request.getParameter("list"));
			request.getRequestDispatcher("/jsp/forum/post.jsp").forward(request, response);
		}
		else if(func.equals("newtopic")){
			newTopic(request.getParameter("tittle"),request.getParameter("user"),request.getParameter("content"),
					request.getParameter("list"),request,response);
		}
		else if(func.equals("reply")){
			HttpSession session = request.getSession();
			LastPageBean lpb = new LastPageBean();
			String url = request.getContextPath() + request.getServletPath() + "?func=topic&id=";
			TopicDetail td = (TopicDetail) session.getAttribute("td");
			url += td.getTopicId();
			lpb.setUrl(url);
			request.setAttribute("user", request.getParameter("user"));
			request.setAttribute("id", request.getParameter("id"));
			request.setAttribute("listname", request.getParameter("listname"));
			request.setAttribute("name", request.getParameter("name"));
			session.setAttribute("lpb", lpb);
			request.getRequestDispatcher("/jsp/forum/reply.jsp").forward(request, response);
		}
		else if(func.equals("newreply")){
			newReply(request.getParameter("content"),Integer.parseInt(request.getParameter("id")),request.getParameter("user"),request,response);
		}
		else if(func.equals("/ViewTopicPageEditReply"))
			editReply(Integer.parseInt(request.getParameter("")),Integer.parseInt(request.getParameter("")),request.getParameter(""));
		else if(func.equals("/TopicListPageDeleteTopic"))
			deleteTopic(Integer.parseInt(request.getParameter("")),request.getParameter(""));
		else if(func.equals("/ViewTopicPageDeleteReply"))
			deleteReply(Integer.parseInt(request.getParameter("")),Integer.parseInt(request.getParameter("")));
	
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
	
	void getTopicList(String topicListName,HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			IForumSystem fp = new ForumProxy( );
			TopicListDetail tld = fp.getTopicList(topicListName);
			String table = "";
			for(int i =0;i < tld.getTopicNum();i++){
				table += "<article class='group'><ul class='group'><li class='date'>" + tld.getTopicInfo().get(i).getFirstEditTime()
						+ "</li><li class='posttitle'><header><a href='ForumControlServlet?func=topic&id=" +
						+ tld.getTopicInfo().get(i).getTopicId() + "'>" + tld.getTopicInfo().get(i).getTopicName()
						+ "</a></header></li><li class='comments'><a href='ForumControlServlet?func=topic&id=" + tld.getTopicInfo().get(i).getTopicId()
						+ "'>"+ (tld.getTopicInfo().get(i).getReplyNum()-1) + "Comments</a></li></ul></article>";
			}
			session.setAttribute("table", table);
			session.setAttribute("tld",tld);
			request.getRequestDispatcher("/jsp/forum/topicList.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void editReply(int replyId,int topicId,String content){
		try {
			IForumSystem fp = new ForumProxy( );
			fp.editRelpy(replyId, topicId, content);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void deleteTopic(int topicId,String listName){
		try {
			IForumSystem fp = new ForumProxy( );
			fp.deleteTopic(topicId, listName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void getTopic(int topicId, HttpServletRequest request, HttpServletResponse response){
		try {
			IForumSystem fp = new ForumProxy( );
			TopicDetail td = fp.getTopic(topicId);
			String table="<th class='number'>查看:"+td.getViewNum()+"| 回复:" + (td.getReplyNum()-1) + "</th><th class='title'>"+
					td.getTopicName() + "</th>";
			for(int i=0;i < td.getReply().size();i++){
				table += "<tr class='text'><td class='left'><p class='name'>" + td.getReply().get(i).getAuthor() 
						+ "</p><hr>" + (i+1) + "楼</td>" + "<td class='right'><p class='time'>发表于: " 
						+ td.getReply().get(i).getEditTime() + "<hr></p>" + td.getReply().get(i).getContent() + "</td></tr>";
			}
			request.setAttribute("table", table);
			HttpSession session = request.getSession();
			session.setAttribute("td", td);
			request.getRequestDispatcher("/jsp/forum/topic.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void getForumList(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			IForumSystem fp = new ForumProxy( );
			ForumList fl = fp.getForumList();
			String table ="";
			for(int i =0;i<fl.getForumList().size();i++){
				if(i%2 == 0)
					table += "<tr>";
				table += "<td class='list'><img src='/bingle/img/list.jpg'/></td><td class='textList'>"
						+ "<a href='ForumControlServlet?func=topicList&topic=" + fl.getForumList().get(i).getTopicListName()
						+ "'>" + fl.getForumList().get(i).getTopicListName() + "</a><br/>"
						+ fl.getForumList().get(i).getTopicListName() + "</td>";
				for(int j=0;j<fl.getForumList().get(i).getTagName().size();j++){
					table += "<td class='tags'><a href='#'>" + fl.getForumList().get(i).getTagName().get(i) + "</a>";
					if(j!=fl.getForumList().get(i).getTagName().size() -1)
						table += ",";
				}
				table += "</td>";
				if(i%2 == 0)
					table += "</tr>";
			}
			//request.setAttribute("disease", fl.getForumList().get(0).getTopicListName());
			//request.setAttribute("tag0", fl.getForumList().get(0).getTagName().get(0));
			request.setAttribute("table", table);
			request.getRequestDispatcher("/jsp/forum/forumList.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void newTopic(String topicName, String userName, String content,
			String topicListName,HttpServletRequest request, HttpServletResponse response){
		try {
			IForumSystem fp = new ForumProxy( );
			HttpSession session = request.getSession();
			fp.newTopic(topicName, userName, content, topicListName);
			TopicListDetail tld = fp.getTopicList(topicListName);
			session.setAttribute("tld",tld);
			request.setAttribute("url", request.getParameter("url"));
			request.getRequestDispatcher("/jsp/forum/workdone.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void newReply(String content, int topicId, String userName,HttpServletRequest request, HttpServletResponse response){
		try {
			IForumSystem fp = new ForumProxy( );
			HttpSession session = request.getSession();
			fp.newReply(content, topicId, userName);
			TopicDetail td = fp.getTopic(topicId);
			session.setAttribute("td", td);
			request.setAttribute("url", request.getParameter("url"));
			request.getRequestDispatcher("/jsp/forum/workdone.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void deleteReply(int replyId,int topicId){
		try {
			IForumSystem fp = new ForumProxy( );
			fp.deleteReply(replyId, topicId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
