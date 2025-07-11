package com.example.SpringSupermarket.service;

import com.example.SpringSupermarket.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    public CustomerDTO saveCustomer(CustomerDTO customerDTO);
    public CustomerDTO updateCustomer(CustomerDTO customerDTO);
    public List<CustomerDTO> getAllCustomers();
    public CustomerDTO searchCustomer(int id);
    public String deleteCustomer(int id);

}
