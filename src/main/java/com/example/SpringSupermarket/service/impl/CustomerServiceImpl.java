package com.example.SpringSupermarket.service.impl;

import com.example.SpringSupermarket.dto.CustomerDTO;
import com.example.SpringSupermarket.entity.Customer;
import com.example.SpringSupermarket.repo.CustomerRepo;
import com.example.SpringSupermarket.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        if(customerRepo.existsById(customerDTO.getCusId())){
            throw new RuntimeException("Customer All ready");
        }else {
            Customer customerEntity = modelMapper.map(customerDTO, Customer.class);
            Customer savedCustomer = customerRepo.save(customerEntity);
            return modelMapper.map(savedCustomer, CustomerDTO.class);
        }
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        if(customerRepo.existsById(customerDTO.getCusId())){
            Customer updatedCustomer = customerRepo.save(modelMapper.map(customerDTO, Customer.class));
            return modelMapper.map(updatedCustomer, CustomerDTO.class);
        }
        throw new RuntimeException("Customer Not Found");
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
       List<Customer> customers = customerRepo.findAll();
       return modelMapper.map(customers, new TypeToken<ArrayList<CustomerDTO>>() {

           }.getType());
    }

    @Override
    public CustomerDTO searchCustomer(int id) {
        if(customerRepo.existsById(id)){
            Customer customer = customerRepo.findById(id).orElse(null);
            return modelMapper.map(customer, CustomerDTO.class);
        }else {
            return null;
        }
    }

    @Override
    public String deleteCustomer(int id) {
        if(customerRepo.existsById(id)){
             customerRepo.deleteById(id);
             return "Customer Deleted Successfully";
        }else {
            return "Customer Not Found";
        }
    }
}
