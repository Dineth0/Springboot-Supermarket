package com.example.SpringSupermarket.service.impl;

import com.example.SpringSupermarket.dto.OrderDTO;
import com.example.SpringSupermarket.dto.OrderDetailDTO;
import com.example.SpringSupermarket.entity.Customer;
import com.example.SpringSupermarket.entity.Item;
import com.example.SpringSupermarket.entity.Order;
import com.example.SpringSupermarket.entity.OrderDetails;
import com.example.SpringSupermarket.repo.CustomerRepo;
import com.example.SpringSupermarket.repo.ItemRepo;
import com.example.SpringSupermarket.repo.OrderDetailRepo;
import com.example.SpringSupermarket.repo.OrderRepo;
import com.example.SpringSupermarket.service.OrderService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrderDetailRepo orderDetailRepo;

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Override
    @Transactional
    public OrderDTO placeOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderDate(orderDTO.getOrderDate());

        Customer customer = customerRepo.findById(orderDTO.getCusId())
                .orElseThrow(() -> new IllegalStateException("Customer not found with id: " + orderDTO.getCusId()));
        order.setCustomer(customer);


        Order savedOrder = orderRepo.save(order);

        for(OrderDetailDTO orderDetailDTO : orderDTO.getOrderDetailsDTOList()){
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrder(savedOrder);
            orderDetails.setOrderQty(orderDetailDTO.getOrderQty());
            orderDetails.setSubTotal(orderDetailDTO.getSubTotal());
            orderDetails.setDiscountRate(orderDetailDTO.getDiscountRate());
            orderDetails.setDiscountAmount(orderDetailDTO.getDiscountAmount());
            orderDetails.setTotalAmount(orderDetailDTO.getTotalAmount());

            Item item = itemRepo.findById(orderDetailDTO.getItemCode()).orElseThrow(()-> new IllegalStateException("Item not found"));

            int newQty = item.getItemQty() - orderDetails.getOrderQty();
            if (newQty < 0) {
                throw new RuntimeException("Not enough stock for item: " + item.getItemName());
            }
            item.setItemQty(newQty);

            itemRepo.save(item); // update qty

            orderDetails.setItem(item);
            orderDetailRepo.save(orderDetails);
        }

        return modelMapper.map(savedOrder, OrderDTO.class);

    }
}
