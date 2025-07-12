package com.example.SpringSupermarket.repo;

import com.example.SpringSupermarket.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
