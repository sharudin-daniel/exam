package com.example.exam.controller;

import com.example.exam.model.Good;
import com.example.exam.model.User;
import com.example.exam.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    private User getById(@PathVariable Long id) {
        User user = userService.getById(id);
        log.info("GET method for http://localhost:8070/admin/" + id +
                " --- Returned "+ user.toString());
        return  user;
    }

    @GetMapping("")
    private List<User> getAll() {
        log.info("GET method for http://localhost:8070/admin");
        return  userService.getAll();
    }

    @DeleteMapping("/{id}")
    private void deleteById(@PathVariable Long id) {
        log.info("Start of DELETE method for http://localhost:8070/admin/"+id);
        userService.deleteById(id);
    }

    @DeleteMapping("")
    private void deleteAll() {
        log.info("Start of DELETE method for http://localhost:8070/admin");
        userService.deleteAll();
    }

    @PutMapping("/{id}")
    private void update(@PathVariable("id") Long id, @RequestBody User user) {
        log.info("Start of PUT method for http://localhost:8070/admin/"+id);
        userService.update(id, user);
    }

    @PostMapping("")
    private void create( @RequestBody User user) {
        log.info("Start of POST method for http://localhost:8070/admin");
        userService.insert(user);
    }

}
