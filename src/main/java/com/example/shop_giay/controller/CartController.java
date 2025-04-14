package com.example.shop_giay.controller;

import com.example.shop_giay.dto.CartItemDTO;
import com.example.shop_giay.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public ResponseEntity<List<CartItemDTO>> getCartItems() {
        return ResponseEntity.ok(cartService.getCartItems());
    }

    @PostMapping("/items")
    public ResponseEntity<CartItemDTO> addToCart(@RequestBody CartItemDTO cartItemDTO) {
        return ResponseEntity.ok(cartService.addToCart(cartItemDTO.getProductId(), cartItemDTO.getQuantity()));
    }

    @PutMapping("/items/{cartItemId}")
    public ResponseEntity<CartItemDTO> updateCartItem(@PathVariable Long cartItemId, @RequestBody CartItemDTO cartItemDTO) {
        return ResponseEntity.ok(cartService.updateCartItem(cartItemId, cartItemDTO.getQuantity()));
    }

    @DeleteMapping("/items/{cartItemId}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long cartItemId) {
        cartService.removeFromCart(cartItemId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/clear")
    public ResponseEntity<Void> clearCart() {
        cartService.clearCart();
        return ResponseEntity.ok().build();
    }
} 