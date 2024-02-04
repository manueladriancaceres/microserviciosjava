package com.items.demo.service;

import com.items.demo.clients.ProductClienteRest;
import com.items.demo.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("servicefeign")
@Primary
public class ItemServiceFeign implements ItemService{

    @Autowired
    private ProductClienteRest clienteRest;

    @Override
    public List<Item> findAll() {
        return clienteRest.getProducts().stream()
                .map(p-> new Item(p,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return new Item(clienteRest.getProduct(id),cantidad);
    }
}
