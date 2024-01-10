package com.java.foodSubscription.model;

import java.util.List;

public class Meals {
    private long dishId;
    private String dishName;
    private List<String> dishIngredients;
    private double dishPrice;
    private String dishImageUrl; //need to investigate further

    //getters and setters

    public long getDishId() {
        return dishId;
    }

    public void setDishId(long dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public List<String> getDishIngredients() {
        return dishIngredients;
    }

    public void setDishIngredients(List<String> dishIngredients) {
        this.dishIngredients = dishIngredients;
    }

    public double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(double dishPrice) {
        this.dishPrice = dishPrice;
    }

    public String getDishImageUrl() {
        return dishImageUrl;
    }

    public void setDishImageUrl(String dishImageUrl) {
        this.dishImageUrl = dishImageUrl;
    }
}
