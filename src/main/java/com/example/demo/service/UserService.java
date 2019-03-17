package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.domain.Role;
import com.example.demo.store.UserRepository;
import com.example.demo.store.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation= Propagation.REQUIRED)
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository userRoleRepository;

    public User register(User User) {
        return userRepository.save(User);
    }

    public List<User> findAll() {
        return (List<User>)userRepository.findAll();
    }

    public User find(String role) {
        return userRepository.findById(role).get();
    }


    public User addUserRole(String email, String role) {

        User user = userRepository.findById(email).get();
        Role userRole = userRoleRepository.findById(role).get();
        user.addUserRole(userRole);
        return user;
    }
}
