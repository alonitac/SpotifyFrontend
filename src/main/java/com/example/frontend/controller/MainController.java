package com.example.frontend.controller;

import com.example.frontend.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class MainController {
    @Autowired
    private CatalogService catalogService;

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/library")
    public String library(Model model) {
        return "library";
    }

    @GetMapping("/radio")
    public String radio(Model model) {
        return "radio";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String loginWithUsernameAndPassword(@RequestParam("email") String email, @RequestParam("password") String password,  RedirectAttributes redirectAttributes) {
         if ("user@example.com".equals(email) && "password123".equals(password)) {
             redirectAttributes.addFlashAttribute("toastMessage", email);
             return "redirect:/";
         } else {
             redirectAttributes.addFlashAttribute("error", "Invalid email or password.");
             return "redirect:/login";
         }
    }

}
