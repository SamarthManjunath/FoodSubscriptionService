package com.java.foodSubscription.controller;

import com.java.foodSubscription.model.Chef;
import com.java.foodSubscription.repository.ChefRepository;
import com.java.foodSubscription.service.ChefService;
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
    public ModelAndView addChef(@ModelAttribute Chef chef){
        chefService.addChef(chef);
        return new ModelAndView("redirect:/chef");
    }

   @GetMapping("/chef")
    public String listChefs(){
       return "chef";
    }
}
