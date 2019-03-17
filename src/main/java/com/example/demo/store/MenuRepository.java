package com.example.demo.store;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.domain.Menu;

public interface MenuRepository extends PagingAndSortingRepository<Menu, String> {
	
	List<Menu> findByParentMenuIdIsNull();
}
