package com.java.foodSubscription.service.serviceImpl;

import com.java.foodSubscription.model.Food;
import com.java.foodSubscription.model.Order;
import com.java.foodSubscription.repository.OrderRepository;
import com.java.foodSubscription.service.FoodService;
import com.java.foodSubscription.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private FoodService foodService;

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        // Eagerly fetch user for each order
        orders.forEach(order -> {
            if (order.getUser() != null) {
                // This will initialize the user proxy if it's a lazy-loaded relationship
                order.getUser().getFirstName();
            }
        });
        return orders;
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.save(order);
    }
    
    @Override
    public Food getFoodById(int id) {
        return foodService.getFoodById(id);
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getOrderByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
