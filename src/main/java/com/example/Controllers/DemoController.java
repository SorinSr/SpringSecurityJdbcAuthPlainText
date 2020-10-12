package com.example.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/homePage")
    public String showHome(){
        return "officialHomePage";
    }

    @GetMapping("/")
    public String showLoadingPage(){
        return "loadingPage";
    }
}
