package application.visitForum;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseUse.*;

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
		String action = request.getParameter("action");
		if(action.equals("ini"))
			getForumList(request,response);
		else if(action.equals("topic")){
			String topic = request.getParameter("list");
			if(topic.equals("1"))
				getTopicList(request.getParameter("topic"),request,response);
			else
				response.sendRedirect("/error404.jsp");
		}
		else if(action.equals("/ViewTopicPageEditReply"))
			editReply(Integer.parseInt(request.getParameter("")),Integer.parseInt(request.getParameter("")),request.getParameter(""));
		else if(action.equals("/TopicListPageDeleteTopic"))
			deleteTopic(Integer.parseInt(request.getParameter("")),request.getParameter(""));
		else if(action.equals("/TopicListPageEnterTopic"))
			getTopic(Integer.parseInt(request.getParameter("")));
		else if(action.equals("/NewTopicFormSubmit"))
			newTopic(request.getParameter(""),request.getParameter(""),request.getParameter(""),request.getParameter(""));
		else if(action.equals("/ViewTopicPageNewReply"))
			newReply(request.getParameter(""),Integer.parseInt(request.getParameter("")),request.getParameter(""));
		else if(action.equals("/ViewTopicPageDeleteReply"))
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
	
	void getTopicList(String topicListName,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			TopicListDetail tld = Global.iForumSystem().getTopicList(topicListName);
			//request.setAttribute("listname", topicListName);
			//request.setAttribute("name", tld.getTopicInfo().get(0).getTopicName());
			//request.setAttribute("number", tld.getTopicNum());
			//request.setAttribute("author", tld.getTopicInfo().get(0).getAuthor());
			//request.setAttribute("reply", tld.getTopicInfo().get(0).getReplyNum());
			//request.setAttribute("view", tld.getTopicInfo().get(0).getViewNum());
			//request.setAttribute("time", tld.getTopicInfo().get(0).getFirstEditTime());
			request.setAttribute("tld",tld);
			request.getRequestDispatcher("/jsp/forum/topicList.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void editReply(int replyId,int topicId,String content){
		try {
			Global.iForumSystem().editRelpy(replyId, topicId, content);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void deleteTopic(int topicId,String listName){
		try {
			Global.iForumSystem().deleteTopic(topicId, listName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void getTopic(int topicId){
		try {
			Global.iForumSystem().getTopic(topicId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void getForumList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			ForumList fl = Global.iForumSystem().getForumList();
			//request.setAttribute("disease", fl.getForumList().get(0).getTopicListName());
			//request.setAttribute("tag0", fl.getForumList().get(0).getTagName().get(0));
			request.setAttribute("fl", fl);
			request.getRequestDispatcher("/jsp/forum/forumList.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void newTopic(String topicName, String userName, String content,
			String topicListName){
		try {
			Global.iForumSystem().newTopic(topicName, userName, content, topicListName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void newReply(String content, int topicId, String userName){
		try {
			Global.iForumSystem().newReply(content, topicId, userName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void deleteReply(int replyId,int topicId){
		try {
			Global.iForumSystem().deleteReply(replyId, topicId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
