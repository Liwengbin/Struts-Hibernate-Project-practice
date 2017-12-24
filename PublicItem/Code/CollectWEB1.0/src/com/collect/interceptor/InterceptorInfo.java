package com.collect.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class InterceptorInfo implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -796719683486589984L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String,Object> session = invocation.getInvocationContext().getSession();
		
		Object userinfo = session.get("USER");
		
		if(userinfo==null){
		    System.out.println("user not logged, to login!");
			return "login";
		}
		
		System.out.println("user logged, to actual page!!");
		
		return invocation.invoke();
	}

}
