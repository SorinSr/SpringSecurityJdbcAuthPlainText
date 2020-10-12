package com.example.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RolesController {

    @GetMapping("/leaders")
    public String showLeadersPage(){
        return "leader_page";
    }

    @GetMapping("/systems")
    public String showAdminsPage(){
        return "admin_page";
    }

    @GetMapping("/employees")
    public String showEmployeesPage(){
        return "employee_page";
    }

    @GetMapping("/customAccessDenied")
    public String showAccessDeniesPage(){
        return "custom_access_denied_page";

    }
}
