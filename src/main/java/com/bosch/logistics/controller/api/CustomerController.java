package com.bosch.logistics.controller.api;

import com.bosch.logistics.entity.Customer;
import com.bosch.logistics.entity.Product;
import com.bosch.logistics.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return this.customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") long id) {
        return this.customerService.getCustomer(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable long id) {
        return customerService.update(customer, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable long id) {
        customerService.delete(id);
    }

    @GetMapping("/containingFirstName/{fname}/telephoneEndingWith/{phone}")
    public List<Customer> findByFirstNameContainingAndTelEndingWith(@PathVariable("fname") String fname, @PathVariable("phone") String phone) {
        return this.customerService.findByFirstNameContainingAndTelEndingWith(fname,phone);
    }

    @GetMapping("/FirstName/{fname}/LastName/{lname}")
    public List<Customer> findByFirstNameStartingWithAndLastNameStartingWith(@PathVariable("fname") String fname, @PathVariable("lname") String lname) {
        return this.customerService.findByFirstNameStartingWithAndLastNameStartingWith(fname,lname);
    }

    @GetMapping("/findByTel/{tel}")
    public Customer findByTel(@PathVariable String tel) {
        return customerService.findByTel(tel);
    }
    @GetMapping("/findProductByTel/{tel}")
    public Set<Product> findProductByTel(@PathVariable String tel) {
        Customer customer = customerService.findByTel(tel);
        return customer.getProductsReceive();
    }

    @GetMapping("/findProductByTel/{tel}/statusID/{id}")
    public Set<Product> findProductByTelAndStatus(@PathVariable String tel, @PathVariable long id) {
        Customer customer = customerService.findByTel(tel);
        return customer.getProductsReceive().stream()
                .filter(product -> product.getProductStatus().getId()==id)
                .collect(Collectors.toSet());
    }
}
