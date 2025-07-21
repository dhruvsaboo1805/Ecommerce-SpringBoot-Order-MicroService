package com.example.ecommerce_spring_order.controllers;

import com.example.ecommerce_spring_order.dto.CreateOrderRequestDTO;
import com.example.ecommerce_spring_order.dto.OrderRequestDTO;
import com.example.ecommerce_spring_order.services.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
     private final IOrderService orderService;

     public OrderController(IOrderService orderService) {
         this.orderService = orderService;
     }

     @PostMapping("/orders")
    public ResponseEntity<CreateOrderRequestDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
         return ResponseEntity.ok(orderService.createOrder(orderRequestDTO));
     }
}
