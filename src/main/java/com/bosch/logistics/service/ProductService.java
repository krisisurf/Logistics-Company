package com.bosch.logistics.service;

import com.bosch.logistics.entity.Address;
import com.bosch.logistics.entity.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ProductService {
    List<Product> getProducts();
    Product getProduct(long id);
    Product createProduct(Product product);
    Product updateProduct(Product product, long id);
    void deleteProduct(long id);

    Set<Product> findAllByProductStatus(long productStatusId);
    Set<Product> findAllReceivedProducts();
    int receivedProductsCount();
 
    List<Product> findAllByWeightBetween(String min, String max);
    List<Product>findAllByReceivedDateBetween(LocalDate min, LocalDate max);
    int countAllByReceivedDateBetween(LocalDate min, LocalDate max);
    int countAllByReceivedDate(LocalDate date);
    List<Product> findAllByReceivedDate(LocalDate date);
    int countProductsOnAddress(Address address);

    Set<Product> productsByCustomersCity(String city);
    int countProductsByCustomersCity(String city);
}

