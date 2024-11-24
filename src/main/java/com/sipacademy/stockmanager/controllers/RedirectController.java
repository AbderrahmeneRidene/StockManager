package com.sipacademy.stockmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/")
    public String redirectToHome() {
        return "dashboard/superAdmin/home";
    }
}
