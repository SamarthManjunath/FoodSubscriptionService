package com.java.foodSubscription.service;

import com.java.foodSubscription.model.Chef;

import java.util.List;

public interface ChefService {
    void save(Chef chef);
    List<Chef> get();
    void delete(String id);
}
