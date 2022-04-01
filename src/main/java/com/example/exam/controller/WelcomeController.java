package com.example.exam.controller;

import com.example.exam.service.MyLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@RequiredArgsConstructor

public class WelcomeController {
    private final MyLogService myLogService;

    @GetMapping("")
    private String  getById() {
        myLogService.insert("GET method for http://localhost:8070");
        return  "Welcome";
    }
}
