package com.example.mvcproducts.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products;

    public Cart() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product, products.getOrDefault(product, 0) + 1);
    }

    public void removeProduct(Product product) {
        if (products.containsKey(product) && products.get(product) > 1) {
            products.put(product, products.get(product) - 1);
        } else {
            products.remove(product);
        }
    }

    public void clear() {
        products.clear();
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
}
