package com.java.foodSubscription.service.serviceImpl;

import com.java.foodSubscription.model.Users;
import com.java.foodSubscription.repository.UserRepository;
import com.java.foodSubscription.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(Users users) {
        userRepository.save(users);
    }

    @Override
    public List<Users> getUsers() {
        return List.of();
    }

    @Override
    public Optional<Users> getUserById(int userId) {
        //Long longUserId = userId;
        return userRepository.findById(userId);
    }

}
