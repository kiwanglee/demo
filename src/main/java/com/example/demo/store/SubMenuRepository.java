package com.example.demo.store;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.domain.SubMenu;

public interface SubMenuRepository extends PagingAndSortingRepository<SubMenu, String> {
}
