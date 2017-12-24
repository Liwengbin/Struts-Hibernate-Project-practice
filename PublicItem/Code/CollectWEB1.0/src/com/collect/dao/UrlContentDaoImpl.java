package com.collect.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.collect.domain.CollUrl;
import com.collect.domain.UrlCollect;
import com.collect.domain.UserInfo;
import com.collect.util.HibernateUtils;

public class UrlContentDaoImpl implements UrlContentDao {

	@Override
	public void addUrlContent(UrlCollect coll) {
		Session session = HibernateUtils.createSession();
		Transaction trans = null;
		
		trans = session.beginTransaction();
		try{
			session.save(coll);		
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
	public List<UrlCollect> loadAllUrlContent() {
		Session session = HibernateUtils.createSession();
		Transaction trans = null;
		List<UrlCollect> collList = null;
		
		trans = session.beginTransaction();
		try{
			collList = session.createQuery("from UrlCollect coll order by coll.tid").list();	
			trans.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			trans.rollback();
		}finally{
			if(session.isOpen())
				session.close();
		}
		return collList;
	}

	@Override
	public List<UrlCollect> loadUrlContent(UrlCollect coll) {
		Session session = HibernateUtils.createSession();
		Transaction trans = null;
		List<UrlCollect> collList = null;
		
		trans = session.beginTransaction();
		try{
			System.out.println("TidÎª£º"+coll.getTid());
			Query query = session.createQuery("from UrlCollect coll where coll.fid=\'"+coll.getTid()+"\' order by coll.tid");
			collList = query.list();	
			System.out.println(collList);
			trans.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			trans.rollback();
		}finally{
			if(session.isOpen())
				session.close();
		}
		
		return collList;
	}

	@Override
	public void addCollUrl(CollUrl coll) {
		Session session = HibernateUtils.createSession();
		Transaction trans = null;
		
		trans = session.beginTransaction();
		try{
			session.save(coll);		
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
	public List<CollUrl> loadFIDCollUrl(String fid,boolean isfather) {
		Session session = HibernateUtils.createSession();
		Transaction trans = null;
		List<CollUrl> collList = null;
		
		trans = session.beginTransaction();
		try{
			Query query =session.createQuery("from CollUrl coll where coll.fid=\'"+fid+"\' and coll.father = "+isfather+" order by coll.kid");
			collList = query.list();
			trans.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			trans.rollback();
		}finally{
			if(session.isOpen())
				session.close();
		}
		
		return collList;
	}

	@Override
	public List<CollUrl> loadLOCTIONCollUrl(String loction,boolean isfather,String email) {
		Session session = HibernateUtils.createSession();
		Transaction trans = null;
		List<CollUrl> collList = null;
		
		trans = session.beginTransaction();
		try{
			collList = session.createQuery("from CollUrl coll where coll.loction=\'"+loction+"\' and coll.father = "+isfather+" and coll.fid = \'"+email+"\'order by coll.kid").list();	
			trans.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			trans.rollback();
		}finally{
			if(session.isOpen())
				session.close();
		}
		return collList;
	}

	@Override
	public void removeContent(String kid) {
		Session session = HibernateUtils.createSession();
		Transaction trans = null;
		
		trans = session.beginTransaction();
		try{
			session.delete(session.load(CollUrl.class,kid));
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
