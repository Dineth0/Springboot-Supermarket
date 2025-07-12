package com.example.SpringSupermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {
    private int orderId;
    private Date orderDate;
    private int cusId;

    private List<OrderDetailDTO> orderDetailsDTOList;
}
