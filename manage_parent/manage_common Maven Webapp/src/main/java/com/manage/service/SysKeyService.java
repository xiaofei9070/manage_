package com.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.dao.SysKeyDao;
import com.manage.exceptions.RootException;
import com.manage.model.SqlParams;
import com.manage.model.SysKey;
import com.manage.utils.ValidateUtil;

@Service
public class SysKeyService {
	private final String ns = "com.manage.model.SysKey.";
	
	@Autowired
	private SysKeyDao sysKeyDao;
	
	public Integer getMaxKeyType(String type) throws RootException{
		if(ValidateUtil.validateBlank(type))throw new RootException("类型为空");
		
		SysKey key = sysKeyDao.getOne(ns, "getMaxKeyByType", SqlParams.init().addParam("type", type));
		if(key == null){
			throw new RootException("类型["+type+"]的值为空");
		}else{
			return key.getNum();
		}
	}
	
	/**
	 * 
	 * @param type
	 * @param newMax
	 * @return
	 */
	public Integer autoIncKeyByType(String type,Integer newMax){
		return sysKeyDao.update(ns, "autoIncKeyByType", SqlParams.init().addParam("type", type).addParam("newMax", newMax));
	}
	
}
