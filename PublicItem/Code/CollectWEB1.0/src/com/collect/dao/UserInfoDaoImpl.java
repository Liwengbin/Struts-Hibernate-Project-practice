package com.collect.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.collect.domain.UserInfo;
import com.collect.util.HibernateUtils;

public class UserInfoDaoImpl implements UserInfoDao {

	@Override
	public void addUserInfo(UserInfo user) {
		Session session = HibernateUtils.createSession();
		Transaction trans = null;
		
		trans = session.beginTransaction();
		try{
			session.save(user);
			trans.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			trans.rollback();
		}finally{
			if(session.isOpen())
				session.close();
		}
	}
	
	
	@Override
	public UserInfo getUserInfo(String email) {
		Session session = HibernateUtils.createSession();
		Transaction trans = null;
		UserInfo reuser = null;
		
		trans = session.beginTransaction();
		try{
			reuser = (UserInfo) session.get(UserInfo.class, email);
			System.out.println(reuser);
			trans.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			trans.rollback();
		}finally{
			if(session.isOpen())
				session.close();
		}
		return reuser;
	}


	@Override
	public void removeUserInfo(String email) {
		
		Session session = HibernateUtils.createSession();
		Transaction trans = null;
		
		trans = session.beginTransaction();
		try{
			session.delete(session.load(UserInfo.class,email));		
			trans.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			trans.rollback();
		}finally{
			if(session.isOpen())
				session.close();
		}		
	}


	@Override
	public void updataUserInfo(UserInfo user) {
		Session session = HibernateUtils.createSession();
		Transaction trans = null;
		
		trans = session.beginTransaction();
		try{	
			session.saveOrUpdate(user);
			trans.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			trans.rollback();
		}finally{
			if(session.isOpen())
				session.close();
		}
		
	}

}
