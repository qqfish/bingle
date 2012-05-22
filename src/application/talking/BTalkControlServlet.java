package application.talking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import baseUse.IBTalkSystem;
import baseUse.bTalkData.FriendList;
import baseUse.bTalkData.Message;
import baseUse.bTalkData.MessageList;
import businessServices.bTalkSystem.BTalkProxy;
import businessServices.datamanager.userdata.UserDataProxy;

@WebServlet(urlPatterns={"/BTalkControlServlet"}, asyncSupported=true)
public class BTalkControlServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private List<AsyncContext>  asyncs;
	/**
	 * Constructor of the object.
	 */
	public BTalkControlServlet() {
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
		String get = request.getParameter("get");
		if(get.equals("message")){
			//AsyncContext aCtx = request.startAsync(request, response);
			final AsyncContext ctx = request.startAsync();
			//IBTalkSystem ibs = new BTalkProxy();
			new Thread(new Runnable() {  
			        @Override  
			        public void run() {
			                try {
			                	UserDataProxy udp = new UserDataProxy();
			                    JSONArray jsonArray1 = new JSONArray();
			                	JSONArray jsonArray2 = new JSONArray();
			                    JSONObject json = new JSONObject();
			                    List<Message> m = udp.getMessage("zy").getNewMessage();
			                    for(int i=0;i<m.size();i++){
			                		jsonArray1.add(m.get(i).getContent());
			                		//jsonArray1.add(m.get(i).getTime());
			                		jsonArray1.add(m.get(i).getFrom());
			                		jsonArray2.add(jsonArray1);
			                		jsonArray1.clear();
			                	}
			                    json.put("messages", jsonArray2);
			                    System.out.println(json.toString());
			                    synchronized (ctx) {
			                           ctx.getResponse().getWriter().println(json.toString());  
			                           ctx.complete();  
			                        }
			                } catch (Exception e) {  
			                    throw new RuntimeException(e);  
			                }
			}
			    }).start();
	    }
		else if(get.equals("friend")){
			requestFriendList(/*(String) request.getSession().getAttribute("username"),*/"zy",request,response);
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
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String func = request.getParameter("func");
		if(func.equals("send")){
		sendMessage(username,request.getParameter("name"),request.getParameter("content"));
		}
		else if(func.equals("add")){
			addFriend(username,request.getParameter("name"));
		}
		else if(func.equals("delete")){
			deleteFriend(username,request.getParameter("name"));
		}
		else
			request.getRequestDispatcher("error404.jsp").forward(request, response);
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
		 //asyncs = (List<AsyncContext>) getServletContext().getAttribute("asyncs");
	}

	public void requestFriendList(String username,HttpServletRequest request, HttpServletResponse response){
		IBTalkSystem ibs = new BTalkProxy();
		System.out.print(username);
		try {
			String s = "<ul>";
			FriendList fl = ibs.getFriendList(username);
			//UserDataProxy usp = new UserDataProxy();
			//FriendList fl = usp.getFriendList(username);
			for(int i=0;i<fl.getFriendList().size();i++)
				s += "<li><a onclick='ChatShow()'>"+ fl.getFriendList().get(i) + "</a></li>";
			if(fl.getFriendList().size()==0)
				s += "<li><a>нч</a></li>";
			s+="</ul>";
			response.getWriter().print(s.trim());
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String from, String to,String content){
		IBTalkSystem ibs = new BTalkProxy();
		try {
			ibs.sendMessage(from, to, content);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getMessage(String username){
		IBTalkSystem ibs = new BTalkProxy();
		MessageList ml = ibs.getMessage(username);
	}
	
	public void deleteFriend(String username,String friendname){
		IBTalkSystem ibs = new BTalkProxy();
		try {
			ibs.deleteFriend(username, friendname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addFriend(String username,String friendname){
		IBTalkSystem ibs = new BTalkProxy();
		try {
			ibs.addFriend(username, friendname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
