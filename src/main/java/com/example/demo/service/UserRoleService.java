package com.example.demo.service;

import com.example.demo.domain.UserRole;
import com.example.demo.store.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation= Propagation.REQUIRED)
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public UserRole register(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    public List<UserRole> findAll() {
        return (List<UserRole>)userRoleRepository.findAll();
    }

    public UserRole find(String role) {
        return userRoleRepository.findById(role).get();
    }
}
