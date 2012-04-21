package application.visitForum;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseUse.Globalization;

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
		String path = request.getRequestURI();
		String action = path.substring(path.lastIndexOf("/"), path.indexOf("."));
		if(action.equals("/TopicListPageInit"))
			getTopicList(request.getParameter(""));
		else if(action.equals("/ViewTopicPageEditReply"))
			editReply(Integer.parseInt(request.getParameter("")),Integer.parseInt(request.getParameter("")),request.getParameter(""));
		else if(action.equals("/TopicListPageDeleteTopic"))
			deleteTopic(Integer.parseInt(request.getParameter("")),request.getParameter(""));
		else if(action.equals("/TopicListPageEnterTopic"))
			getTopic(Integer.parseInt(request.getParameter("")));
		else if(action.equals("/ForumListPageInit"))
			getForumList();
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
	
	void getTopicList(String topicListName) {
		try {
			Globalization.forumSystem.getTopicList(topicListName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void editReply(int replyId,int topicId,String content){
		try {
			Globalization.forumSystem.editRelpy(replyId, topicId, content);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void deleteTopic(int topicId,String listName){
		try {
			Globalization.forumSystem.deleteTopic(topicId, listName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void getTopic(int topicId){
		try {
			Globalization.forumSystem.getTopic(topicId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void getForumList(){
		try {
			Globalization.forumSystem.getForumList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void newTopic(String topicName, String userName, String content,
			String topicListName){
		try {
			Globalization.forumSystem.newTopic(topicName, userName, content, topicListName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void newReply(String content, int topicId, String userName){
		try {
			Globalization.forumSystem.newReply(content, topicId, userName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void deleteReply(int replyId,int topicId){
		try {
			Globalization.forumSystem.deleteReply(replyId, topicId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
