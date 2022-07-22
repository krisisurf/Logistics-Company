package com.bosch.logistics.repository;

import com.bosch.logistics.entity.Address;
import com.bosch.logistics.entity.Product;
import com.bosch.logistics.entity.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByWeightBetween(String min, String max);


    Set<Product> findAllByProductStatus(ProductStatus productStatus);
    Set<Product> findAllByReceivedDateNotNull();
    int countByReceivedDateNotNull();
    List<Product>findAllByReceivedDateBetween(LocalDate min, LocalDate max);

    int countAllByReceivedDateBetween(LocalDate min, LocalDate max);

    int countAllByReceivedDate(LocalDate date);
    int countByReceiverAddress(Address address);
    List<Product> findAllByReceivedDate(LocalDate date);
    List<Product> findAllByRegisteredDate(LocalDate date);

}
