package com.java.foodSubscription.controller;

import com.java.foodSubscription.model.Food;
import com.java.foodSubscription.repository.FoodRepository;
import com.java.foodSubscription.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FoodController {
    @Autowired
    FoodService foodService;

    @PostMapping("/addFood")
    public ModelAndView addFood(@ModelAttribute Food food){
        foodService.addFood(food);
        return new ModelAndView("redirect:/order");
    }
}
