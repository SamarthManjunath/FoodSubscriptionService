package com.java.foodSubscription.service;

import com.java.foodSubscription.dto.ChefLoginDTO;
import com.java.foodSubscription.model.Chef;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ChefService {
    Chef addChef(Chef chef);
    Optional<Chef> getChef(ChefLoginDTO chef);
}
