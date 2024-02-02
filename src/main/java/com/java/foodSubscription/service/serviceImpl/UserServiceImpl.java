package com.java.foodSubscription.service.serviceImpl;

import com.java.foodSubscription.model.Users;
import com.java.foodSubscription.repository.UserRepository;
import com.java.foodSubscription.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Users> getAllUsers() {
        Iterable<Users> users = this.userRepository.findAll();
        System.out.println(users);
        List<Users> usersList = new ArrayList<>();
        users.forEach(
                user -> {
                    usersList.add(user);
                }
        );
        return usersList;
    }

    @Override
    public void addUser(Users user) {
        this.userRepository.save(user);
    }
}
