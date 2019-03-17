package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Menu;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.service.MenuService;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;


@Component
public class DemoApplicationRunner implements ApplicationRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        initData();
    	initMenuData();
        userService.addUserRole("bartwars@naver.com", "USER");
    }

    private void initData() {
        User user = null;
        user = new User();
        user.setEmail("bartwars@naver.com");
        user.setPassword("$2a$10$m5WHglgDdSROkKtwn6Vd6evnaJhYOifLs7YQ0ZyquejFttUmxJhPK");
        userService.register(user);
        user = new User();
        user.setEmail("kiwang.lee@kurlycorp.com");
        user.setPassword("$2a$10$m5WHglgDdSROkKtwn6Vd6evnaJhYOifLs7YQ0ZyquejFttUmxJhPK");
        userService.register(user);
        user = new User();
        user.setEmail("minsoo.kim@kurlycorp.com");
        user.setPassword("$2a$10$m5WHglgDdSROkKtwn6Vd6evnaJhYOifLs7YQ0ZyquejFttUmxJhPK");
        userService.register(user);
        user = new User();
        user.setEmail("jaesung.hong@kurlycorp.com");
        user.setPassword("$2a$10$m5WHglgDdSROkKtwn6Vd6evnaJhYOifLs7YQ0ZyquejFttUmxJhPK");
        userService.register(user);
        user = new User();
        user.setEmail("chungguen.ryu@kurlycorp.com");
        user.setPassword("$2a$10$m5WHglgDdSROkKtwn6Vd6evnaJhYOifLs7YQ0ZyquejFttUmxJhPK");
        userService.register(user);

        Role role = null;
        role = new Role();
        role.setName("USER");
        roleService.register(role);
        role.setName("ADMIN");
        roleService.register(role);
        
    }
    
    private void initMenuData() {
    	Menu menu = null;
        Menu subMenu = null;
        Menu subMenu2 = null;
        
        menu = new Menu();
        menu.setName("배송관리");
        menu.setUrl("/");
        menu.setDepth(1);
        	subMenu = new Menu();
        	subMenu.setName("배송마스터관리");
        	subMenu.setUrl("/");
        	subMenu.setDepth(2);
        		subMenu2 = new Menu();
        		subMenu2.setName("권역관리");
        		subMenu2.setUrl("/");
            	subMenu.addSubMenu(subMenu2);
            	subMenu2 = new Menu();
            	subMenu2.setName("배송매니저");
            	subMenu2.setUrl("/");
            	subMenu.addSubMenu(subMenu2);
            	subMenu2 = new Menu();
            	subMenu2.setName("우편번호 권역관리");
            	subMenu2.setUrl("/");
            	subMenu.addSubMenu(subMenu2);
        	menu.addSubMenu(subMenu);
        	subMenu = new Menu();
        	subMenu.setName("배송마스터관리(일)");
        	subMenu.setUrl("/");
        	subMenu.setDepth(2);
	        	subMenu2 = new Menu();
	    		subMenu2.setName("권역관리(일)");
	    		subMenu2.setUrl("/");
	        	subMenu.addSubMenu(subMenu2);
	        	subMenu2 = new Menu();
        		subMenu2.setName("배송매니저(일)");
        		subMenu2.setUrl("/");
            	subMenu.addSubMenu(subMenu2);
            	subMenu2 = new Menu();
        		subMenu2.setName("우편번호 권역관리(일)");
        		subMenu2.setUrl("/");
            	subMenu.addSubMenu(subMenu2);
        	menu.addSubMenu(subMenu);
        	subMenu = new Menu();
        	subMenu.setName("배송마스터관리(월)");
        	subMenu.setUrl("/");
        	subMenu.setDepth(2);
	        	subMenu2 = new Menu();
	    		subMenu2.setName("권역관리(월)");
	    		subMenu2.setUrl("/");
	        	subMenu.addSubMenu(subMenu2);
	        	subMenu2 = new Menu();
	        	subMenu2.setName("배송매니저(월)");
	        	subMenu2.setUrl("/");
	        	subMenu.addSubMenu(subMenu2);
	        	subMenu2 = new Menu();
	        	subMenu2.setName("우편번호 권역관리(월)");
	        	subMenu2.setUrl("/");
	        	subMenu.addSubMenu(subMenu2);
        	menu.addSubMenu(subMenu);
        	subMenu = new Menu();
        	subMenu.setName("배차계획(선배차)");
        	subMenu.setUrl("/");
        	subMenu.setDepth(2);
	        	subMenu2 = new Menu();
	    		subMenu2.setName("권역(선배차)");
	    		subMenu2.setUrl("/");
	        	subMenu.addSubMenu(subMenu2);
	        	subMenu2 = new Menu();
	    		subMenu2.setName("배차계획(선배차)");
	    		subMenu2.setUrl("/");
	        	subMenu.addSubMenu(subMenu2);
        	menu.addSubMenu(subMenu);
        menuService.register(menu);
        
        menu = new Menu();
        menu.setName("시스템관리");
        menu.setUrl("/");
        menu.setDepth(1);
        	subMenu = new Menu();
        	subMenu.setName("사용자관리");
        	subMenu.setUrl("/");
        	subMenu.setDepth(2);
        		subMenu2 = new Menu();
        		subMenu2.setName("사용자");
        		subMenu2.setUrl("/");
            	subMenu.addSubMenu(subMenu2);
            	subMenu2 = new Menu();
            	subMenu2.setName("메뉴");
            	subMenu2.setUrl("/");
            	subMenu.addSubMenu(subMenu2);
        	menu.addSubMenu(subMenu);
        	subMenu = new Menu();
        	subMenu.setName("딕셔너리");
        	subMenu.setUrl("/");
        	subMenu.setDepth(2);
	        	subMenu2 = new Menu();
	        	subMenu2.setName("데이터사전");
	        	subMenu2.setUrl("/");
	        	subMenu.addSubMenu(subMenu2);
	        	subMenu2 = new Menu();
	        	subMenu2.setName("라벨");
	        	subMenu2.setUrl("/");
	        	subMenu.addSubMenu(subMenu2);
	        	subMenu2 = new Menu();
	        	subMenu2.setName("메시지");
	        	subMenu2.setUrl("/");
	        	subMenu.addSubMenu(subMenu2);
	        	subMenu2 = new Menu();
	        	subMenu2.setName("서치헬프");
	        	subMenu2.setUrl("/");
	        	subMenu.addSubMenu(subMenu2);
	        	subMenu2 = new Menu();
	        	subMenu2.setName("프로그램");
	        	subMenu2.setUrl("/");
	        	subMenu.addSubMenu(subMenu2);
        	menu.addSubMenu(subMenu);
        	subMenu = new Menu();
        	subMenu.setName("인터페이스관리");
        	subMenu.setUrl("/");
        	subMenu.setDepth(2);
	        	subMenu2 = new Menu();
	        	subMenu2.setName("인터페이스 조회");
	        	subMenu2.setUrl("/");
	        	subMenu.addSubMenu(subMenu2);
        	menu.addSubMenu(subMenu);
        menuService.register(menu);
    }
}
