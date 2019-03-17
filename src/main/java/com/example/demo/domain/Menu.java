package com.example.demo.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="menu")
public class Menu {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String name;
	private String url;
	@Column(name="create_time")
	private LocalDateTime createTime;
	@Column(name="update_time")
	private LocalDateTime updateTime;
	
	private int depth;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "menu_role",
            joinColumns = @JoinColumn(name="id"),
            inverseJoinColumns = @JoinColumn(name="role"))
    private Set<Role> roles;
	
	@Column(name="parent_menu_id")
	private String parentMenuId;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="parent_menu_id")
	private Set<Menu> subMenus;

	public Menu() {
		this.createTime = LocalDateTime.now();
		this.updateTime = LocalDateTime.now();
		this.roles = new HashSet<>();
		this.subMenus = new HashSet<>();
		this.depth = 1;
	}
	
	public void addRole(Role role) {
		this.roles.add(role);
	}
	
	public void addSubMenu(Menu menu) {
		menu.setDepth(this.depth+1);
		this.subMenus.add(menu);
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

	public Set<Menu> getSubMenus() {
		return subMenus;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public void setSubMenus(Set<Menu> subMenus) {
		this.subMenus = subMenus;
	}

	public String getParentMenuId() {
		return parentMenuId;
	}

	public void setParentMenuId(String parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
}
