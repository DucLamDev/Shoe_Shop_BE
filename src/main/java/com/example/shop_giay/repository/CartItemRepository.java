package com.example.shop_giay.repository;

import com.example.shop_giay.entity.CartItem;
import com.example.shop_giay.entity.Product;
import com.example.shop_giay.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUser(User user);
    CartItem findByUserAndProduct(User user, Product product);
    Optional<CartItem> findByIdAndUser(Long id, User user);
    void deleteByUser(User user);
} 