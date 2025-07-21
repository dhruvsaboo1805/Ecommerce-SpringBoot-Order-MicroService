package com.example.ecommerce_spring_order.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class OrderRequestDTO {
    private Long userId;
    private List<OrderItemDTO> items;
}
