package com.manage.statics;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.manage.exceptions.RootException;
import com.manage.service.SysKeyService;

@Component
public class SysKeyStatic {
	
	private static final String ADMIN_TYPE = "admin";
	
	private static final Integer ADMIN_LEN = 6;
	
	
	private static SysKeyService sysKeyService;

	@Resource
	public void setSysKeyService(SysKeyService sysKeyService) {
		SysKeyStatic.sysKeyService = sysKeyService;
	}
	
	public static Integer getMaxKeyByType(String type){
		try {
			return sysKeyService.getMaxKeyType(type);
		} catch (RootException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getKey(Integer max,Integer num,Integer len){
		Integer maxLen = String.valueOf(max + num).length();
		String pre = "";
		if(maxLen <= len){
			for(int i = 0;i < len - maxLen; i ++){
				pre += "0";
			}
		}else{
			pre = "";
		}
		return pre + String.valueOf(max + num);
	}
	
	public static String createAdminKey(int size,boolean isBatch) throws RootException{
		synchronized (ADMIN_TYPE) {
			Integer max = getMaxKeyByType(ADMIN_TYPE);
			String pre = getKey(max, size, ADMIN_LEN);
			int count = sysKeyService.autoIncKeyByType(ADMIN_TYPE, max + size);
			if(count <= 0){
				throw new RootException("after get key annot autoIncrement");
			}
			if(!isBatch){
				return pre;
			}
			return String.valueOf(max);
		}
	}
	
}
