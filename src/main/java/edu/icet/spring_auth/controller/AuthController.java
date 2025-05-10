package edu.icet.spring_auth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure")
public class AuthController {


    @GetMapping("/customer")
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','CUSTOMER')")
    public String sayHelloForCustomer(){

        return "hello customer";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String sayHelloForAdmin(){

        return "hello Admin";
    }

    @GetMapping("/manager")
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    public String sayHelloForManager(){
        return "hello Manager";
    }

    @GetMapping("/employee")
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','EMPLOYEE','SUPERVISOR')")
    public String sayHelloForEmployee(){
        return "hello Employee";
    }

    @GetMapping("/supervisor")
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','SUPERVISOR')")
    public String sayHelloForSupervisor(){
        return "hello Supervisor";
    }



}
