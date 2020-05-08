package com.example.natea.nateawebappproject.service;

import java.util.Arrays;
import java.util.Collection;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.example.natea.nateawebappproject.model.User;

public class NATEAUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    //private List<GrantedAuthority> authorities;


    public NATEAUserDetails(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        //this.authorities = 
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO: hard coded for now
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO: hard coded for now
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO: hard coded for now
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO: hard coded for now
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO hard coded for now
        return true;
    }

}