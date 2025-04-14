package com.example.shop_giay.dto;

import com.example.shop_giay.entity.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private OrderStatus status;
    private String shippingAddress;
    private BigDecimal totalAmount;
    private LocalDateTime orderDate;
    private List<OrderItemDTO> orderItems;

    @Data
    public static class OrderItemDTO {
        private Long productId;
        private Integer quantity;
        private BigDecimal price;
    }
} 