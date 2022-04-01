package com.example.exam.controller;

import com.example.exam.model.Good;
import com.example.exam.model.GoodGroup;
import com.example.exam.service.GoodGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/goodGroup")
@RequiredArgsConstructor
public class GoodGroupController {
    private final GoodGroupService goodGroupService;

    @GetMapping("/{id}")
    private GoodGroup getById(@PathVariable Long id) {
        GoodGroup goodGroup = goodGroupService.getById(id);
        log.info("GET method for http://localhost:8070/goodGroup/" + id +
                " --- Returned "+ goodGroup.toString());
        return  goodGroup;
    }

    @GetMapping("")
    private List<GoodGroup> getAll() {
        log.info("Start of GET method for http://localhost:8070/goodGroup/");
        return  goodGroupService.getAll();
    }

    @PutMapping("/{id}")
    private void update(@PathVariable("id") Long id, @RequestBody GoodGroup goodGroup) {
        log.info("Start of PUT method for http://localhost:8070/goodGroup/"+id);
        goodGroupService.update(id, goodGroup);
    }

    @PostMapping("")
    private void create( @RequestBody GoodGroup goodGroup) {
        log.info("Start of POST method for http://localhost:8070/goodGroup/");
        goodGroupService.insert(goodGroup);
    }

}
