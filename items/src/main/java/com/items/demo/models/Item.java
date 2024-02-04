package com.items.demo.models;

public class Item {
    private Product product;
    private Integer cantidad;

    public Item(Product product, Integer cantidad) {
        this.product = product;
        this.cantidad = cantidad;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return product.getPrice() * this.cantidad.doubleValue();
    }
}
