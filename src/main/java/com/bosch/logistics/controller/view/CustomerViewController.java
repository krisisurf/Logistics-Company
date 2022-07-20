package com.bosch.logistics.controller.view;

import com.bosch.logistics.entity.Customer;
import com.bosch.logistics.entity.ProductStatus;
import com.bosch.logistics.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerViewController {
    private CustomerService customerService;

    public CustomerViewController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getStatuses(Model model){
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers",customers);
        return "/customer/customer";
    }
    @GetMapping("/create-customer")
    public String showCreateStatusForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "/customer/create-customer";
    }

    @PostMapping("/create")
    public String createStatus(@ModelAttribute Customer customer) {
        customerService.create(customer);
        return "redirect:/customer";
    }
}
