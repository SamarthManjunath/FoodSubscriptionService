package com.java.foodSubscription.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "chef")
@Data
public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
   private int id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

}
