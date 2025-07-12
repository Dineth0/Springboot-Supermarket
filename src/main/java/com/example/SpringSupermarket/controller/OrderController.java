package com.example.SpringSupermarket.controller;

import com.example.SpringSupermarket.dto.OrderDTO;
import com.example.SpringSupermarket.service.OrderService;
import com.example.SpringSupermarket.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseUtil placeOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO result = orderService.placeOrder(orderDTO);
        return new ResponseUtil(200,"Success",result);
    }
}
