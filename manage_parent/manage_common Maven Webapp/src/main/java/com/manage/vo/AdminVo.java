package com.manage.vo;

import java.io.Serializable;

public class AdminVo implements Serializable{
	private String id;

    private String salt;

    private String pwd;

    private String name;

    private String email;

    private String phone;

    private String headImg;

    private String headPre;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getHeadPre() {
		return headPre;
	}

	public void setHeadPre(String headPre) {
		this.headPre = headPre;
	}
    
}
