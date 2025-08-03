package com.java.foodSubscription.service.serviceImpl;

import com.java.foodSubscription.model.Order;
import com.java.foodSubscription.repository.OrderRepository;
import com.java.foodSubscription.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return List.of();
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.save(order);
    }
}
