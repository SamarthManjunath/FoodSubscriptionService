package com.java.foodSubscription.controller;

import com.java.foodSubscription.model.Food;
import com.java.foodSubscription.model.Users;
import com.java.foodSubscription.repository.UserRepository;
import com.java.foodSubscription.service.FoodService;
import com.java.foodSubscription.service.UserService;
import jakarta.servlet.http.HttpSession;
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
    public ModelAndView addUser(@ModelAttribute Users users, HttpSession session){
        userService.addUser(users);
        session.setAttribute("user_id", users.getId());
        return new ModelAndView("redirect:/users");
    }

    //returns all foods posted by Chef
    @GetMapping("/users")
    public ModelAndView getAllFood(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("food");
        modelAndView.addObject("foods", foodService.getFoods());
        modelAndView.addObject("user_id", session.getAttribute("user_id"));
        return modelAndView;
    }
}
