package com.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manage.model.Admin;
import com.manage.permissions.AuthRequire;
import com.manage.service.AdminService;
import com.manage.utils.ValidateUtil;
import com.manage.vo.BaseVo;

@Controller
@RequestMapping("")
public class LoginController extends BaseController{
	
	@Autowired
	private AdminService adminService;
	
	
	@RequestMapping("/logout")
	public String logout(){
		AuthRequire.logout(session);
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	/**
	 * @param name
	 * @param pwd
	 * @return
	 */
	@RequestMapping(value="/toLogin",method=RequestMethod.POST)
	@ResponseBody
	public BaseVo toLogin(String name,String pwd){
		BaseVo vo = new BaseVo();
		if(ValidateUtil.validateBlank(name)){
			vo.setStatus(300);
			vo.setMsg("Username can't null");
			return vo;
		}
		if(ValidateUtil.validateBlank(pwd)){
			vo.setStatus(300);
			vo.setMsg("Password can't null");
			return vo;
		}
		return adminService.findLoginInfo(name, pwd, vo, session);
	}
	
}
