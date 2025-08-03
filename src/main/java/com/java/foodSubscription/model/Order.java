package com.java.foodSubscription.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "foodId1")
    private int foodId1;
    @Column(name = "foodId2")
    private int foodId2;

    public Order(int foodId1, int foodId2) {
        this.foodId1 = foodId1;
        this.foodId2 = foodId2;
    }

    public int getFoodId1() {
        return foodId1;
    }

    public void setFoodId1(int foodId1) {
        this.foodId1 = foodId1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoodId2() {
        return foodId2;
    }

    public void setFoodId2(int foodId2) {
        this.foodId2 = foodId2;
    }



}
