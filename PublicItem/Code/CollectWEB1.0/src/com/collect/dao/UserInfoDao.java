package com.collect.dao;

import com.collect.domain.UserInfo;

public interface UserInfoDao {
	public void addUserInfo(UserInfo user);
	
	public UserInfo getUserInfo(String email);
	
	public void updataUserInfo(UserInfo user);
	public void removeUserInfo(String email);
}
