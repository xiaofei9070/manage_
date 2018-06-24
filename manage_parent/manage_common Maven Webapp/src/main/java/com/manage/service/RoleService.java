package com.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.dao.RoleDao;

@Service
public class RoleService {
	private final String ns = "com.manage.model.Role.";
	
	@Autowired
	private RoleDao roleDao;
	
	public List<String> findRole(String id){
		return roleDao.getList(ns, "findRoles", id);
	}
	
}
