package com.java.foodSubscription.service;

import com.java.foodSubscription.model.Food;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FoodService {
    void addFood(Food food);
    List<Food> getFoods();
}
