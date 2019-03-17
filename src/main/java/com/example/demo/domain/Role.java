package com.example.demo.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="role")
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
    private String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<User> users;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<SubMenu> subMenus;
    
    @Override
    public String getAuthority() {
        return this.name;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public Set<SubMenu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(Set<SubMenu> subMenus) {
		this.subMenus = subMenus;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
