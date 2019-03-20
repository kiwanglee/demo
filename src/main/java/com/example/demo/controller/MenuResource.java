package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Menu;
import com.example.demo.service.MenuService;

@RestController
@RequestMapping("menus")
public class MenuResource {

	@Autowired
	private MenuService menuService;
	
	@GetMapping
	public List<Menu> findAll() {
		
		return menuService.findAll();
	}

	@GetMapping("role/{role}")
	public List<Menu> findByRole(@PathVariable("role") String role) {

		return menuService.findByRole(role);
	}
}
