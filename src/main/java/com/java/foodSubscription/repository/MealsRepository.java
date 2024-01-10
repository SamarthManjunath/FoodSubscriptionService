package com.java.foodSubscription.repository;

import com.java.foodSubscription.model.Meals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealsRepository extends JpaRepository<Meals, Long> {
}
