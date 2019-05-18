package com.java.domian;

public class User {
	private Integer user_id;
	private String user_name;
	private String user_pwd;
	private String user_phone;
	private Integer user_limit;
	public User() {
		
	}

	public User(Integer user_id, String user_name, String user_pwd, String user_phone, Integer user_limit) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_phone = user_phone;
		this.user_limit = user_limit;
	}

	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public Integer getUser_limit() {
		return user_limit;
	}

	public void setUser_limit(Integer user_limit) {
		this.user_limit = user_limit;
	}
	
}
