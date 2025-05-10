package edu.icet.spring_auth.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PublicController {

    @RequestMapping()
    public String sayHello(){
        return "Hello";
    }
}
