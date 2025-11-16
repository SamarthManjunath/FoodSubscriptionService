package com.java.foodSubscription.service;

import com.java.foodSubscription.model.Order;
import com.java.foodSubscription.model.OrderStatus;
import com.java.foodSubscription.repository.OrderRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@EnableScheduling
@EnableAsync
public class OrderStatusScheduler {

    private final OrderRepository orderRepository;

    public OrderStatusScheduler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Async
    @Scheduled(fixedRate = 60000) // Run every minute
    @Transactional
    public void updateOrderStatuses() {
        List<Order> orders = orderRepository.findByStatusNot(OrderStatus.DELIVERED);
        LocalDateTime now = LocalDateTime.now();

        for (Order order : orders) {

            // Fallback / initialization for null timestamps
            LocalDateTime lastUpdated = order.getStatusUpdatedAt();
            if (lastUpdated == null) {
                // Use orderDate if available, else initialize to now
                lastUpdated = order.getOrderDate() != null ? order.getOrderDate() : now;
                order.setStatusUpdatedAt(lastUpdated);
                // don’t `continue` – we can still process status transitions based on lastUpdated
            }

            long minutesSinceLastUpdate = Duration.between(lastUpdated, now).toMinutes();

            switch (order.getStatus()) {
                case RECEIVED:
                    if (minutesSinceLastUpdate >= 2) {
                        updateOrderStatus(order, OrderStatus.PREPARING);
                    }
                    break;
                case PREPARING:
                    if (minutesSinceLastUpdate >= 5) {
                        updateOrderStatus(order, OrderStatus.DONE);
                    }
                    break;
                case DONE:
                    if (minutesSinceLastUpdate >= 15) {
                        updateOrderStatus(order, OrderStatus.DELIVERED);
                    }
                    break;
                default:
                    // DELIVERED is already filtered out, but safe to have a default
                    break;
            }
        }
    }

    private void updateOrderStatus(Order order, OrderStatus newStatus) {
        order.setStatus(newStatus);
        order.setStatusUpdatedAt(LocalDateTime.now());
        orderRepository.save(order);
    }
}