package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Role;
import com.example.demo.domain.Menu;
import com.example.demo.store.RoleRepository;
import com.example.demo.store.MenuRepository;

@Service
@Transactional(propagation= Propagation.REQUIRED)
public class MenuService {

	@Autowired
	private MenuRepository menuRoleRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Menu register(Menu menu) {
		return menuRoleRepository.save(menu);
	}
	
	public Menu find(String id) {
		return menuRoleRepository.findById(id).get();
	}
	
	public List<Menu> findAll() {
		return menuRoleRepository.findByParentMenuIdIsNull();
	}
	
	public Menu addRole(String id, String roleName) {
		
		Menu menu = menuRoleRepository.findById(id).get();
		Role role = roleRepository.findById(roleName).get();
		menu.addRole(role);
		return menu;
	}
}
