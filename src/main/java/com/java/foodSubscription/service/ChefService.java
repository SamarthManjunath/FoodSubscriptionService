package com.java.foodSubscription.service;

import com.java.foodSubscription.model.Chef;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ChefService {
    Chef addChef(Chef chef);
    List<Chef> getChefs();
}
