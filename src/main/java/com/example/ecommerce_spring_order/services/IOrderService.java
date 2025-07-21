package com.example.ecommerce_spring_order.services;

import com.example.ecommerce_spring_order.dto.CreateOrderRequestDTO;
import com.example.ecommerce_spring_order.dto.OrderRequestDTO;

public interface IOrderService {
    CreateOrderRequestDTO createOrder(OrderRequestDTO orderRequestDTO);
}
