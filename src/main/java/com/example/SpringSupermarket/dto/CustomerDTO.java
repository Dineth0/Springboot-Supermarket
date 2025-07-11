package com.example.SpringSupermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
    private int cusId;
    private String cusName;
    private String cusAddress;
    private int cusPhone;
}
