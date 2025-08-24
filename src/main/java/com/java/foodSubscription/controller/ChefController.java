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

    //this has been tested and working fine
    @PostMapping("/addChef")
    public ModelAndView addChef(@ModelAttribute Chef chef, HttpSession httpSession){
        chefService.addChef(chef);
        httpSession.setAttribute("chef_id", chef.getId());
        return new ModelAndView("redirect:/chef");
    }

   @GetMapping("/chef")
    public ModelAndView getChefLandingPage(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("chef");
        modelAndView.addObject("chef_id", httpSession.getAttribute("chef_id"));
        return modelAndView;
    }
}
