package com.example.SpringSupermarket.controller;

import com.example.SpringSupermarket.dto.CustomerDTO;
import com.example.SpringSupermarket.entity.Customer;
import com.example.SpringSupermarket.service.CustomerService;
import com.example.SpringSupermarket.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/saveCustomer")
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO saved = customerService.saveCustomer(customerDTO);
        return new ResponseUtil(200,"Saved",saved);
    }
    @PutMapping("/updateCustomer")
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO updated = customerService.updateCustomer(customerDTO);
        return new ResponseUtil(200,"Updated",updated);
    }

    @GetMapping("/getAllCustomers")
    public ResponseUtil getAllCustomers() {
        List<CustomerDTO> customerDTOList = customerService.getAllCustomers();
        return new ResponseUtil(200,"Success",customerDTOList);
    }
    @GetMapping("/searchCustomer/{CusId}")
    public ResponseUtil searchCustomer(@PathVariable int CusId) {
        CustomerDTO customerDTO = customerService.searchCustomer(CusId);
        return new ResponseUtil(200,"Success",customerDTO);
    }
    @DeleteMapping("/deleteCustomer/{CusId}")
    public ResponseUtil deleteCustomer(@PathVariable int CusId) {
        customerService.deleteCustomer(CusId);
        return new ResponseUtil(200,"Success",null);
    }
}
