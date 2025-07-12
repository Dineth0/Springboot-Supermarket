package com.example.SpringSupermarket.controller;

import com.example.SpringSupermarket.dto.ItemDTO;
import com.example.SpringSupermarket.service.ItemService;
import com.example.SpringSupermarket.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/saveItem")
    public ResponseUtil saveItem(@RequestBody ItemDTO itemDTO) {
        ItemDTO savedItem = itemService.saveItem(itemDTO);
        return new ResponseUtil(200,"saved",savedItem);
    }

    @PutMapping("/updateItem")
    public ResponseUtil updateItem(@RequestBody ItemDTO itemDTO) {
        ItemDTO savedItem = itemService.updateItem(itemDTO);
        return new ResponseUtil(200,"updated",savedItem);
    }
    @DeleteMapping("/deleteItem/{id}")
    public ResponseUtil deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
        return new ResponseUtil(200,"deleted",null);

    }
    @GetMapping("/getAllItems")
    public ResponseUtil getAllItems() {
        List<ItemDTO> allItems = itemService.getAllItems();
        return new ResponseUtil(200,"success",allItems);
    }
    @GetMapping("/searchItem/{id}")
    public ResponseUtil searchItem(@PathVariable int id) {
      ItemDTO itemDTO =  itemService.searchItem(id);
        return new ResponseUtil(200,"success",itemDTO);
    }
}
