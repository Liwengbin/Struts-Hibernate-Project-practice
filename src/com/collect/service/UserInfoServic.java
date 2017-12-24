package com.collect.service;

import com.collect.domain.UserInfo;

public interface UserInfoServic {
	public void addUserInfo(UserInfo user);
	
	public UserInfo getUserInfo(String email);
	
	public void removeUserInfo(String email);
	
	public void updataUserInfo(UserInfo user);
	
	public UserInfo CheckUser(UserInfo user);
	
	public UserInfo CheckSign(UserInfo user);
}
