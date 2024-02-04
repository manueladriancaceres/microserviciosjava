package com.example.product.service;

import com.example.product.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductService {
    public List<Product> findAll();
    public Product findbyId(Long id);

}
