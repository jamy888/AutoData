package com.huateng.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.huateng.util.ContextUtil;


public class ContextLoaderListener implements ServletContextListener{
	public ContextLoaderListener() {
		super();
	}
	public void contextInitialized(ServletContextEvent event)
	{
		ServletContext context = event.getServletContext();
		try{
			ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
			ContextUtil.setContext(ctx);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	public void contextDestroyed(ServletContextEvent sce)
	{

	}

}