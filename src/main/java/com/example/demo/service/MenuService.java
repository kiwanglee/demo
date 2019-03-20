package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

	public List<Menu> registerAll(List<Menu> menus) {
		return (List<Menu>) menuRoleRepository.saveAll(menus);
	}
	
	public Menu find(String id) {
		return menuRoleRepository.findById(id).get();
	}
	
	public List<Menu> findAll() {
		return menuRoleRepository.findByParentMenuIdIsNull();
	}

	public List<Menu> findByRole(String roleName) {

		Role role = roleRepository.findById(roleName).get();

		List<Menu> menus = (List<Menu>) menuRoleRepository.findAll();
		List<Menu> filteredMenus = new ArrayList<>();
		for (Menu menu : menus) {
			if(menu.existsRole(role.getName())) {
				menu.filterSubMenuByRole(role.getName());
				filteredMenus.add(menu);
			}
		}

		return filteredMenus;
	}

	public Menu addRole(String id, String roleName) {
		
		Menu menu = menuRoleRepository.findById(id).get();
		Role role = roleRepository.findById(roleName).get();
		menu.addRole(role);
		return menu;
	}
}
