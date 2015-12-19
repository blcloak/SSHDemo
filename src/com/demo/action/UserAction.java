package com.demo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.User;
import com.demo.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("basePackage")
@Namespace("/")
public class UserAction extends ActionSupport {
	
	private static final long serialVersionUID = 6912391687787646716L;
	private static final String FAIL = null;

	private IUserService userService;
	private User user;
	List<User> users;
	
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
	
	@Transactional
	@Action(value = "userAdd", results = {
			@Result(name = "success", type="redirect", location = "get"),
			@Result(name = "fail", location = "/jsp/fail.jsp") })
	public String addUser() {
		try {
			userService.addUser(user);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return FAIL;
		}
	}
	@Transactional
	@Action(value = "get", results = {
			@Result(name = "success", location = "/jsp/list.jsp"),
			@Result(name = "fail", location = "/jsp/fail.jsp") })
	public String getUsers() {
		try {
			users = userService.getUsers();
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("users", users);
			return SUCCESS;
		} catch (Exception e) {
			return FAIL;
		}
	}

}
