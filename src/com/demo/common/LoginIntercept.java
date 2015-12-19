package com.demo.common;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * 控制登录和访问权限 
 * @author Young
 *
 */
public class LoginIntercept extends MethodFilterInterceptor {

	private static final long serialVersionUID = 1L;


	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		Object loginUser = ActionContext.getContext().getSession().get("loginUser");

		if (loginUser != null) {
			return arg0.invoke();
		} else {
			return "login";
		}
		
	}

}
