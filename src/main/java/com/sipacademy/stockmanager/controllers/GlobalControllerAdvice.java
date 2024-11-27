package com.sipacademy.stockmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sipacademy.stockmanager.entities.User;
import com.sipacademy.stockmanager.services.UserService;



@ControllerAdvice
public class GlobalControllerAdvice {
	@Autowired
    private UserService userService;

    @ModelAttribute
    public void addUserToModel(@AuthenticationPrincipal UserDetails userDetails, Model model) {
    	
        
        if (userDetails != null) {
        	User user = userService.findUserByEmail(userDetails.getUsername());
            model.addAttribute("username", capitalizeFirstLetter(user.getName()));
            model.addAttribute("userPicture", capitalizeFirstLetter(user.getPicture()));
        }
    }
    
    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        // Mettre la première lettre en majuscule et le reste en minuscule
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}
