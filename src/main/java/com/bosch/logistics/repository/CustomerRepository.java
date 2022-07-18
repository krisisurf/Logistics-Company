package com.bosch.logistics.repository;

import com.bosch.logistics.entity.Address;
import com.bosch.logistics.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CustomerRepository extends JpaRepository <Customer, Long>{

    List<Customer> findAllByFirstNameStartsWithAndLastNameStartsWithOrderByTelAsc(String firstName, String lastName);
    List<Customer> findByFirstNameContainingAndTelEndingWith(String fname, String phone);

    List<Customer>  findByFirstNameStartingWithAndLastNameStartingWith(String fname, String lname);

    Customer findByTel(String tel);
}
