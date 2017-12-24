/**
 * 
 */
package com.collect.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.collect.domain.FeedBack;
import com.collect.domain.IDentification;
import com.collect.util.HibernateUtils;

/**
 * @author ÀîÎÄ±ø
 *
 */
public class ToolDaoImpl implements ToolDao {

	/* (non-Javadoc)
	 * @see com.collect.dao.ToolDao#updateIdentifiaction(com.collect.domain.IDentification)
	 */
	@Override
	public void updateIdentification(IDentification ident) {
		Session session = HibernateUtils.createSession();
		Transaction trans = null;
		
		trans = session.beginTransaction();
		try{	
			session.saveOrUpdate(ident);
			trans.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			trans.rollback();
		}finally{
			if(session.isOpen())
				session.close();
		}		

	}

	/* (non-Javadoc)
	 * @see com.collect.dao.ToolDao#loadIdentifiaction()
	 */
	@Override
	public IDentification loadIdentification() {
		Session session = HibernateUtils.createSession();
		Transaction trans = null;
		IDentification reuser = null;
		
		trans = session.beginTransaction();
		try{
			reuser = (IDentification) session.get(IDentification.class, "1");
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
	public void addFeedBack(FeedBack feed) {
		Session session = HibernateUtils.createSession();
		Transaction trans = null;
		
		trans = session.beginTransaction();
		try{
			session.save(feed);
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
	public void updateFeedBack(FeedBack feed) {
		Session session = HibernateUtils.createSession();
		Transaction trans = null;
		
		trans = session.beginTransaction();
		try{	
			session.saveOrUpdate(feed);
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
	public List<FeedBack> loadAllFeedBack() {
		Session session = HibernateUtils.createSession();
		Transaction trans = null;
		List<FeedBack> FeedBackList = null;
		
		trans = session.beginTransaction();
		try{
			FeedBackList = session.createQuery("from FeedBack feed order by feed.feednumber desc").list();
			trans.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			trans.rollback();
		}finally{
			if(session.isOpen())
				session.close();
		}
		return FeedBackList;
	}
	
	@Override
	public FeedBack getFeedBack(String feedid) {
		Session session = HibernateUtils.createSession();
		Transaction trans = null;
		FeedBack refeed= null;
		
		trans = session.beginTransaction();
		try{
			refeed = (FeedBack) session.get(FeedBack.class, feedid);
			System.out.println(refeed);
			trans.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			trans.rollback();
		}finally{
			if(session.isOpen())
				session.close();
		}
		return refeed;
	}

}
