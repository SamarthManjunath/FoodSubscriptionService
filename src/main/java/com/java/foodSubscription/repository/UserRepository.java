package com.java.foodSubscription.repository;

import com.java.foodSubscription.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
}
