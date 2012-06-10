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
    	arg0.getServletContext().log("��ʱ��������");//�����־������tomcat��־�в鿴��
    	timer.schedule(new CleanTask(), 0, 60 * 60 * 60 *1000);//����exportHistoryBean��0��ʾ�������ӳ٣�5*1000��ʾÿ��5��ִ������60*60*1000��ʾһ��Сʱ��
    	arg0.getServletContext().log("�Ѿ��������");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    	timer.cancel();
    }
	
}
