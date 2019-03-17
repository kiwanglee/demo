package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.SubMenu;
import com.example.demo.service.SubMenuService;

@RestController
@RequestMapping("submenus")
public class SubMenuResource {

	@Autowired
	private SubMenuService subMenuService;
	
	@GetMapping
	public List<SubMenu> findAll() {
		
		return subMenuService.findAll();
	}
}
