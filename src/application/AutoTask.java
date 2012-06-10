package application;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import baseUse.CleanTask;
import baseUse.Global;

/**
 * Application Lifecycle Listener implementation class DeleteWork
 *
 */
@WebListener
public class AutoTask implements ServletContextListener {
	private Timer timer = null;
    /**
     * Default constructor. 
     */
    public AutoTask() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
    	timer = new Timer(true);
    	arg0.getServletContext().log("定时器已启动");//添加日志，可在tomcat日志中查看到
    	timer.schedule(new CleanTask(), 0, 60 * 60 * 60 *1000);//调用exportHistoryBean，0表示任务无延迟，5*1000表示每隔5秒执行任务，60*60*1000表示一个小时。
    	arg0.getServletContext().log("已经添加任务");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    	timer.cancel();
    }
	
}
