package com.java.foodSubscription.repository;

import com.java.foodSubscription.model.Chef;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChefRepository extends JpaRepository<Chef, Integer> {

    // Method to find a Chef by their email
    Optional<Chef> findByEmail(String chefEmail);
}
