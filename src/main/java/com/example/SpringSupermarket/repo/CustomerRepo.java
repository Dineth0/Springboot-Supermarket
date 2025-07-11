package com.example.SpringSupermarket.repo;

import com.example.SpringSupermarket.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
