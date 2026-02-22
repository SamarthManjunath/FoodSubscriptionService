package com.java.foodSubscription.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "foodId1")
    private int foodId1;
    @Column(name = "foodId2")
    private int foodId2;
    @Column(name = "orderDate")
    private LocalDateTime orderDate;
    
    @Convert(converter = OrderStatusConverter.class)
    @Column(name = "status")
    private OrderStatus status = OrderStatus.RECEIVED;
    
    @Column(name = "status_updated_at")
    private LocalDateTime statusUpdatedAt = LocalDateTime.now();
    @ManyToOne(fetch = FetchType.LAZY) //allows multiple orders for one user
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
    public Order(int foodId1, int foodId2, LocalDateTime orderDate) {
            this.foodId1 = foodId1;
            this.foodId2 = foodId2;
            this.orderDate = orderDate;
            this.status = OrderStatus.RECEIVED; // Restore this line
            this.statusUpdatedAt = LocalDateTime.now();
        }
}
