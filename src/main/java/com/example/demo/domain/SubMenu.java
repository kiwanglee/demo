package com.example.demo.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="sub_menu")
public class SubMenu {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String name;
	private String url;
	@Column(name="create_time")
	private LocalDateTime createTime;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "sub_menu_role",
            joinColumns = @JoinColumn(name="id"),
            inverseJoinColumns = @JoinColumn(name="role"))
    private Set<Role> roles;

	public SubMenu() {
		this.createTime = LocalDateTime.now();
		this.roles = new HashSet<>();
	}
	
	public void addRole(Role role) {
		this.roles.add(role);
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
