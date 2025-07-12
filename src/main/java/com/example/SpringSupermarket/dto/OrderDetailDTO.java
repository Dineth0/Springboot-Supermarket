package com.example.SpringSupermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailDTO {
    private int OdId;
    private String orderId;
    private int itemCode;
    private int OrderQty;
    private double subTotal;
    private double discountRate;
    private double discountAmount;
    private double totalAmount;
}
