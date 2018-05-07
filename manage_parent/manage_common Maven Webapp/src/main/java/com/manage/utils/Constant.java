package com.manage.utils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 常量类
 * @author 许东雄
 * @date 2017-09-16
 */
public class Constant {
	/**
	 * 返回以','分隔的字段串 eg : 将111,222,333 转换为'111','222','333'
	 * @param s  待转换的字符串
	 * @param s1 分隔符
	 */
	public static String getStrd(String s,String split) {
		String s1 = "";
		if (s.length() > 0) {
			String[] s2 = StrToArray(s, split);
			for (int i = 0; i < s2.length; i++) {
				if (s2[i].length() > 0) {
					s1 = s1 + "'" + s2[i] + "',";
				}
			}
		}
		if (s1.length() > 0) {
			s1 = Left(s1, s1.length() - 1);
		}
		return s1;
	}
	/**
	 * 获取两个日期相差天数
	 * @param date
	 * @param date1
	 * @return
	 * @throws ParseException 
	 */
	public static int getDays(String start,String end){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			Date s = sdf.parse(start);
			Date n = sdf.parse(end);
			long days = n.getTime() - s.getTime();
			return (int) (days / (1000 * 60 * 60 * 24)+1);		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 根据月份获取开始日期和结束日期
	 * @param month
	 * @return
	 */
	public static String[] getMonthDate(Integer month){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);//设置起时间
		cal.add(Calendar.MONTH, month);
		Integer y = cal.get(1);
		Integer m = (cal.get(2)+1);
		Integer d = getMaxDay(y,m);
		String m_ = m<10 ? "0"+m :m+"";
		return new String[]{(y+"-"+m_+"-01"),(y+"-"+m_+"-"+d)};
	}
	/**
	 * 根据年月获取最大天数
	 * @param year
	 * @param month
	 * @return
	 */
	public static Integer getMaxDay(Integer year, Integer month) {
		if(month==0||year==0) return 0;
		int ryear=28;
		if(year%100==0)
		{
			if(year%4==0) ryear=29;
		}
		else
			if(year%4==0) ryear=29;

		int []yearArr={31,ryear,31,30,31,30,31,31,30,31,30,31};
		return yearArr[month-1];
	}
	/**
	 * 获取当前年度
	 * @return
	 */
	public static Integer getYear(){
		Calendar calendar = null;
		calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.get(1);	
	}
	/**
	 * 获取当前月份
	 * @return
	 */
	public static Integer getMonth(){
		Calendar calendar = null;
		calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return (1 + calendar.get(2));		
	}
	/**
	 * 获取当前日
	 * @return
	 */
	public static int getDay() {
		Calendar calendar = null;
		calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.get(5);
	}
	/**
	 * 获取当前小时
	 * @return
	 */
	public static int getHour(){
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.HOUR_OF_DAY);
	}
	/**
	 * 获取开始年度到结束年度的List列表
	 * @param startYear 开始年度
	 * @param endYear	结束年度
	 * @param step		年度之间的间隔（负数表示递增的列表）
	 * @return
	 */
	public static List getYearList(int startYear,int endYear,int step){
		List list = new ArrayList();
		for(int i=startYear;startYear<=endYear?i<=endYear:i>=endYear;i=i+step){
			Map<String,String> map = new HashMap<String,String>();
			map.put("yearvalue", String.valueOf(i));
			map.put("yeartext", String.valueOf(i)+"年");
			list.add(map);
		}
		return list;
	}
	/**
	 * 月份List列表
	 * @return
	 */
	public static List getMonthList(){
		List list = new ArrayList();
		for(int i=1;i<=12;i++){
			Map<String,String> map = new HashMap<String,String>();
			map.put("monthvalue", String.valueOf(i));
			map.put("monthtext", String.valueOf(i)+"月");
			list.add(map);
		}
		return list;
	}
	/** 
     * 根据年月返回相应月份最大天数
     **/  
    public static int getMonthMaxDay(int year, int month) {          
        Calendar a = Calendar.getInstance();  
        a.set(Calendar.YEAR, year);  
        a.set(Calendar.MONTH, month - 1);  
        a.set(Calendar.DATE, 1);  
        a.roll(Calendar.DATE, -1);  
        int maxDate = a.get(Calendar.DATE);  
        return maxDate;  
    } 
    /**
     * 判断字符串是否为空
     * @param s
     * @return
     */
    public static boolean isEmpty(String s){
    	return s == null || s.trim().length() == 0 || "null".equals(s);
    }
    /**
	 * 返回以','分隔的字段串 eg : 将111,222,333 转换为'111','222','333'
	 * @param s  待转换的字符串
	 * @param s1 分隔符
	 */
	public static String getStrd(String s) {
		String s1 = "";
		if (s.length() > 0) {
			String[] s2 = StrToArray(s, ",");
			for (int i = 0; i < s2.length; i++) {
				if (s2[i].length() > 0) {
					s1 = s1 + "'" + s2[i] + "',";
				}
			}
		}
		if (s1.length() > 0) {
			s1 = Left(s1, s1.length() - 1);
		}
		return s1;
	}
	/**
	 * 字符串转换成数组 eg : StrToArray("111,222,333",",") return String[]
	 * @param s  待转换的字符串
	 * @param s1 分隔符
	 */
	public static String[] StrToArray(String s, String s1) {
		try {
			int i = s1.length();
			int j = s.length();
			String s2 = s + s1;
			int k = 0;
			for (int l = 0; l <= j; l++) {
				int i1 = l + i;
				if (i1 < j) {
					String s3 = s.substring(l, i1);
					if (s3.equalsIgnoreCase(s1))
						k++;
				}
			}

			String as[] = new String[++k];
			int j1 = 0;
			// int k1 = s.indexOf(s1);
			for (int l1 = 0; l1 < k; l1++) {
				int i2 = s2.indexOf(s1, j1);
				as[l1] = s2.substring(j1, i2);
				j1 = i2 + i;
			}

			return as;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return null;
	}
	//取字符串左边的i个字符
	public static String Left(String s, int i) {
		if (isEmpty(s))
			return "";
		if (i > s.length())
			i = s.length();
		return s.substring(0, i);
	}
	/**
	 * 递归方式 计算文件夹的大小
	 * @param file
	 * @return
	 */
    public static double getDirSize(final File file) {
    	 //如果是目录则递归计算其内容的总大小    
        if (file.isDirectory()) {     
            File[] children = file.listFiles();     
            double size = 0;     
            for (File f : children)     
                size += getDirSize(f);     
            return size;     
        } else {//如果是文件则直接返回其大小,以“兆”为单位   
            double size = (double) file.length() / 1024 / 1024;        
            return size;     
        }
    }
    /**
     * 删除指定文件夹及文件夹下所有文件
     * @param f
     */
    public static void deleteDir(File f){
        for(File fi:f.listFiles()){
            if(fi.isDirectory()){
            	deleteDir(fi);
            }else{
                fi.delete();
            }
        }
        f.delete();
    }
    //替换符号
    public final static String formatChar(String str)
    {
		String strAfter = "";
		strAfter = Replace(str, " " , "");     //替换空格
		strAfter = Replace(strAfter, "，", ",");    //替换大逗号
		strAfter = Replace(strAfter, "，，", ",");   //替换重复的逗号
		strAfter = Replace(strAfter, "、", ",");     //替换重复的顿号
		strAfter = Replace(strAfter, "、、", ",");   //替换重复的顿号
		strAfter = Replace(strAfter, "；", ",");     //替换重复的分号
		strAfter = Replace(strAfter, ";", ",");     //替换重复的分号
		strAfter = Replace(strAfter, ";;", ",");    //替换重复的分号
		strAfter = Replace(strAfter, "；；", ",");   //替换重复的分号
		strAfter = Replace(strAfter, "；", ",");    //替换重复的分号
		strAfter = Replace(strAfter, ",,", ",");   //替换重复的分号
		return strAfter;
	}
    /*
	 * 替换字符串
	 * @param s  替换的源字符串
	 * @param s1 替换前的字符
	 * @param s2 替换后的字符
	 */
	public static String Replace(String s, String s1, String s2) {
		if (s == null)
			return null;
		StringBuffer stringbuffer = new StringBuffer(s.length());
		int i = 0;
		for (int j = 0; (j = s.indexOf(s1, i)) != -1;) {
			stringbuffer.append(s.substring(i, j)).append(s2);
			i = j + s1.length();
		}
		stringbuffer.append(s.substring(i));
		return stringbuffer.toString();
	}
	/*
	 * 将日期转换成字符串，格式参见 java.text.SimpleDateFormat。 
	 * @param date 待转换的日期数据
	 * @param strDateFormat 转换成字符串数据的格式
	 * @return 返回转换后的字符串数据（为空返回null)
	 */
    public static String dateToString(Date dtValue, String strDateFormat) {
		try {
			String strReturn = "";
			if (dtValue == null) {
				return "";
			}
			SimpleDateFormat formatter = new SimpleDateFormat(strDateFormat);
			strReturn = formatter.format(dtValue);
			return strReturn;
		} catch (Exception e) {
			return "";
		}
	}
}
