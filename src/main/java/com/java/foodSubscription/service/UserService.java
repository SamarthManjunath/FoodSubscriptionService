package com.java.foodSubscription.service;

import com.java.foodSubscription.model.Users;

import java.util.List;
import java.util.Optional;


public interface UserService {
    void addUser(Users users);
    List<Users> getUsers();

    Optional<Users> getUserById(int userId);
}
