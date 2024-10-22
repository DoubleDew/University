package com.example.mvcproducts.domain;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class OrderLineItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  private int qty;

  @ManyToOne
  @JoinColumn(name = "order_id")
  private ProductOrder order;

  public OrderLineItem() {
  }

  public OrderLineItem(Long id, Product product, int qty) {
    this.id = id;
    this.product = product;
    this.qty = qty;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrderLineItem that = (OrderLineItem) o;
    return qty == that.qty && Objects.equals(product, that.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(product, qty);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getQty() {
    return qty;
  }

  public void setQty(int qty) {
    this.qty = qty;
  }

  public void setOrder(ProductOrder productOrder) {
  }
}
