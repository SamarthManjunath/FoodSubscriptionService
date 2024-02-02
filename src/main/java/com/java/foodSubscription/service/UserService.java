package com.java.foodSubscription.service;

import com.java.foodSubscription.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<Users> getAllUsers();

    public void addUser(Users user);
}
