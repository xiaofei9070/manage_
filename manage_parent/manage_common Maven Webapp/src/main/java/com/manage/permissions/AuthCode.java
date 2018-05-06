package com.manage.permissions;

public enum AuthCode {
	
	Allow("*:*"),
	Null("Null");
	
	private String permission;
	
	private AuthCode(String permission){
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
}
