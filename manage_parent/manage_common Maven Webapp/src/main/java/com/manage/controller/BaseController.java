package com.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

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
	
}
