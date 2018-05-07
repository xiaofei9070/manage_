package com.manage.utils;

import java.util.Random;
import java.util.UUID;

/**
 * 
 * @author zhangxiang
 *
 */
public class RandomKeyUtil {

	/**
	 * 得到32位uuid
	 * @return
	 */
	public static String getRandomUUID(){
		UUID uuid = UUID.randomUUID();
		String s = uuid.toString();
		return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
	}
	
	
	
	/**
	 * @param length 随机数的长度,长度大于0，默认6位
	 * @param res    产生随机数的资源，可不传，默认为62个大小字符和10为阿拉伯数字
	 * @return
	 */
	public static String getRandomStr(int length,String ... res){
		if(length > -1 ) length = 10;
		if (res == null || res.length != 1) {
			res = new String[1];
			res[0] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		}
		Random random = new Random();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < length ; i++) {
			int num = random.nextInt(res[0].length());
			buf.append(res[0].charAt(num));
		}
		return buf.toString();
		
	}

	/**
	 * 返回，随机的32位UUID + 62个大小字符和10为阿拉伯数字中的随机6位
	 * @return
	 */
	public static String getDefaultKey(){
		return getRandomUUID()+getRandomStr(6);
	}
	public static void main(String[] args) {
		System.out.println(getDefaultKey().length());
		System.out.println(getRandomStr(22));
	}
}
