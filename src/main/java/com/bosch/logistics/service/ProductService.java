package com.bosch.logistics.service;

import com.bosch.logistics.entity.Address;
import com.bosch.logistics.entity.Customer;
import com.bosch.logistics.entity.Product;
import com.bosch.logistics.entity.ProductStatus;

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

    int countProductsOnAddress(Address address);

    List<Product> findAllByReceivedDateIsNullAndProductStatusId(long id);

    List<Customer> findAllBySenderId(String city);

    List<Product> findAllByReceiverAndReceivedDateBetween(long id, LocalDate startDate, LocalDate endDate);
    List<Product> findAllByReceivedDate(LocalDate date);
}
