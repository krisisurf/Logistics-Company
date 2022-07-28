package com.bosch.logistics.repository;

import com.bosch.logistics.entity.Address;
import com.bosch.logistics.entity.Customer;
import com.bosch.logistics.entity.Product;
import com.bosch.logistics.entity.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Set<Product> findAllByWeightBetween(String min, String max);

    Set<Product> findAllByProductStatus(ProductStatus productStatus);

    Set<Product> findAllByReceivedDateNotNull();

    int countByReceivedDateNotNull();

    Set<Product> findAllByReceivedDateIsNullAndProductStatusId(long statusId);

    Set<Product> findAllByReceiverAndReceivedDateBetween(Customer receiver, LocalDate startDate, LocalDate endDate);

    Set<Product> findAllByReceivedDateBetween(LocalDate min, LocalDate max);

    int countAllByReceivedDateBetween(LocalDate min, LocalDate max);

    Set<Product> findAllByRegisteredDateOrderByNameAsc(LocalDate registeredDate);

    int countAllByReceivedDate(LocalDate date);

    int countByReceiverAddress(Address address);

    Set<Product> findAllByReceivedDate(LocalDate date);

    List<Product> findAllByRegisteredDateOrderBySenderAsc(LocalDate registeredDate);

}
