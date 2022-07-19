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
    public String statusView(Model model){
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
    public String showEditStatusForm(Model model, @PathVariable long id) {
        model.addAttribute("productStatus", statusService.getStatus(id));
        return "/status/edit-status";
    }

    @PostMapping("/update/{id}")
    public String updateStatusForm(@PathVariable long id, ProductStatus productStatus) {
        statusService.update(productStatus, id);
        return "redirect:/status";
    }

    @GetMapping("/delete/{id}")
    public String deleteStatus(@PathVariable long id) {
        statusService.delete(id);

        return "redirect:/status";
    }


}
