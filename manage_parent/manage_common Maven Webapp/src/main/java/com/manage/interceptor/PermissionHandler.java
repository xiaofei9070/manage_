package com.manage.interceptor;

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
		try {
			return AuthRequire.validate(req, obj);
		} catch (UserNoLoginException e) {
			e.printStackTrace();
			return false;
		} catch (PermissionException e) {
			e.printStackTrace();
			return false;
		}
	}

}
