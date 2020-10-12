package com.example.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/showCustomLoginForm")
    private String showCustomLoginForm(){
        return "customLoginForm";
    }

    @GetMapping("/showFancyLoginForm")
    private String showFancyLoginForm(){
        return "fancyLoginForm";
    }

}
