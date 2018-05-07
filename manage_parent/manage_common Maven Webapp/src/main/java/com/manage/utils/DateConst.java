package com.manage.utils;

import java.text.SimpleDateFormat;

public class DateConst {

	public static final long DAY_MILLI_SEC = 24 * 60 * 60 * 1000;//一天的毫秒
	
	public static final long MINUTE_MILLI_SEC = 60 * 1000;//一小时的毫秒
	
	public static  SimpleDateFormat getDateFormat(String style){
		SimpleDateFormat  dateFormat  = new SimpleDateFormat(style);
		dateFormat = new SimpleDateFormat(style);
		dateFormat.setLenient(false);//严格匹配日期格式
		return dateFormat;
	}
	
}

