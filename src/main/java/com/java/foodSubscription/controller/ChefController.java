package com.java.foodSubscription.controller;

import com.java.foodSubscription.model.Meals;
import com.java.foodSubscription.repository.MealsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ChefController {

    MealsRepository mealsRepository;

    //home page logic where we try to retrieve the meals posted by chef from database and show it to all users.
    @GetMapping("/home")
    private List<Meals> getMeals(){
        List<Meals> mealsList = new ArrayList<>();
        return mealsList;
    }
}
