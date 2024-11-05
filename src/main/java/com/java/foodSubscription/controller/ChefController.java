package com.java.foodSubscription.controller;

import com.java.foodSubscription.model.Chef;
import com.java.foodSubscription.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChefController {
    @Autowired
    ChefService chefService;
    @RequestMapping("/addChef")
    public Chef addChef(@ModelAttribute("addChef") Chef chef){
        chefService.save(chef);
        return chef;
    }
}
