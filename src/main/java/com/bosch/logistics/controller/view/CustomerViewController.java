package com.bosch.logistics.controller.view;

import com.bosch.logistics.entity.Address;
import com.bosch.logistics.entity.Customer;
import com.bosch.logistics.entity.ProductStatus;
import com.bosch.logistics.service.AddressService;
import com.bosch.logistics.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerViewController {
    private CustomerService customerService;
    private AddressService addressService;

    public CustomerViewController(CustomerService customerService, AddressService addressService) {
        this.customerService = customerService;
        this.addressService = addressService;
    }

    @GetMapping
    public String getStatuses(Model model){
        List<Customer> customers = customerService.getCustomers();
        List<Address> addresses = addressService.getAddresses();
        model.addAttribute("customers",customers);
        model.addAttribute("addresses",addresses);
        return "/customer/customer";
    }
    @GetMapping("/create-customer")
    public String createCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("addresses", addressService.getAddresses());
        return "/customer/create-customer";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute Customer customer) {
        customerService.create(customer);
        return "redirect:/customer";
    }
    @GetMapping("/edit/{id}")
    public String editCustomerForm(Model model, @PathVariable Long id) {
        model.addAttribute("customer", customerService.getCustomer(id));
        model.addAttribute("addresses",addressService.getAddresses());
        return "/customer/edit-customer";
    }
    @PostMapping("/update/{id}")
    public String updateCustomer(Model model, @PathVariable Long id, Customer customer) {
        customerService.update(customer, id);
        return "redirect:/customer";
    }
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id) {
        customerService.delete(id);
        return "redirect:/customer";
    }
}
