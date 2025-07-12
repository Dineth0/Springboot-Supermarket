package com.example.SpringSupermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {
    private int itemCode;
    private String itemName;
    private String itemDescription;
    private double itemPrice;
    private int itemQty;
}
