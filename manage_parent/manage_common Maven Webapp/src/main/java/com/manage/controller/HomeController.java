package com.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manage.permissions.AuthValidate;

@RequestMapping("")
@Controller
public class HomeController extends BaseController{
	
	/**
	 * 主页
	 * @return
	 */
	@RequestMapping("/home")
	@AuthValidate("home:view")
	public String home(){
		return "/home";
	}
	
}
