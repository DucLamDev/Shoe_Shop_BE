package com.example.shop_giay.controller;

import com.example.shop_giay.dto.OrderDTO;
import com.example.shop_giay.dto.UserDTO;
import com.example.shop_giay.service.OrderService;
import com.example.shop_giay.service.ProductService;
import com.example.shop_giay.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    private final OrderService orderService;
    private final ProductService productService;

    @GetMapping("/users")
    public ResponseEntity<Page<UserDTO>> getAllUsers(Pageable pageable) {
        // Note: This requires implementing a method in UserService to get all users with pagination
        // return ResponseEntity.ok(userService.getAllUsers(pageable));
        
        // Temporarily return a not implemented response
        return ResponseEntity.status(501).build();
    }

    @GetMapping("/orders")
    public ResponseEntity<Page<OrderDTO>> getAllOrders(Pageable pageable) {
        // Note: This requires implementing a method in OrderService to get all orders with pagination
        // return ResponseEntity.ok(orderService.getAllOrders(pageable));
        
        // Temporarily return a not implemented response
        return ResponseEntity.status(501).build();
    }

    @GetMapping("/dashboard/stats")
    public ResponseEntity<Map<String, Object>> getDashboardStats() {
        // Note: This would require implementing methods to count users, orders, products, etc.
        
        Map<String, Object> stats = new HashMap<>();
        stats.put("message", "Dashboard statistics not implemented yet");
        
        // Temporarily return a not implemented response
        return ResponseEntity.ok(stats);
    }
} 