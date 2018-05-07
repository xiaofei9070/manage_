package com.manage.utils;

/**
 * <pre>
 * 类名称    : DateStyleEnum
 * 类描述    : 格式化日期所用到的格式类型
 * </pre>
 */
public enum DateStyleEnum {

	YYYY_MM("yyyy-MM"),
	YYYY_MM_DD("yyyy-MM-dd"),
	YYYY_MM_DD_HH_MM("yyyy-MM-dd HH:mm"),
	YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss"),
	
	YYYY_MM_CN("yyyy年MM月"),
	YYYY_MM_DD_CN("yyyy年MM月"),
	YYYY_MM_DD_HH_MM_CN("yyyy年MM月dd日 HH:mm"),
	YYYY_MM_DD_HH_MM_SS_CN("yyyy年MM月dd日 HH:mm:ss"),
	
	HH_MM_SS("HH:mm:ss"),
	HH_MM("HH:mm"),
	
	YYYYMMDDHHMMSS("yyyyMMddHHmmss"),
	MMDD("MMdd"),
	YYYYMMDD("yyyyMMdd"),
	YYMMDD("yyMMdd"),
	HHMMSS("HHmmss"),
	HHMM("HHmm");
	
	
	private String val;
	
	DateStyleEnum(String val){
		this.val = val;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
	
	
	
}
