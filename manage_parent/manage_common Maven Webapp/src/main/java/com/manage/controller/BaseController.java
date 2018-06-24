package com.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.manage.model.Admin;
import com.manage.statics.SysConst;

public class BaseController {
	
	protected HttpServletRequest req;
	protected HttpServletResponse resp;
	protected HttpSession session;
	
	@ModelAttribute
	protected void exec(HttpServletRequest req,HttpServletResponse resp){
		this.req = req;
		this.resp = resp;
		this.session = req.getSession();
	}
	
	
	protected Admin getUser(){
		Object object = session.getAttribute(SysConst.USER);
		if(object != null){
			return (Admin) object;
		}
		return null;
	}
	
}
