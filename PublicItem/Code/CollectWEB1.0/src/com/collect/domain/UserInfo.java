/**
 * 
 */
package com.collect.domain;

import java.util.Arrays;

/**用户信息类
 * @author 李文兵
 * 保存用户的登录注册的基本信息
 */
public class UserInfo extends ValueObject{

	private String user_email;
	private String user_password;
	private String user_name;
	private byte[] user_img;
	private String lastloction;
	
	public UserInfo() {
		super();
	}
	
	

	public UserInfo(String user_email, String user_password, String user_name,
			byte[] user_img, String lastloction) {
		super();
		this.user_email = user_email;
		this.user_password = user_password;
		this.user_name = user_name;
		this.user_img = user_img;
		this.lastloction = lastloction;
	}

	public String getLastloction() {
		return lastloction;
	}

	public void setLastloction(String lastloction) {
		this.lastloction = lastloction;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public byte[] getUser_img() {
		return user_img;
	}

	public void setUser_img(byte[] user_img) {
		this.user_img = user_img;
	}



	@Override
	public String toString() {
		return "UserInfo [user_email=" + user_email + ", user_password="
				+ user_password + ", user_name=" + user_name + ", user_img="
				+ Arrays.toString(user_img) + ", lastloction=" + lastloction
				+ "]";
	}



}
