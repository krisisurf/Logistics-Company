package com.bosch.logistics.service;

import com.bosch.logistics.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
    Customer getCustomer(long id);
    Customer create(Customer book);
    Customer update(Customer book, long id);
    void delete(long id);
    List<Customer> findByFirstNameContainingAndTelEndingWith(String fname, String phone);
    List<Customer>  findByFirstNameStartingWithAndLastNameStartingWith(String fname, String lname);
}
