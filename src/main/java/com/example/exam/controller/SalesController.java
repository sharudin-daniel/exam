package com.example.exam.controller;

import com.example.exam.model.Sales;
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

    @GetMapping("/{id}")
    private Sales getById(@PathVariable Long id) {
        Sales sales = salesService.getById(id);
        log.info("GET method for http://localhost:8070/sales/" + id +
                " --- Returned "+ sales.toString());
        return  sales;
    }

    @GetMapping("")
    private List<Sales> getAll() {
        log.info("Start of GET method for http://localhost:8070/sales");
        return  salesService.getAll();
    }

    @PostMapping("/buy")
    private void buy(@RequestParam Long id, @RequestParam  Long amount) {
        log.info("Start of POST method for http://localhost:8070/sales/buy&id="+id+"&amount="+amount);
        salesService.buy(id, amount);
    }

}
