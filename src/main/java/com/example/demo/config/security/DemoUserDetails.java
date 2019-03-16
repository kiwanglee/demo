package com.example.demo.config.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.domain.User;

public class DemoUserDetails extends User implements UserDetails {

	private static final long serialVersionUID = 1L;

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
