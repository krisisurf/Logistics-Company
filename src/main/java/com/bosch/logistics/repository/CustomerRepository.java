package com.bosch.logistics.repository;

import com.bosch.logistics.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository <Customer, Long>{
    List<Customer> findAllByFirstNameStartsWithAndLastNameStartsWithOrderByTelAsc(String firstName, String lastName);
}
