package com.java.foodSubscription.controller;

import com.java.foodSubscription.model.Food;
import com.java.foodSubscription.model.Order;
import com.java.foodSubscription.model.Users;
import com.java.foodSubscription.repository.UserRepository;
import com.java.foodSubscription.service.FoodService;
import com.java.foodSubscription.service.OrderService;
import com.java.foodSubscription.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    FoodService foodService;

    @Autowired
    OrderService orderService;

    @PostMapping("/adduser")
    public ModelAndView addUser(@ModelAttribute Users users, HttpSession httpSession){
        System.out.println("Inside UserController.....");
        Users savedUser = userService.addUser(users);
        httpSession.setAttribute("user_id", savedUser.getId());
        System.out.println("User session ID before sending to dashboard: " + httpSession.getAttribute("user_id"));
        return new ModelAndView("redirect:/users");
    }

    //returns all foods posted by Chef
    @GetMapping("/users")
    public ModelAndView getAllFood(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("food");
        modelAndView.addObject("foods", foodService.getFoods());
        modelAndView.addObject("user_id", httpSession.getAttribute("user_id"));
        System.out.println("User session ID in food selection page:" +  httpSession.getAttribute("user_id")); //to log if landing page has access to user session attribute
        return modelAndView;
    }

    //returns tracking page after order is placed
    @GetMapping("/tracking")
    public ModelAndView getTrackingPage(HttpSession httpSession){
        //need to add session validation
        ModelAndView modelAndView = new ModelAndView("tracking");
        modelAndView.addObject("user_id", httpSession.getAttribute("user_id"));
        Object userIdObj = httpSession.getAttribute("user_id");
        Long userId = userIdObj != null
                ? ((Number) userIdObj).longValue()
                : null;
        System.out.println("User session ID in tracking page:" +  userId);
        List<Order> orders = orderService.getOrderByUserId(userId); //should return 1 order since user can place only 1 order at a time
        for (Order order : orders) {
            Food food1 = foodService.getFoodById(order.getFoodId1());
            Food food2 = foodService.getFoodById(order.getFoodId2());
            order.setFoodName1(food1 != null ? food1.getName() : "Unknown Food");
            order.setFoodName2(food2 != null ? food2.getName() : "Unknown Food");
        }
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }
}
