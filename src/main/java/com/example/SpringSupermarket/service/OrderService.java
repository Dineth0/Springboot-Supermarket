package com.example.SpringSupermarket.service;

import com.example.SpringSupermarket.dto.OrderDTO;

public interface OrderService {
    public OrderDTO placeOrder(OrderDTO orderDTO);
}
