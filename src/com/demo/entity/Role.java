package com.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.Table;


@Entity
@Table(name = "Role")
public class Role {

	private int roleId;

	private String roleName;
	
	private Set<User> users;
	
	private Set<Screen> screens;
	
	@Id
	@Column(name="roleId", columnDefinition="int")
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Column(name = "roleName", columnDefinition = "VARCHAR(50)")
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@ManyToMany(mappedBy="roles",cascade=CascadeType.ALL)
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	@ManyToMany(cascade=CascadeType.ALL)
	@MapKey(name="id")
	@JoinTable(
            name="authority",
            joinColumns=@JoinColumn(name="roleId"),
            inverseJoinColumns=@JoinColumn(name="screenId")
    )
	public Set<Screen> getScreens() {
		return screens;
	}

	public void setScreens(Set<Screen> screens) {
		this.screens = screens;
	}
	
	

}
