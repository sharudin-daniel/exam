package com.example.exam.controller;

import com.example.exam.model.Test;
import com.example.exam.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping("/{id}")
    private Test getById(@PathVariable Long id) {
        return  testService.getById(id);
    }

    @GetMapping("")
    private List<Test> getAll() {
        return  testService.getAll();
    }

    @DeleteMapping("/{id}")
    private void deleteById(@PathVariable Long id) {
        testService.deleteById(id);
    }

    @DeleteMapping("")
    private void deleteAll() {
        testService.deleteAll();
    }

    @PutMapping("/{id}")
    private void update(@PathVariable("id") Long id, @RequestBody Test test) {
        testService.update(id, test);
    }

    @PostMapping("")
    private void create( @RequestBody Test test) {
        testService.insert(test);
    }

}
