package com.manage.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.manage.exceptions.UserNoLoginException;
import com.manage.permissions.AuthRequire;
import com.manage.permissions.PermissionException;

public class PermissionHandler implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	public void postHandle(HttpServletRequest req, HttpServletResponse resp,
			Object obj, ModelAndView view) throws Exception {
	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object obj) throws Exception {
		boolean isAjax = false;
		try {
			String xReq = req.getHeader("X-Requested-With");
			if("XMLHttpRequest".equalsIgnoreCase(xReq)){
				isAjax = true;
			}
			return AuthRequire.validate(req, obj);
		} catch (UserNoLoginException e) {
			if(isAjax){
				printAjax(resp, e.getMessage());
			}else{
				resp.sendRedirect("login");
			}
			return false;
		} catch (PermissionException e) {
			if(isAjax){
				printAjax(resp, "Permission denied");
			}else{
				resp.sendRedirect("denied");
			}
			return false;
		}
	}
	
	public void printAjax(HttpServletResponse resp,String msg){
		PrintWriter printWriter;
		try {
			printWriter = resp.getWriter();
			printWriter.print(msg);
			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
