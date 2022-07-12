package com.bosch.logistics.service;

import com.bosch.logistics.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProduct(long id);
    Product createProduct(Product product);
    Product updateProduct(Product product, long id);
    void deleteProduct(long id);
}
