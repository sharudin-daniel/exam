package com.example.exam.controller;

import com.example.exam.mapper.MyLogMapper;
import com.example.exam.model.Good;
import com.example.exam.service.GoodService;
import com.example.exam.service.MyLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/good")
@RequiredArgsConstructor
public class GoodController {
    private final GoodService goodService;
    private final MyLogService myLogService;

    @GetMapping("/{id}")
    private Good getById(@PathVariable Long id) {
        Good good = goodService.getById(id);
        myLogService.insert("GET method for http://localhost:8070/good/" + id +
                " --- Returned "+ good.toString());
        return  good;
    }

    @GetMapping("")
    public List<Good> getAll() {
        myLogService.insert("Start of GET method for http://localhost:8070/good");
        return  goodService.getAll();
    }

    @DeleteMapping("/{id}")
    private void desableById(@PathVariable Long id) {
        myLogService.insert("Start of DELETE method for http://localhost:8070/good/"+id);
        goodService.desableById(id);
    }

    @DeleteMapping("")
    private void desableAll() {
        myLogService.insert("Start of DELETE method for http://localhost:8070/good");
        goodService.desableAll();
    }

    @PutMapping("/{id}")
    private void update(@PathVariable("id") Long id, @RequestBody Good good) {
        myLogService.insert("Start of PUT method for http://localhost:8070/good/"+id);
        goodService.update(id, good);
    }

    @PutMapping("/add")
    private void add(@RequestParam Long id, @RequestParam  Long amount) {
        myLogService.insert("Start of PUT method for http://localhost:8070/good/add?id="+id+"&amount="+amount);
        goodService.add(id, amount);
    }

    @PostMapping("")
    private void create( @RequestBody Good good) {
        myLogService.insert("Start of POST method for http://localhost:8070/good");
        goodService.insert(good);
    }

}
