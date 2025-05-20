package com.aayushxrj.employees.controller;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class EmployeeController {

    @GetMapping()
    public String firstAPI(){
        return "Testing the REST API!";
    }
}
