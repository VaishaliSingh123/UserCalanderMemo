package com.example.userCalanderShedule.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/hi")
public class HelloController {

    @GetMapping("/demo")
    public String helloApi(){
        return "Demo Api Worked";
    }
}
