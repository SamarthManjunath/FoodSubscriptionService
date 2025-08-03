package com.java.foodSubscription.repository;

import com.java.foodSubscription.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
