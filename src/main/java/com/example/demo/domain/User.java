package com.example.demo.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user")
public class User{

    @Id
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_user_role",
            joinColumns = @JoinColumn(name="email"),
            inverseJoinColumns = @JoinColumn(name="role"))
    private Set<UserRole> roles;

    @Override
    public String toString() {
        return "";
    }

    public User() {
        roles = new HashSet<>();
    }

    public void addUserRole(UserRole role) {
        roles.add(role);
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }
}