package com.java.foodSubscription.service;

import com.java.foodSubscription.model.Food;
import com.java.foodSubscription.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAllOrders();
    void addOrder(Order order);
    Food getFoodById(int id);
    Optional<Order> getOrderById(Long id);
}
