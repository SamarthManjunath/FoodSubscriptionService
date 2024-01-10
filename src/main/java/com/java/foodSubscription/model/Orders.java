package com.java.foodSubscription.model;

import java.util.Date;
import java.util.List;

public class Orders {
    private String orderStatus;
    private long userId;
    private List<Meals> mealList;
    private Date datePlaced;
    private long totalPrice;

    //getters and setters

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<Meals> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meals> mealList) {
        this.mealList = mealList;
    }

    public Date getDatePlaced() {
        return datePlaced;
    }

    public void setDatePlaced(Date datePlaced) {
        this.datePlaced = datePlaced;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
