package com.example.exam.controller;

import com.example.exam.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class WelcomeController {
    @GetMapping("")
    private String  getById() {
        return  "Welcome";
    }
}
