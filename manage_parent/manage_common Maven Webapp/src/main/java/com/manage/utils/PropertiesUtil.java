package com.manage.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	//禁止外部实例化
	public PropertiesUtil(){}
	
	private static Properties props;
	
	
	static {
		
		props = new Properties();
		
		InputStream inputStream = PropertiesUtil.class.getResourceAsStream("/res.properties");
		
		try {
			
			//加载
			props.load(inputStream);
			
		} catch (IOException e) {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			
		}finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @param param 存取的key
	 * @return value
	 */
	public static String getParam(String param){
			return props.getProperty(param);
	}
	
	
}


