package com.manage.interceptor;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.manage.SysConst;


public class WebAppContextInterceptor implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		SysConst.WEB_APP_CONTEXT = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
	}

	public void contextDestroyed(ServletContextEvent sce) {
			
	}
	
}
