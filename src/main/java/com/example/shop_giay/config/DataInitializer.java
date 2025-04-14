package com.example.shop_giay.config;

import com.example.shop_giay.entity.Category;
import com.example.shop_giay.entity.User;
import com.example.shop_giay.entity.UserRole;
import com.example.shop_giay.repository.CategoryRepository;
import com.example.shop_giay.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Create admin user if not exists
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setEmail("admin@example.com");
            admin.setFullName("Administrator");
            admin.setRole(UserRole.ROLE_ADMIN);
            userRepository.save(admin);
        }

        // Create sample categories if not exists
        if (categoryRepository.count() == 0) {
            Category running = new Category();
            running.setName("Chạy bộ");
            categoryRepository.save(running);

            Category fashion = new Category();
            fashion.setName("Thời trang");
            categoryRepository.save(fashion);

            Category basketball = new Category();
            basketball.setName("Bóng rổ");
            categoryRepository.save(basketball);
        }
    }
} 