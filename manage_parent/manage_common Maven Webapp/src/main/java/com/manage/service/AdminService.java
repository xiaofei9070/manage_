package com.manage.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.dao.AdminDao;
import com.manage.ehcache.EhCache;
import com.manage.model.Admin;
import com.manage.statics.SysConst;
import com.manage.utils.PwdUtil;
import com.manage.vo.BaseVo;


@Service
public class AdminService {
	
	private final String ns = "com.manage.model.Admin.";
	
	@Autowired
	private AdminDao adminDao;
	
	public int saveAdmin(Admin admin){
		return adminDao.save(ns, "insertSelective", admin);
	}
	
	public Admin findAdminInfo(String name){
		return adminDao.getOne(ns, "findAdminInfo", name);
	}
	
	public BaseVo findLoginInfo(String name,String pwd,BaseVo vo,HttpSession session){
		try {
			Admin user = findAdminInfo(name);
			if(user == null){
				vo.setMsg("Username or Password is error");
				vo.setStatus(300);
				return vo;
			}
			Boolean decodePwd = PwdUtil.decodePwd(user, pwd);
			if(decodePwd){
				vo.setStatus(200);
				user.setPwd(null);
				user.setSalt(null);
				session.setAttribute(SysConst.USER, user);
				EhCache.put(EhCache.permiss, user.getId(), "");
			}else{
				vo.setMsg("Username or Password is error");
				vo.setStatus(300);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	
}
