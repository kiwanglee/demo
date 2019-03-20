package com.example.demo.service;

import com.example.demo.domain.Role;
import com.example.demo.store.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation= Propagation.REQUIRED)
public class RoleService {

    @Autowired
    private RoleRepository userRoleRepository;

    public Role register(Role role) {
        return userRoleRepository.save(role);
    }

    public List<Role> findAll() {
        return (List<Role>)userRoleRepository.findAll();
    }

    public Role find(String role) {
        return userRoleRepository.findById(role).get();
    }
}
