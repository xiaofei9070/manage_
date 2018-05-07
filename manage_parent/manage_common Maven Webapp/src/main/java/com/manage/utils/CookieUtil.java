package com.manage.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * cookie 工具类
 */

public class CookieUtil {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private int age ;//设置cookie有效期
	
	
	
	public CookieUtil(HttpServletRequest request,HttpServletResponse response,int age){
		this.request = request;
		this.response = response;
		this.age = age;
	}
	
	
	/**
	 * 保存cookie
	 * @param name
	 * @param value
	 * @throws UnsupportedEncodingException 
	 */
	public void addCookie(String name,String value) throws UnsupportedEncodingException{
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "UTF-8"));
		cookie.setPath("/");
		//cookie.setDomain(".gangzhigou.com");
		cookie.setHttpOnly(true);
		cookie.setMaxAge(age);
		response.addCookie(cookie);
	}
	
	
	/**
	 * 获取cookie
	 * @param cookieName
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getCookieValue(String cookieName) throws UnsupportedEncodingException{
		if(cookieName != null ){
			Cookie cookie = getCookie(cookieName);
			if(cookie != null){
				return URLDecoder.decode(cookie.getValue(),"UTF-8");
			}
		}
		
		return "";
	}


	public Cookie getCookie(String cookieName) {
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		try {
			
			if(cookies != null && cookies.length > 0){
				for(int i=0;i<cookies.length;i++){
					cookie = cookies[i];
					if(cookie.getName().equals(cookieName)){
						return cookie;
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 删除cookie
	 * @param cookieName
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public boolean delCookie(String cookieName) throws UnsupportedEncodingException{
		if(cookieName != null){
			Cookie cookie = getCookie(cookieName);
			if(cookie != null){
				cookie.setPath("/");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				return true;
			}
		}
		return false;
	}
	
	

}
