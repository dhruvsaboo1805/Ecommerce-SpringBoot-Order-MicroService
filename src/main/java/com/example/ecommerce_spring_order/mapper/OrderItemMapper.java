package com.example.ecommerce_spring_order.mapper;

import com.example.ecommerce_spring_order.dto.OrderItemDTO;
import com.example.ecommerce_spring_order.entity.Order;
import com.example.ecommerce_spring_order.entity.OrderItems;

public class OrderItemMapper {

    public static OrderItems toEntity(OrderItemDTO dto , Order order , double pricePerUnit , double totalPrice) {
        return OrderItems.builder()
                .productId(dto.getProductId())
                .quantity(dto.getQuantity())
                .pricePerUnit(pricePerUnit)
                .totalPrice(totalPrice)
                .order(order)
                .build();
    }
}
