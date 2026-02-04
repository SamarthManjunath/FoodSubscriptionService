package com.java.foodSubscription.controller;

import com.java.foodSubscription.dto.ChefLoginDTO;
import com.java.foodSubscription.model.Chef;
import com.java.foodSubscription.repository.ChefRepository;
import com.java.foodSubscription.service.ChefService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ChefController {
    @Autowired
    ChefService chefService;

    //End point to create a new chef
    @PostMapping("/addChef")
    public ModelAndView addChef(@ModelAttribute Chef chef, HttpSession httpSession){
        System.out.println("Inside addChef of ChefController....");
        Chef savedChef = chefService.addChef(chef);//since we are using auto generated id, we need to capture the saved chef object to get the generated id
        httpSession.setAttribute("chef_id", savedChef.getId());
        System.out.println("Chef session ID before sending to dashboard: " + httpSession.getAttribute("chef_id"));
        return new ModelAndView("redirect:/chef");
    }

    @GetMapping("/chefLogin")
    public ModelAndView chefLogin(@ModelAttribute ChefLoginDTO chef, HttpSession httpSession){
        System.out.println("Inside chefLogin of ChefController....");
        //check if the chef exists
        Optional<Chef> loggedInChef = chefService.getChef(chef);
        if(loggedInChef.isPresent()){ //if chef exists, set session attribute and redirect to chef landing page
            httpSession.setAttribute("chef_id", loggedInChef.get().getId());
            System.out.println("Chef session ID before sending to dashboard: " + httpSession.getAttribute("chef_id"));
            return new ModelAndView("redirect:/chef");
        }else { //if chef does not exist, redirect to login page
            return new ModelAndView("redirect:/ChefLogin");
        }
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
