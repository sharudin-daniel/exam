package com.example.exam.controller;

import com.example.exam.model.Sales;
import com.example.exam.service.MyLogService;
import com.example.exam.service.SalesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SalesController {
    private final SalesService salesService;
    private final MyLogService myLogService;

    @GetMapping("/{id}")
    private Sales getById(@PathVariable Long id) {
        Sales sales = salesService.getById(id);
        myLogService.insert("GET method for http://localhost:8070/sales/" + id +
        " --- Returned "+ sales.toString());

        return  sales;
    }

    @GetMapping("")
    private List<Sales> getAll() {
        myLogService.insert("Start of GET method for http://localhost:8070/sales");
        return  salesService.getAll();
    }

    @PostMapping("/buy")
    private void buy(@RequestParam Long id, @RequestParam  Long amount) {
        myLogService.insert("Start of POST method for http://localhost:8070/sales/buy&id="+id+"&amount="+amount);
        salesService.buy(id, amount);
    }

}
