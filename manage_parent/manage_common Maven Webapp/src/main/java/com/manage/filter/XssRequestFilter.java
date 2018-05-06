package com.manage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class XssRequestFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper((HttpServletRequest) request);
		  chain.doFilter(xssRequest, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	public static void main(String[] args) {  
       String str = "123";
       StringBuffer sb = new StringBuffer(str);
       System.out.println(sb.reverse());
       
    }  

}
