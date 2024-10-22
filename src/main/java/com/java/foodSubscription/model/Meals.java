package com.java.foodSubscription.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "meals")
public class Meals {
    @Id
    @Column(name = "mealId")
    private long mealId;
    @Column(name = "mealName")
    private String mealName;
    //private List<String> mealIngredients; -> Needs to be handled
    @Column(name = "mealPrice")
    private int mealPrice;
    //@Column(name = "mealImageUrl")
    //private String mealImageUrl; //need to handle images

}
