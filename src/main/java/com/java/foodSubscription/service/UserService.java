package com.java.foodSubscription.service;

import com.java.foodSubscription.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    void addUser(Users users);
    List<Users> getUsers();
}
