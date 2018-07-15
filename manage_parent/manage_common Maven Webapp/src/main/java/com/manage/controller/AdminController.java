package com.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.model.Admin;
import com.manage.model.SqlParams;
import com.manage.service.AdminService;
import com.manage.vo.AdminVo;
import com.manage.vo.BaseVo;
import com.manage.vo.PageData;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/setPwd",method=RequestMethod.POST)
	@ResponseBody
	public BaseVo setPwd(String oldPwd,String pwd){
		BaseVo vo = new BaseVo();
		try {
			Admin admin = getUser();
			admin.setPwd(pwd);
			int updatePassword = adminService.updatePassword(admin);
			if(updatePassword != 0){
				vo.setMsg("修改成功");
				vo.setStatus(200);
			}else{
				vo.setMsg("error");
				vo.setStatus(300);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setMsg("error");
			vo.setStatus(300);
		}
		return vo;
	}
	
	@RequestMapping(value="/userList",method=RequestMethod.POST)
	@ResponseBody
	public PageData<AdminVo> userList(Integer pageNo,Integer pageSize,String key){
		try {
			if(pageNo == null || pageNo < 1){
				pageNo = 1;
			}
			if(pageSize == null){
				pageSize = 30;
			}
			PageData<AdminVo> data = adminService.findAdminList(SqlParams.init().addParam("key", key), pageNo, pageSize);
			data.setCode(0);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
