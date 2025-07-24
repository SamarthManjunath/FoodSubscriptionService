package com.java.foodSubscription.repository;

import com.java.foodSubscription.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
