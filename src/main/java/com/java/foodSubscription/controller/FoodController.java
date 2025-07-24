package com.java.foodSubscription.controller;

import com.java.foodSubscription.model.Food;
import com.java.foodSubscription.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FoodController {
    @Autowired
    FoodRepository foodRepository;

    @PostMapping("/addFood")
    public ModelAndView addFood(@ModelAttribute Food food){
        foodRepository.save(food);
        return new ModelAndView("redirect:/order");
    }

    @GetMapping("/order")
    public String showCurrentOrders(){
        return "order";
    }
}
