package com.java.foodSubscription.controller;
import com.java.foodSubscription.model.Users;
import com.java.foodSubscription.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @PostMapping("/users")
    public void addUser(@RequestBody Users user){
        this.userService.addUser(user);
    }
}
