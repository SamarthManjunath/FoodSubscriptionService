package com.java.foodSubscription.repository;

import com.java.foodSubscription.model.Order;
import com.java.foodSubscription.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatusNot(OrderStatus status);
    List<Order> findByUserId(Long userId);
}
