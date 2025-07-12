package com.example.SpringSupermarket.repo;

import com.example.SpringSupermarket.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepo extends JpaRepository<OrderDetails,Integer> {
}
