package com.java.foodSubscription.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @Column(name = "orderid")
    private long orderId;
    @Column(name = "orderstatus")
    private String orderStatus;
    @Column(name = "userid")
    private long userId;
//    @Column(name = "meallist")
//    private List<Meals> mealList;
    @Column(name = "dateplaced")
    private Date datePlaced;
    @Column(name = "totalprice")
    private long totalPrice;


    //getters and setters

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

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

//    public List<Meals> getMealList() {
//        return mealList;
//    }
//
//    public void setMealList(List<Meals> mealList) {
//        this.mealList = mealList;
//    }

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
