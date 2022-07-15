package com.bosch.logistics.service.implementation;

import com.bosch.logistics.service.CustomerService;
import com.bosch.logistics.entity.Customer;
import com.bosch.logistics.repository.CustomerRepository;
import com.bosch.logistics.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(long id) {
        return customerRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid id: " + id));
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer, long id) {
        customer.setId(id);
        return customerRepository.save(customer);
    }

    @Override
    public void delete(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findByFirstNameContainingAndTelEndingWith(String fname, String phone) {
        return customerRepository.findByFirstNameContainingAndTelEndingWith(fname, phone);
    }

    @Override
    public List<Customer> findByFirstNameStartingWithAndLastNameStartingWith(String fname, String lname) {
        return customerRepository.findByFirstNameStartingWithAndLastNameStartingWith(fname, lname);
    }
}
