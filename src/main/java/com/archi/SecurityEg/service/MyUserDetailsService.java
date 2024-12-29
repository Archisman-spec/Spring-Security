package com.archi.SecurityEg.service;

import com.archi.SecurityEg.entity.UserPrincipal;
import com.archi.SecurityEg.entity.Users;
import com.archi.SecurityEg.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user =repo.findByUsername(username);

        if(user == null){
            System.out.println("Username not found");
            throw new UsernameNotFoundException("user not found!");
        }

        return new UserPrincipal(user);
    }

}