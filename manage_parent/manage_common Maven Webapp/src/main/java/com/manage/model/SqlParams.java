package com.manage.model;

import java.util.HashMap;
import java.util.Map;




/**
 * <pre>
 * 类名称    : SqlParams
 * 类描述    : 操作mybatis映射文件中parameterType="map"
 * </pre>
 */
public class SqlParams {

	private  Map<String, Object> params = new HashMap<String, Object>();
	
	private SqlParams(){}
	
	/**
	 * 初始化  返回this,方便链式操作
	 * @return this
	 */
	public static SqlParams init(){
		return  new SqlParams();
	}
	
	/**
	 * 添加参数  返回this,方便链式操作
	 * @param key
	 * @param val
	 * @return this
	 */
	public SqlParams addParam(String key,Object val){
		params.put(key, val);
		return this;
	}
	
	/**
	 * 得到参数 返回Map
	 * @return Map
	 */
	public  Map<String, Object> getParams(){ 
		return params;
	}
}
