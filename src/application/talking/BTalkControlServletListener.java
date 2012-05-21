package application.talking;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BTalkControlServletListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		Executor executor =new ThreadPoolExecutor(10, 10, 50000L,TimeUnit.MILLISECONDS,
								new LinkedBlockingQueue<Runnable>(100));
		sce.getServletContext().setAttribute("executor", executor);
	}
}