package com.example.traceability;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.traceability.models.User;
import com.example.traceability.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository repo;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User userDetails= repo.findByUsername(username).get();
    System.out.println(userDetails);
       return userDetails;
    }
    
   
}
