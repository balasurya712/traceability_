package com.example.traceability.service;

import java.util.List;

import com.example.traceability.models.User;

public interface UserServiceInterface {
    
    // User getById(String id);

    List<User> getAllUser();

    User saveData(User user);

    // User updateData(User user);

    // Boolean deleteData(String id);
}
