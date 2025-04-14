package com.example.shop_giay.service;

import com.example.shop_giay.dto.OrderDTO;
import com.example.shop_giay.entity.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    OrderDTO createOrder(OrderDTO orderDTO);
    OrderDTO getOrderById(Long id);
    List<OrderDTO> getAllOrders();
    Page<OrderDTO> getUserOrders(Pageable pageable);
    List<OrderDTO> getOrdersByUserId(Long userId);
    OrderDTO updateOrderStatus(Long id, OrderStatus status);
    void deleteOrder(Long id);
} 