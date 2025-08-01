package com.java.foodSubscription.service.serviceImpl;

import com.java.foodSubscription.model.Chef;
import com.java.foodSubscription.repository.ChefRepository;
import com.java.foodSubscription.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChefServiceImpl implements ChefService {
    @Autowired
    ChefRepository chefRepository;

    @Override
    public void addChef(Chef chef) {
        chefRepository.save(chef);
    }

    @Override
    public List<Chef> getChefs() {
        return List.of();
    }
}
