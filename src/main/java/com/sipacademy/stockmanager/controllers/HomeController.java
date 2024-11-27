package com.sipacademy.stockmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sipacademy.stockmanager.services.UserService;
import com.sipacademy.stockmanager.entities.User;


@Controller
public class HomeController {
	@Autowired
    private UserService userService;

    @GetMapping("/homeSuperAdmin")
    public String  home(Model model) {
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	System.out.println("User authenticated : "+auth.getName());
        User user = userService.findUserByEmail(auth.getName());

        model.addAttribute("userName","Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        return "dashboard/superAdmin/home";


    }
}
