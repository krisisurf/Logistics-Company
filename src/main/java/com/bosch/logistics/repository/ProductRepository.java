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
    Set<Product> findAllByProductStatus(ProductStatus productStatus);
    Set<Product> findAllByReceivedDateNotNull();
    int countByReceivedDateNotNull();
    int countByReceiverAddress(Address address);
    List<Product> findAllByReceivedDateIsNullAndProductStatusId(long id);
    List<Customer> findAllBySenderId(String city);
    List<Product> findAllByReceiverAndReceivedDateBetween(Customer customer, LocalDate startDate, LocalDate endDate);
    List<Product> findAllByReceivedDate(LocalDate date);
}
