package com.java.foodSubscription.service;

import com.java.foodSubscription.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    void addOrder(Order order);
}
