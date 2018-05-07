package com.manage.utils;

import java.util.Date;

public class UploadUrlUtil {
	
	
	
	public static String getUrl(){
		return "erp/" + DateFormatUtil.toDateStyle(new Date(), DateStyleEnum.YYYY_MM_DD) + "/";
	}
	
	public static String getFileName(String fileName){
		return RandomKeyUtil.getRandomUUID() + fileName.substring(fileName.lastIndexOf("."), fileName.length());
	}
	
}
