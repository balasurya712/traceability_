package com.example.traceability.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.traceability.models.User;
import com.example.traceability.repository.UserRepository;
import com.example.traceability.service.UserServiceInterface;

@Service
public class UserServiceCollection implements UserServiceInterface{
     @Autowired
    UserRepository repo;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public List<User> getAllUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUser'");
    }

    public User saveData(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public List<User> findUser (){
        return repo.findAll();
        // return repo.findAll().stream().map(User::new).toList();
    }

    public List<User> findUserAll (){
        return repo.findAll();
    }
    
}
