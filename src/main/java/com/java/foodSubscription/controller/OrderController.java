package com.java.foodSubscription.controller;

import com.java.foodSubscription.model.Food;
import com.java.foodSubscription.model.Order;
import com.java.foodSubscription.model.OrderStatus;
import com.java.foodSubscription.model.Users;
import com.java.foodSubscription.service.FoodService;
import com.java.foodSubscription.service.OrderService;
import com.java.foodSubscription.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("user_id")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;
    @PostMapping("/addOrder")
    public ModelAndView addOrder(@RequestParam("selectedFoods")List<Integer> selectedFoods,
                                 @RequestParam("user_id")int userId){
        Optional<Users> userOptional = userService.getUserById(userId);
        //for logging purpose
        System.out.println("User ID is: " + userId);

        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            LocalDateTime localDateTime = LocalDateTime.now();
            Order order = new Order(selectedFoods.get(0), selectedFoods.get(1), localDateTime);
            order.setUser(user);
            orderService.addOrder(order);
            return new ModelAndView("redirect:/tracking");
        } else {
            System.out.println("User not found with ID: " + userId);
            return new ModelAndView("error");
        }
    }

    //end point to show all orders to chef
    @Autowired
    private FoodService foodService;

    @GetMapping("/order")
    public ModelAndView showAllOrders(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("order");
        modelAndView.addObject("chef_id", httpSession.getAttribute("chef_id"));
        List<Order> orders = orderService.getAllOrders();
        // Add food names to each order
        for (Order order : orders) {
            Food food1 = foodService.getFoodById(order.getFoodId1());
            Food food2 = foodService.getFoodById(order.getFoodId2());
            order.setFoodName1(food1 != null ? food1.getName() : "Unknown Food");
            order.setFoodName2(food2 != null ? food2.getName() : "Unknown Food");
        }
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }

    @GetMapping("/tracking")
    public String getTrackingPage(){
        return "tracking";
    }

    @PostMapping("/order/updateStatus")
    public String updateOrderStatus(@RequestParam("orderId") int orderId,
                                    @RequestParam("status") String status) {
        Optional<Order> orderOptional = orderService.getOrderById((long)orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setStatus(OrderStatus.fromString(status));
            orderService.addOrder(order); // This will update the existing order
        }
        return "redirect:/order";
    }
}
