package com.example.SpringSupermarket.service.impl;

import com.example.SpringSupermarket.dto.CustomerDTO;
import com.example.SpringSupermarket.dto.ItemDTO;
import com.example.SpringSupermarket.entity.Item;
import com.example.SpringSupermarket.repo.ItemRepo;
import com.example.SpringSupermarket.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ItemDTO saveItem(ItemDTO itemDTO) {
        if(itemRepo.existsById(itemDTO.getItemCode())){
            throw new  RuntimeException("Item All Ready Exist");
        }else {
            itemRepo.save(modelMapper.map(itemDTO, Item.class));
            return modelMapper.map(itemDTO, ItemDTO.class);
        }
    }

    @Override
    public ItemDTO updateItem(ItemDTO itemDTO) {
        if(itemRepo.existsById(itemDTO.getItemCode())){
            itemRepo.save(modelMapper.map(itemDTO, Item.class));
            return modelMapper.map(itemDTO, ItemDTO.class);
        }else {
            throw new  RuntimeException("Item Not Found");
        }
    }

    @Override
    public String deleteItem(int id) {
        if (itemRepo.existsById(id)){
            itemRepo.deleteById(id);
            return "Item Deleted Successfully";
        }else {
            return "Item Not Found";
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepo.findAll();
        return modelMapper.map(items, new TypeToken<ArrayList<ItemDTO>>() {
        }.getType());
    }

    @Override
    public ItemDTO searchItem(int id) {
        if(itemRepo.existsById(id)){
            Item item = itemRepo.findById(id).orElse(null);
            return modelMapper.map(item, ItemDTO.class);
        }else {
            throw new  RuntimeException("Item Not Found");
        }
    }
}
