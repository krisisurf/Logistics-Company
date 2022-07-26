package com.bosch.logistics.controller.view;


import com.bosch.logistics.entity.Office;
import com.bosch.logistics.service.AddressService;
import com.bosch.logistics.service.OfficeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/office")
public class OfficeViewController {
    private OfficeService officeService;
    private AddressService addressService;

    public OfficeViewController(OfficeService officeService, AddressService addressService) {
        this.officeService = officeService;
        this.addressService = addressService;
    }

    @GetMapping
    public String getOffices(Model model) {
        final List<Office> offices = officeService.getOffices();
        model.addAttribute("offices", offices);
        return "/office/office";
    }

    @GetMapping("/create-office")
    public String showCreateOfficeForm(Model model) {
        model.addAttribute("office", new Office());
        model.addAttribute("addresses", addressService.getAddresses());
        return "/office/create-office";
    }

    @PostMapping("/create")
    public String createOffice(@ModelAttribute Office office) {
        officeService.create(office);
        return "redirect:/office";
    }

    @GetMapping("/edit/{id}")
    public String showEditOfficeForm(Model model, @PathVariable Long id) {
        model.addAttribute("office", officeService.getOffice(id));
        model.addAttribute("addresses", addressService.getAddresses());
        return "/office/edit-office";
    }

    @PostMapping("/update/{id}")
    public String updateOffice(Model model, @PathVariable Long id, Office office) {
        officeService.update(office, id);
        return "redirect:/office";
    }

    @GetMapping("/delete/{id}")
    public String deleteOffice(@PathVariable int id) {
        officeService.delete(id);
        return "redirect:/office";
    }
}