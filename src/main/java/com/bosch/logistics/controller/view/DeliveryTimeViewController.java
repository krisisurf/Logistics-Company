package com.bosch.logistics.controller.view;

import com.bosch.logistics.entity.DeliveryTime;
import com.bosch.logistics.service.DeliveryTimeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/deliveryTime")
public class DeliveryTimeViewController {

    private DeliveryTimeService deliveryTimeService;

    public DeliveryTimeViewController(DeliveryTimeService deliveryTimeService) {
        this.deliveryTimeService = deliveryTimeService;
    }


    @GetMapping
    public String deliveryTimeView(Model model){
        model.addAttribute("deliveryTimes", deliveryTimeService.getDeliveryTime());
        return "/deliveryTime/deliveryTime.html";
    }

    @GetMapping("/create-deliveryTime")
    public String showCreateDeliveryTimeForm(Model model) {
        model.addAttribute("productDeliveryTime", new DeliveryTime());
        return "/deliveryTime/create-deliveryTime";
    }

    @PostMapping("/create")
    public String createDeliveryTime(@ModelAttribute DeliveryTime deliveryTime) {
        deliveryTimeService.create(deliveryTime);
        return "redirect:/deliveryTime";
    }

    @GetMapping("/edit/{id}")
    public String showEditDeliveryTimeForm(Model model, @PathVariable long id) {
        model.addAttribute("productDeliveryTime", deliveryTimeService.getdeliveryTime(id));
        return "/deliveryTime/edit-deliveryTime";
    }

    @PostMapping("/update/{id}")
    public String updateDeliveryTimeForm(@PathVariable long id, DeliveryTime deliveryTime) {
        deliveryTimeService.update(deliveryTime, id);
        return "redirect:/deliveryTime";
    }

    @GetMapping("/delete/{id}")
    public String deleteDeliveryTime(@PathVariable long id) {
        deliveryTimeService.delete(id);
        return "redirect:/deliveryTime";
    }


}