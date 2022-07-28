package com.bosch.logistics.controller.view;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String getIndex(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        var username = authentication.getDetails();
        model.addAttribute("username", username);


        final String welcomeMessage = "WELCOME TO THE LOGISTICS COMPANY!";
        model.addAttribute("welcome", welcomeMessage);
        return "index";
    }

    @GetMapping("login")
    public String login(Model model) {
        final String welcomeMessage = "WELCOME TO THE LOGISTICS COMPANY!";
        model.addAttribute("welcome", welcomeMessage);
        return "login";
    }

    @GetMapping("unauthorized")
    public String unauthorized(Model model) {
        final String welcomeMessage = "WELCOME TO THE LOGISTICS COMPANY!";
        model.addAttribute("welcome", welcomeMessage);
        return "unauthorized";
    }

}