package com.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manage.permissions.AuthValidate;

@Controller
@RequestMapping("")
public class LoginController extends BaseController{
	
	@RequestMapping("/logout")
	public String logout(){
		System.out.println("1");
		return "home";
	}
	
	@RequestMapping("/login")
	@AuthValidate("login")
	public String login(){
		System.out.println("1");
		return "home";
	}
	
}
