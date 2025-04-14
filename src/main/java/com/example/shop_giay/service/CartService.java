package com.example.shop_giay.service;

import com.example.shop_giay.dto.CartItemDTO;
import java.util.List;

public interface CartService {
    CartItemDTO addToCart(Long productId, Integer quantity);
    List<CartItemDTO> getCartItems();
    CartItemDTO updateCartItem(Long cartItemId, Integer quantity);
    void removeFromCart(Long cartItemId);
    void clearCart();
} 