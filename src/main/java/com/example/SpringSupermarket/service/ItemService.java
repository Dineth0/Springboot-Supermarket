package com.example.SpringSupermarket.service;


import com.example.SpringSupermarket.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    public ItemDTO saveItem(ItemDTO itemDTO);
    public ItemDTO updateItem(ItemDTO itemDTO);
    public String deleteItem(int id);
    public List<ItemDTO> getAllItems();
    public ItemDTO searchItem(int id);
}
