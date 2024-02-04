package com.items.demo.service;

import com.items.demo.models.Item;
import com.items.demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Item> findAll() {
        List<Product> products = Arrays.asList(restTemplate.getForObject("http://localhost:8001/products",Product[].class));
        return products.stream().map(p->new Item(p,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Map<String,String> pathVariables = new HashMap<>();
        pathVariables.put("id",id.toString());
        Product product = restTemplate.getForObject("http://localhost:8001/product/{id}", Product.class, pathVariables);
        return new Item(product, cantidad);
    }
}
