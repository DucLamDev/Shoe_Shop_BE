package com.example.shop_giay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class RedirectController {

    @GetMapping("/api/product/**")
    public RedirectView redirectToProducts() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/api/products");
        redirectView.setStatusCode(HttpStatus.PERMANENT_REDIRECT);
        return redirectView;
    }
    
    @GetMapping("/api/category/**")
    public RedirectView redirectToCategories() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/api/categories");
        redirectView.setStatusCode(HttpStatus.PERMANENT_REDIRECT);
        return redirectView;
    }
    
    @GetMapping("/api/order/**")
    public RedirectView redirectToOrders() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/api/orders");
        redirectView.setStatusCode(HttpStatus.PERMANENT_REDIRECT);
        return redirectView;
    }
    
    @GetMapping("/api/user/**")
    public RedirectView redirectToUsers() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/api/users");
        redirectView.setStatusCode(HttpStatus.PERMANENT_REDIRECT);
        return redirectView;
    }
} 