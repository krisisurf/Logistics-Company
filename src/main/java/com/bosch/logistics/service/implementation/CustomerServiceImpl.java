package com.bosch.logistics.service.implementation;

import com.bosch.logistics.entity.Address;
import com.bosch.logistics.entity.Product;
import com.bosch.logistics.service.AddressService;
import com.bosch.logistics.service.CustomerService;
import com.bosch.logistics.entity.Customer;
import com.bosch.logistics.repository.CustomerRepository;
import com.bosch.logistics.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private AddressService addressService;

    public CustomerServiceImpl(CustomerRepository customerRepository, AddressService addressService) {
        this.customerRepository = customerRepository;
        this.addressService = addressService;
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(long id) {
        return customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id: " + id));
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
    public List<Customer> findAllByFirstNameStartsWithAndLastNameStartsWithOrderByTelAsc(String startFirstName, String startLastName) {
        return customerRepository.findAllByFirstNameStartsWithAndLastNameStartsWithOrderByTelAsc(startFirstName, startLastName);
    }

    @Override
    public List<Customer> findByFirstNameContainingAndTelEndingWith(String fname, String phone) {
        return customerRepository.findByFirstNameContainingAndTelEndingWith(fname, phone);
    }

    @Override
    public List<Customer> findByFirstNameStartingWithAndLastNameStartingWith(String fname, String lname) {
        return customerRepository.findByFirstNameStartingWithAndLastNameStartingWith(fname, lname);
    }


    @Override
    public Customer findByTel(String tel) {
        return customerRepository.findByTel(tel);
    }

    @Override
    public Set<Customer> findByCity(String city) {
        List<Address> addresses = addressService.findByCity(city);
        Set<Customer> customers = new HashSet<>();
        addresses.forEach(a -> customers.addAll(a.getCustomers()));

        return customers;
    }


    @Override
    public int countByCity(String city) {
        // TODO 100: Needs rework, because this method is slow
        List<Address> addresses = addressService.findByCity(city);
        int count = addresses.stream().mapToInt(a -> a.getCustomers().size()).sum();
        return count;
    }



    public int getTotalWeightAllProducts(long id){
        int totalWeight=0;
        for (Product product: getCustomer(id).getProductsSent()) {
            if(product.getWeight()!=null){
                totalWeight+= Integer.parseInt(product.getWeight()); //TODO MAKE weight to be numerical value
            }
        }
        for (Product product: getCustomer(id).getProductsReceive()) {
            if(product.getWeight()!=null){
                totalWeight+= Integer.parseInt(product.getWeight()); //TODO MAKE weight to be numerical value
            }
        }
        return totalWeight;
    }
}
