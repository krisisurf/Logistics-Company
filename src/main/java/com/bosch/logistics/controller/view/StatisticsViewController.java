package com.bosch.logistics.controller.view;

import com.bosch.logistics.entity.ProductStatus;
import com.bosch.logistics.service.CustomerService;
import com.bosch.logistics.service.StatusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/statistics")
public class StatisticsViewController {
    private CustomerService customerService;

    public StatisticsViewController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public String showEditStatusForm(Model model, @PathVariable long id) {
        model.addAttribute("weight", customerService.getTotalWeightAllProducts(id));
        return "/statistics";
    }
}
