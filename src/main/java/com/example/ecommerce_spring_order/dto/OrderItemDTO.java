package com.example.ecommerce_spring_order.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class OrderItemDTO {
    private Long productId;
    private int quantity;
}
