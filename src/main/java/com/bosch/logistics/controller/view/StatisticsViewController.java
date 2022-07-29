package com.bosch.logistics.controller.view;

import com.bosch.logistics.entity.Customer;
import com.bosch.logistics.entity.Product;
import com.bosch.logistics.entity.ProductStatus;
import com.bosch.logistics.entity.User;
import com.bosch.logistics.service.CustomerService;
import com.bosch.logistics.service.StatusService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/statistics")
public class StatisticsViewController {
    private CustomerService customerService;
    private Set<String> methods;

    public StatisticsViewController(CustomerService customerService) {
        this.customerService = customerService;
        methods = new HashSet<>();
        methods.add("getTotalWeightAllProducts");
    }

    @GetMapping("/method")
    public String showMethodForm(Model model, Customer customer, String method) {
        if (method.equals("getTotalWeightAllProducts")) {
            model.addAttribute("weight", customerService.getTotalWeightAllProducts(customer.getId()));
            return "/statistics/totalweight-statistics";
        }

        return "/notfound";
    }

    @GetMapping
    public String showMethodsListForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        Customer customer;

        for (GrantedAuthority a : user.getAuthorities()) {
            if (a.getAuthority().equals("CUSTOMER")) {
                customer = customerService.getCustomer(user.getId());
                model.addAttribute("weight", customerService.getTotalWeightAllProducts(customer.getId()));
                return "/statistics/statistics";

            } else if (a.getAuthority().equals("ADMIN") || a.getAuthority().equals("OFFICE_EMPLOYEE")
                    || a.getAuthority().equals("DRIVER")) {

                model.addAttribute("customers", customerService.getCustomers());
                model.addAttribute("customer", new Customer());

                model.addAttribute("methods", methods);
                model.addAttribute("method", new String());
                return "statistics/choose-statistics";
            }
        }

        return "/notfound";
    }

}
