package com.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Screen")
public class Screen {

	private int screenId;

	private String screenName;
	
	private Set<Role> roles;

	@Id
	@Column(name = "screenId", columnDefinition = "int")
	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	@Column(name = "screenName", columnDefinition = "VARCHAR(10)")
	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
	@ManyToMany(mappedBy="screens",cascade=CascadeType.ALL)
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
}
