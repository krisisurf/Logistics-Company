package com.bosch.logistics.controller.view;

import com.bosch.logistics.entity.ProductStatus;
import com.bosch.logistics.service.StatusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/status")
public class StatusViewController {

    private StatusService statusService;

    public StatusViewController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    public String statusView(Model model) {
        model.addAttribute("statuses", statusService.getStatuses());
        return "/status/status";
    }

    @GetMapping("/create-status")
    public String showCreateStatusForm(Model model) {
        model.addAttribute("productStatus", new ProductStatus());
        return "/status/create-status";
    }

    @PostMapping("/create")
    public String createStatus(@ModelAttribute ProductStatus status) {
        statusService.create(status);
        return "redirect:/status";
    }

    @GetMapping("/edit/{id}")
    public String showEditStatus(Model model, @PathVariable long id) {
        model.addAttribute("status", statusService.getStatus(id));
        return "/status/edit-status";
    }

    @PostMapping("/update/{id}")
    public String updateStatus(Model model, @PathVariable long id, ProductStatus status) {
        statusService.update(status, id);
        return "redirect:/status";
    }

    @GetMapping("/delete/{id}")
    public String deleteStatus(@PathVariable int id) {
        statusService.delete(id);
        return "redirect:/status";
    }
}
