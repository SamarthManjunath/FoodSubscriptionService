package com.java.foodSubscription.controller;

import com.java.foodSubscription.model.Order;
import com.java.foodSubscription.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/addOrder")
    public ModelAndView addOrder(@RequestParam("selectedFoods")List<Integer> selectedFoods){
        Order order = new Order(selectedFoods.get(0), selectedFoods.get(1));
        orderService.addOrder(order);
        return new ModelAndView("redirect:/tracking");
    }

    //end point to show all orders
    @GetMapping("/order")
    public String getAllOrders(){
        return "Order";
    }

    @GetMapping("/tracking")
    public String getTrackingPage(){
        return "tracking";
    }
}
