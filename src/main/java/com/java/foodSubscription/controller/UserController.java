package com.java.foodSubscription.controller;

import com.java.foodSubscription.model.Food;
import com.java.foodSubscription.model.Users;
import com.java.foodSubscription.repository.UserRepository;
import com.java.foodSubscription.service.FoodService;
import com.java.foodSubscription.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    FoodService foodService;

    @PostMapping("/adduser")
    public ModelAndView addUser(@ModelAttribute Users users){
        userService.addUser(users);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/users")
    public ModelAndView getAllFood(){
        return new ModelAndView("food", "foods", foodService.getFoods());
    }
}
