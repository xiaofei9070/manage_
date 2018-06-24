package com.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.dao.PermissionDao;

@Service
public class PermissionService {
	
	private final String ns = "com.manage.model.Permission.";
	
	@Autowired
	private PermissionDao permissionDao;
	
	public List<String> findPermission(String id){
		return permissionDao.getList(ns, "findPermission", id);
	}
}
