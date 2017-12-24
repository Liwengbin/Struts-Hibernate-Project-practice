/**
 * 
 */
package com.collect.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author joeyang ong
 *
 */
public class HibernateUtils {
	
	private static SessionFactory factory = null;
	
	static{
		Configuration config = new Configuration();
		config.configure("com/collect/config/hibernate.cfg.xml");
		factory = config.buildSessionFactory();
	}
	
	public static Session createSession(){
		return factory.openSession();
	}

}
