package com.example.shop_giay.mapper;

import com.example.shop_giay.dto.CartItemDTO;
import com.example.shop_giay.entity.CartItem;
import org.springframework.stereotype.Component;

@Component
public class CartItemMapper {
    
    public CartItemDTO mapToDTO(CartItem cartItem) {
        CartItemDTO dto = new CartItemDTO();
        dto.setId(cartItem.getId());
        dto.setProductId(cartItem.getProduct().getId());
        dto.setProductName(cartItem.getProduct().getName());
        dto.setPrice(cartItem.getProduct().getPrice());
        dto.setQuantity(cartItem.getQuantity());
        return dto;
    }
} 