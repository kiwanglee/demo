package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Role;
import com.example.demo.domain.SubMenu;
import com.example.demo.store.RoleRepository;
import com.example.demo.store.SubMenuRepository;

@Service
@Transactional(propagation= Propagation.REQUIRED)
public class SubMenuService {

	@Autowired
	private SubMenuRepository subMenuRoleRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public SubMenu register(SubMenu subMenu) {
		return subMenuRoleRepository.save(subMenu);
	}
	
	public SubMenu find(String id) {
		return subMenuRoleRepository.findById(id).get();
	}
	
	public List<SubMenu> findAll() {
		return (List<SubMenu>) subMenuRoleRepository.findAll();
	}
	
	public SubMenu addRole(String id, String roleName) {
		
		SubMenu subMenu = subMenuRoleRepository.findById(id).get();
		Role role = roleRepository.findById(roleName).get();
		subMenu.addRole(role);
		return subMenu;
	}
}
