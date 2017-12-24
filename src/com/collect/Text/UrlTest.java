package com.collect.Text;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.collect.domain.UrlCollect;
public class UrlTest {
	private SessionFactory factory;
	private Session session;
	@Test
	public void testAdd() {
		
		Configuration config=new Configuration(); //构建一个配置器
		config.configure("/com/collect/config/hibernate.cfg.xml"); //使用配置器，读取配置文件
		factory=config.buildSessionFactory();
		session=factory.openSession();
		
		byte[] bt;
		bt="123".getBytes();
		UrlCollect url = new UrlCollect("0","1", "www", bt, "one", "title", "java", false, true, true, "2");
		
		Transaction trans = session.beginTransaction();
		
		try{
		   session.save(url);
		   trans.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			trans.rollback();
		}	
	}
}
