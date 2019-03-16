package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRole;
import com.example.demo.service.UserRoleService;
import com.example.demo.service.UserService;


@Component
public class DemoApplicationRunner implements ApplicationRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //initData();
        //userService.addUserRole("kiwang.lee@kurlycorp.com", "USER");
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

        UserRole role = null;
        role = new UserRole();
        role.setRole("USER");
        userRoleService.register(role);
        role.setRole("ADMIN");
        userRoleService.register(role);
    }
}
