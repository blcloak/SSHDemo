package com.demo.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.User;
import com.demo.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("basePackage")
@Namespace("/")
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 6912391687787646716L;

	private IUserService userService;
	private User user;
	Map<Integer, Integer> authority;

	@Transactional
	@Action(value = "logIn", results = {
			@Result(name = "success", type="redirect", location = "get"),
			@Result(name = "input", location = "/jsp/logIn.jsp") })
	public String logIn() {
		User userCheck = userService.getUserByName(user.getUsername());
		if (userCheck != null && userCheck.getPassword().equals(user.getPassword())) {
			authority = userService.getAuthority(user.getUsername());
			ActionContext.getContext().getSession().put("loginUser", user.getUsername());
			return SUCCESS;
		}
		return INPUT;

	}
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
