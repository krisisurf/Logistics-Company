package com.bosch.logistics.controller.view;

import com.bosch.logistics.entity.Customer;
import com.bosch.logistics.entity.Product;
import com.bosch.logistics.entity.ProductStatus;
import com.bosch.logistics.entity.User;
import com.bosch.logistics.service.CustomerService;
import com.bosch.logistics.service.StatusService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/statistics")
public class StatisticsViewController {
    private CustomerService customerService;

    public StatisticsViewController(CustomerService customerService) {
        this.customerService = customerService;
    }



    @GetMapping("/choose")
    public String createStatus(Model model, Customer customer) {
        model.addAttribute("weight", customerService.getTotalWeightAllProducts(customer.getId()));
        return "/statistics/statistics";
    }

    @GetMapping
    public String productView(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        Customer customer = null;

        if(user.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("CUSTOMER"))) {
            customer = customerService.getCustomer(user.getId());

            model.addAttribute("weight", customerService.getTotalWeightAllProducts(customer.getId()));

            return "/statistics";
        }
        else{
            model.addAttribute("customers",customerService.getCustomers());
            model.addAttribute("customer", new Customer());
            return "statistics/choose-statistics";
        }
    }

}
