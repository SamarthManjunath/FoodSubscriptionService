package com.java.foodSubscription.service.serviceImpl;

import com.java.foodSubscription.model.Food;
import com.java.foodSubscription.repository.FoodRepository;
import com.java.foodSubscription.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodRepository foodRepository;

    @Override
    public void addFood(Food food) {
        foodRepository.save(food);
    }

    @Override
    public List<Food> getFoods() {
        List<Food> foodList = foodRepository.findAll();
        return foodList;
    }
}
