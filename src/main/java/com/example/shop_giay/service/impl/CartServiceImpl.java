package com.example.shop_giay.service.impl;

import com.example.shop_giay.dto.CartItemDTO;
import com.example.shop_giay.entity.CartItem;
import com.example.shop_giay.entity.Product;
import com.example.shop_giay.entity.User;
import com.example.shop_giay.exception.ResourceNotFoundException;
import com.example.shop_giay.mapper.CartItemMapper;
import com.example.shop_giay.repository.CartItemRepository;
import com.example.shop_giay.repository.ProductRepository;
import com.example.shop_giay.repository.UserRepository;
import com.example.shop_giay.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CartItemMapper cartItemMapper;

    private User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    @Transactional
    public CartItemDTO addToCart(Long productId, Integer quantity) {
        User currentUser = getCurrentUser();
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        CartItem existingItem = cartItemRepository.findByUserAndProduct(currentUser, product);

        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
            return cartItemMapper.mapToDTO(cartItemRepository.save(existingItem));
        }

        CartItem newItem = new CartItem();
        newItem.setUser(currentUser);
        newItem.setProduct(product);
        newItem.setQuantity(quantity);

        return cartItemMapper.mapToDTO(cartItemRepository.save(newItem));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CartItemDTO> getCartItems() {
        User currentUser = getCurrentUser();
        return cartItemRepository.findByUser(currentUser)
                .stream()
                .map(cartItemMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CartItemDTO updateCartItem(Long cartItemId, Integer quantity) {
        User currentUser = getCurrentUser();
        CartItem cartItem = cartItemRepository.findByIdAndUser(cartItemId, currentUser)
                .orElseThrow(() -> new ResourceNotFoundException("Cart item not found"));

        cartItem.setQuantity(quantity);
        return cartItemMapper.mapToDTO(cartItemRepository.save(cartItem));
    }

    @Override
    @Transactional
    public void removeFromCart(Long cartItemId) {
        User currentUser = getCurrentUser();
        CartItem cartItem = cartItemRepository.findByIdAndUser(cartItemId, currentUser)
                .orElseThrow(() -> new ResourceNotFoundException("Cart item not found"));

        cartItemRepository.delete(cartItem);
    }

    @Override
    @Transactional
    public void clearCart() {
        User currentUser = getCurrentUser();
        cartItemRepository.deleteByUser(currentUser);
    }
} 