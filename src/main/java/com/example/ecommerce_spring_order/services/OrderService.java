package com.example.ecommerce_spring_order.services;

import com.example.ecommerce_spring_order.clients.ProductServiceClient;
import com.example.ecommerce_spring_order.dto.CreateOrderRequestDTO;
import com.example.ecommerce_spring_order.dto.OrderItemDTO;
import com.example.ecommerce_spring_order.dto.OrderRequestDTO;
import com.example.ecommerce_spring_order.dto.ProductDTO;
import com.example.ecommerce_spring_order.entity.Order;
import com.example.ecommerce_spring_order.entity.OrderItems;
import com.example.ecommerce_spring_order.enums.OrderStatus;
import com.example.ecommerce_spring_order.mapper.OrderItemMapper;
import com.example.ecommerce_spring_order.mapper.OrderMapper;
import com.example.ecommerce_spring_order.repository.IOrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    private final IOrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;

    public OrderService(IOrderRepository orderRepository , ProductServiceClient productServiceClient) {
        this.orderRepository = orderRepository;
        this.productServiceClient = productServiceClient;
    }

    @Override
    public CreateOrderRequestDTO createOrder(OrderRequestDTO orderRequestDTO) {
        System.out.println("Received order: " + orderRequestDTO);
        Order order = OrderMapper.toEntity(orderRequestDTO);
        Order created_order = orderRepository.save(order);

        List<OrderItems> order_items = new ArrayList<>();
        for(OrderItemDTO items : orderRequestDTO.getItems()) {
            // fetch all products
            ProductDTO product = productServiceClient.getProductById(items.getProductId());
            double pricePerUnit = product.getPrice();
            double totalPrice = pricePerUnit * items.getQuantity();

            OrderItems item = OrderItemMapper.toEntity(
                    items,
                    order,
                    pricePerUnit,
                    totalPrice
            );

            order_items.add(item);
        }

        order.setItems(order_items);
        Order final_created_order = orderRepository.save(order);
        return OrderMapper.toDto(final_created_order);
    }

    @Override
    public CreateOrderRequestDTO updateStatus(Long orderId) throws Exception {
        // 1. Find the entity or throw a clear exception
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new Exception("Order not found with id: " + orderId));

        order.setStatus(OrderStatus.COMPLETED);

        Order updatedOrder = orderRepository.save(order);
        return OrderMapper.toDto(updatedOrder);

    }
}
