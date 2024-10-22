package com.example.mvcproducts.domain;

import org.springframework.beans.PropertyValues;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void clear() {
        products.clear();
    }

    public List<Product> getProducts() {
        return products;
    }



    // Optionally, you can add more functionalities as needed, e.g., getTotalPrice()
}