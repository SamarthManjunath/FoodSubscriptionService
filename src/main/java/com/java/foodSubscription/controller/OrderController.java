package com.java.foodSubscription.controller;

import com.java.foodSubscription.model.Order;
import com.java.foodSubscription.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/addOrder")
    public void allOrder(@ModelAttribute Order order){
        orderService.addOrder(order);
        //TODO: after user places order, we need to take them to order tracking page
    }
}
