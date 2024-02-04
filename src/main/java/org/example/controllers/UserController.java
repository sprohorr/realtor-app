package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/mainpage")
    private String showMainPage() {
        return "/mainpage";
    }

    @GetMapping("/adminpage")
    public String showAdminPage() {
        return "/adminpage";
    }
}
