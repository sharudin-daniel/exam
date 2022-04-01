package com.example.exam.controller;

import com.example.exam.model.Role;
import com.example.exam.service.MyLogService;
import com.example.exam.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RolesController {
    private final RoleService roleService;
    private final MyLogService myLogService;

    @GetMapping("/{id}")
    private Role getById(@PathVariable Long id) {
        Role role = roleService.getById(id);
        myLogService.insert("GET method for http://localhost:8070/roles/" + id +
                " --- Returned "+ role.toString());
        return  role;
    }

    @GetMapping("")
    private List<Role> getAll() {
        myLogService.insert("GET method for http://localhost:8070/roles");
        return  roleService.getAll();
    }

    @DeleteMapping("/{id}")
    private void deleteById(@PathVariable Long id) {
        myLogService.insert("Start of DELETE method for http://localhost:8070/roles/"+id);
        roleService.deleteById(id);
    }

    @DeleteMapping("")
    private void deleteAll() {
        myLogService.insert("Start of DELETE method for http://localhost:8070/roles");
        roleService.deleteAll();
    }

    @PutMapping("/{id}")
    private void update(@PathVariable("id") Long id, @RequestBody Role role) {
        myLogService.insert("Start of PUT method for http://localhost:8070/roles/"+id);
        roleService.update(id, role);
    }

    @PostMapping("")
    private void create( @RequestBody Role role) {
        myLogService.insert("Start of POST method for http://localhost:8070/roles");

        roleService.insert(role);
    }

}
