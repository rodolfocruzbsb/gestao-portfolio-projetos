package br.com.rscruz.springmvc.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.com.rscruz.springmvc.utils.InitPrintter;

/**
 * Application Lifecycle Listener implementation class StartListener
 *
 */
@WebListener
public class StartListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public StartListener() {
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {

	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {

		InitPrintter.print();
	}

}
