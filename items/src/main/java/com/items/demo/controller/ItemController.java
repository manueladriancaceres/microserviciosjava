package com.items.demo.controller;

import com.items.demo.models.Item;
import com.items.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    @Qualifier("servicefeign")
    private ItemService itemService;

    @GetMapping("/items")
    public List<Item> getItems() {

        return itemService.findAll();
    }

    @GetMapping("/item/{id}/cantidad/{cantidad}")
    public Item getItem(@PathVariable Long id, @PathVariable Integer cantidad) {
        return itemService.findById(id,cantidad);
    }
}
