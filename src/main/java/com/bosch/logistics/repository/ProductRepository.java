package com.bosch.logistics.repository;

import com.bosch.logistics.entity.Address;
import com.bosch.logistics.entity.Product;
import com.bosch.logistics.entity.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;


public interface ProductRepository extends JpaRepository<Product, Long> {
    Set<Product> findAllByProductStatus(ProductStatus productStatus);
    Set<Product> findAllByReceivedDateNotNull();
    int countByReceivedDateNotNull();

    int countByReceiverAddress(Address address);
}
