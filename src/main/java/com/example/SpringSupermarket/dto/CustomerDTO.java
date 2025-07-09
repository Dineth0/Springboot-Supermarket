package com.example.SpringSupermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
    private int CusId;
    private String CusName;
    private String CusAddress;
    private int CusPhone;
}
