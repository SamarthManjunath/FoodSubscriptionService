package com.java.foodSubscription.controller;

import com.java.foodSubscription.model.Chef;
import com.java.foodSubscription.repository.ChefRepository;
import com.java.foodSubscription.service.ChefService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChefController {
    @Autowired
    ChefService chefService;

    //End point to create a new chef
    @PostMapping("/addChef")
    public ModelAndView addChef(@ModelAttribute Chef chef, HttpSession httpSession){
        System.out.println("Inside ChefController.....");
        Chef savedChef = chefService.addChef(chef);//since we are using auto generated id, we need to capture the saved chef object to get the generated id
        httpSession.setAttribute("chef_id", savedChef.getId());
        System.out.println("Chef session ID before sending to dashboard: " + httpSession.getAttribute("chef_id"));
        return new ModelAndView("redirect:/chef");
    }

    //end point is triggered by addChef() to go to chef landing page
   @GetMapping("/chef")
    public ModelAndView getChefLandingPage(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("chef");
        System.out.println("Chef session ID in chef dashboard page:" +  httpSession.getAttribute("chef_id")); //to log if landing page has access to chef session attribute
        modelAndView.addObject("chef_id", httpSession.getAttribute("chef_id"));
        return modelAndView;
    }
}
