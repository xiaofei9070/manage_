package com.manage.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <pre>
 * 类名称    : DateFormatUtils
 * 类描述    : 用于格式化java.util.Date,或者将某一字符串转化为java.util.Date
 * </pre>
 */
public class DateFormatUtil {

	/**
	 * 格式化java.util.Date
	 * @param  date java.util.Date
	 * @param  style 要格式化的格式，DateStyleEnum为枚举类型
	 * @return
	 */
	public static String toDateStyle(Date date,DateStyleEnum style){
		return DateConst.getDateFormat(style.getVal()).format(date);
	}
	
	/**
	 * 字符串格式 转化为 java.util.Date
	 * @param src 字符串
	 * @param style 格式，DateStyle为枚举类型
	 * @return java.util.Date
	 */
	public static Date styleToDate(String src ,DateStyleEnum style){
		Date date = null;
		SimpleDateFormat dateFormat = null;
		try {
			dateFormat = DateConst.getDateFormat(style.getVal());
			date = dateFormat.parse(src);
		} catch (Exception e) {
			date = null;
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * @return
	 */
	public static Date setYYYYMMDD(Date date,Integer day){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	
}
