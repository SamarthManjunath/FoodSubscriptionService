package com.java.foodSubscription.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Users user;
    
    // Transient fields for food names (not stored in database)
    @Transient
    private String foodName1;
    
    @Transient
    private String foodName2;

    // JPA requires a no-args constructor
    public Order() {
    }
    
    // Constructor for creating new orders
    public Order(int foodId1, int foodId2) {
        this.foodId1 = foodId1;
        this.foodId2 = foodId2;
    }

    //getters and setters
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
    
    public String getFoodName1() {
        return foodName1;
    }
    
    public void setFoodName1(String foodName1) {
        this.foodName1 = foodName1;
    }
    
    public String getFoodName2() {
        return foodName2;
    }
    
    public void setFoodName2(String foodName2) {
        this.foodName2 = foodName2;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }



}
