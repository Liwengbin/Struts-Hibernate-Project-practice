 package com.collect.service;

import com.collect.dao.UserInfoDao;
import com.collect.dao.UserInfoDaoImpl;
import com.collect.domain.UserInfo;
import com.collect.exception.CollException;

public class UserInfoServicImpl implements UserInfoServic {

	@Override
	public void addUserInfo(UserInfo user) {
		UserInfoDao user_dao =new UserInfoDaoImpl();
		user_dao.addUserInfo(user);
	}

	@Override
	public UserInfo getUserInfo(String email) {
		UserInfoDao user_dao =new UserInfoDaoImpl();
		
		return user_dao.getUserInfo(email);
	}

	@Override
	public void removeUserInfo(String email) {
		UserInfoDao user_dao =new UserInfoDaoImpl();
		user_dao.removeUserInfo(email);
		
	}

	
	/**
	 * 验证密码是否正确
	 */
	@Override
	public UserInfo CheckUser(UserInfo user) {
		System.out.println("123456789");
		UserInfoDao user_dao =new UserInfoDaoImpl();
		System.out.println("验证："+user);
		UserInfo userdb = user_dao.getUserInfo(user.getUser_email());
		System.out.println(userdb);
		if(userdb == null)
		{
			throw new CollException("用户不存在！");
		}
		else if(user.getUser_password().equals(userdb.getUser_password()) == false)
		{
			throw new CollException("密码错误！");
		}
		return userdb;
	}

	/**
	 * 注册检测，检测账号是否存在
	 */
	@Override
	public UserInfo CheckSign(UserInfo user) {
		UserInfoDao user_dao =new UserInfoDaoImpl();
		UserInfo userdb = user_dao.getUserInfo(user.getUser_email());
		if(userdb != null)
		{
			throw new CollException("用户存在,请重新注册！");
		}
		else
		{
			user_dao.addUserInfo(user);
		}
		return userdb;
	}

	@Override
	public void updataUserInfo(UserInfo user) {
		UserInfoDao user_dao =new UserInfoDaoImpl();
		user_dao.updataUserInfo(user);

	}

}
