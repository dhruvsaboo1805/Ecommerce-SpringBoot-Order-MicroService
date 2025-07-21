package com.example.ecommerce_spring_order.dto;

import com.example.ecommerce_spring_order.enums.OrderStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateOrderRequestDTO {
    private Long OrderId;
    private OrderStatus status;
}
