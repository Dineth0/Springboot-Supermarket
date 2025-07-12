package com.example.SpringSupermarket.repo;

import com.example.SpringSupermarket.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Integer> {
}
