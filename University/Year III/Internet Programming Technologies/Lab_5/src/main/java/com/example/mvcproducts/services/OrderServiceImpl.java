package com.example.mvcproducts.services;

import com.example.mvcproducts.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
  @SuppressWarnings("unused")
  private final OrderRepository orderRepository;

  public OrderServiceImpl(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }
}
