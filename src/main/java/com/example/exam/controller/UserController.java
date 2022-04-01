package com.example.exam.controller;

import com.example.exam.model.Good;
import com.example.exam.model.User;
import com.example.exam.service.MyLogService;
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
    private final MyLogService myLogService;

    @GetMapping("/{id}")
    private User getById(@PathVariable Long id) {
        User user = userService.getById(id);
        myLogService.insert("GET method for http://localhost:8070/users/" + id +
                " --- Returned "+ user.toString());
        return  user;
    }

    @GetMapping("")
    private List<User> getAll() {
        myLogService.insert("GET method for http://localhost:8070/users");
        return  userService.getAll();
    }

    @DeleteMapping("/{id}")
    private void deleteById(@PathVariable Long id) {
        myLogService.insert("Start of DELETE method for http://localhost:8070/users/"+id);
        userService.deleteById(id);
    }

    @DeleteMapping("")
    private void deleteAll() {
        myLogService.insert("Start of DELETE method for http://localhost:8070/users");
        userService.deleteAll();
    }

    @PutMapping("/{id}")
    private void update(@PathVariable("id") Long id, @RequestBody User user) {
        myLogService.insert("Start of PUT method for http://localhost:8070/users/"+id);
        userService.update(id, user);
    }

    @PostMapping("")
    private void create( @RequestBody User user) {
        myLogService.insert("Start of POST method for http://localhost:8070/users");

        userService.insert(user);
    }

}
