package com.example.demo.config.security;

import com.example.demo.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class DemoUserDetails extends User implements UserDetails {

    public DemoUserDetails(User user) {

        super.setEmail(user.getEmail());
        super.setPassword(user.getPassword());
        super.setRoles(user.getRoles());
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return super.getRoles();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
