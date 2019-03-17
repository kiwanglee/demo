package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Role;
import com.example.demo.domain.SubMenu;
import com.example.demo.domain.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.SubMenuService;
import com.example.demo.service.UserService;


@Component
public class DemoApplicationRunner implements ApplicationRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private SubMenuService subMenuService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //initData();
        //userService.addUserRole("bartwars@naver.com", "USER");
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
        
        SubMenu subMenu = null;
        subMenu = new SubMenu();
        subMenu.setName("권역관리");
        subMenu.setUrl("/user");
        subMenu = subMenuService.register(subMenu);
        subMenuService.addRole(subMenu.getId(), "USER");
    }
}
