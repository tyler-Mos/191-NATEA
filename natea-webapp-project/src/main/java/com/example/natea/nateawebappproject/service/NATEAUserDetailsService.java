package com.example.natea.nateawebappproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.example.natea.nateawebappproject.model.User;

@Service
public class NATEAUserDetailsService implements UserDetailsService {

    //private final NATEAUserDaoService userDao;
    @Autowired
    NATEAUserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*
        return userDao.selectUserByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s not found", username)));
            */
        Optional<User> user = userRepo.findByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException("User Not found: " + username));
        return user.map(NATEAUserDetails::new).get();
        //return buildUser(user);
    }



}