package com.bosch.logistics.repository;

import com.bosch.logistics.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByWeightBetween(String min, String max);


    Set<Product> findAllByProductStatus(ProductStatus productStatus);
    Set<Product> findAllByReceivedDateNotNull();
    int countByReceivedDateNotNull();
    List<Product>findAllByReceivedDateBetween(LocalDate min, LocalDate max);

    int countAllByReceivedDateBetween(LocalDate min, LocalDate max);

    int countAllByReceivedDate(LocalDate date);

    List<Product> findAllByReceivedDate(LocalDate date);
}
