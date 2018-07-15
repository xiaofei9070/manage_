package com.manage.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.dao.AdminDao;
import com.manage.ehcache.EhCache;
import com.manage.model.Admin;
import com.manage.model.SqlParams;
import com.manage.permissions.Auth;
import com.manage.statics.SysConst;
import com.manage.utils.PwdUtil;
import com.manage.vo.AdminVo;
import com.manage.vo.BaseVo;
import com.manage.vo.PageData;


@Service
public class AdminService {
	
	private final String ns = "com.manage.model.Admin.";
	
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private RoleService roleService;
	
	
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
				Auth auth = new Auth();
				auth.setId(user.getId());
				auth.setName(name);
				List<String> permissions = permissionService.findPermission(user.getId());
				if(permissions != null && permissions.size() != 0){
					StringBuilder per = new StringBuilder();
					for(int i = 0;i < permissions.size(); i ++){
						per.append(permissions.get(i)).append(";");
					}
					auth.setPermission(per.toString());
				}
				
				List<String> findRole = roleService.findRole(user.getId());
				if(findRole != null && findRole.size() != 0){
					StringBuilder roles = new StringBuilder();
					for(int i = 0;i < findRole.size(); i ++){
						roles.append(findRole.get(i)).append(",");
					}
					auth.setRoleName(roles.toString());
				}
				
				EhCache.put(EhCache.permiss, user.getId(), auth);
			}else{
				vo.setMsg("Username or Password is error");
				vo.setStatus(300);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	
	public int updatePassword(Admin admin){
		PwdUtil.encodePwd(admin);
		return adminDao.update(ns, "updatePassword", admin);
	}
	
	
	public PageData<AdminVo> findAdminList(SqlParams params,Integer pageNo,Integer pageSize){
		return adminDao.findResult(ns, "findAdminList", "findAdminListCount", params, pageNo, pageSize);
	}
	
}
