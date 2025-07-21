package com.example.ecommerce_spring_order.mapper;

import com.example.ecommerce_spring_order.dto.CreateOrderRequestDTO;
import com.example.ecommerce_spring_order.dto.OrderRequestDTO;
import com.example.ecommerce_spring_order.entity.Order;
import com.example.ecommerce_spring_order.enums.OrderStatus;

public class OrderMapper {

    public static Order toEntity(OrderRequestDTO dto) {
        return Order.builder()
                .userId(dto.getUserId())
                .status(OrderStatus.PENDING)
                .build();
    }

    public static CreateOrderRequestDTO toDto(Order order) {
        return CreateOrderRequestDTO.builder()
                .OrderId(order.getId())
                .status(order.getStatus())
                .build();
    }

}
