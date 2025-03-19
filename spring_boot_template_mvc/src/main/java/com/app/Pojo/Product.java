package com.app.Pojo;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(nullable = false, unique = true)
    private String hsnCode;

    @Column(nullable = false)
    private String productName;

    private String productMake;

    @Column(nullable = false)
    private double price;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<User> users;
}
