package com.pluralsight.SakilaSpring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "this is magic";
    }

    @GetMapping("/poop")
    public String poop(){
        return "this is poop";
    }

}
