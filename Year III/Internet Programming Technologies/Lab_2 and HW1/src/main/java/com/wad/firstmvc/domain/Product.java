package com.wad.firstmvc.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false, length = 50)
    private String category;

    public Product() {}

    public Product(Long id, String name, double price, String category)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public String getCategory(){
        return category;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setCategory(String category){
        this.category = category;
    }

}