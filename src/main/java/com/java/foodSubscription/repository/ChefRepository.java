package com.java.foodSubscription.repository;

import com.java.foodSubscription.model.Chef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChefRepository extends JpaRepository<Chef, Long> {
}
