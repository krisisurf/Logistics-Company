package com.bosch.logistics.controller.view;

import com.bosch.logistics.service.StatusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
