package com.manage.utils;

import com.manage.model.Admin;


public class PwdUtil {
	/**
	 * 会员密码加密 ，
	 * @param shopUser
	 * @return
	 * @throws RootException
	 */
	public static Admin encodePwd(Admin user){
		if(user == null || user.getId() == null
		  || ValidateUtil.validateBlank(user.getPwd())){
			return null;
		}else{
			user.setSalt(RandomKeyUtil.getRandomUUID());
			
			user.setPwd(Md5SecurityUtil.md5(user.getId() + new StringBuilder(Md5SecurityUtil.md5(user.getPwd() + user.getSalt())).reverse()));
		}
			
		return user;
	}
	
	/**
	 * 会员密码输入是否正确
	 * @param shopUser
	 * @param pwd 明文密码
	 * @return
	 * @throws RootException
	 */
	public static Boolean decodePwd(Admin user,String pwd){
		if(user == null || user.getId() == null
		  || ValidateUtil.validateBlank(user.getPwd()) || ValidateUtil.validateBlank(pwd)){
			return false;
		}else{
			
			String encodePwd = Md5SecurityUtil.md5(user.getId() + new StringBuilder(Md5SecurityUtil.md5(pwd + user.getSalt())).reverse());
			
			if(encodePwd.equals(user.getPwd())){
				return true;
			}else{
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		Admin user = new Admin();
		user.setId("9003");
		user.setPwd("9");
		user.setSalt(RandomKeyUtil.getDefaultKey());
		Admin encodePwd = encodePwd(user);
		System.out.println(user.getSalt());
		System.out.println(user.getPwd());
	}
}
