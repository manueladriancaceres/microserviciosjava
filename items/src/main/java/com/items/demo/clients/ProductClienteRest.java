package com.items.demo.clients;


import com.items.demo.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="servicio-productos",url="localhost:8001")
public interface ProductClienteRest {

    @GetMapping("/products")
    public List<Product> getProducts();

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable  Long id);

}
