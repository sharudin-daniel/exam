package com.example.exam.service;

import com.example.exam.mapper.GoodGroupMapper;
import com.example.exam.mapper.GoodMapper;
import com.example.exam.mapper.SalesMapper;
import com.example.exam.model.Good;
import com.example.exam.model.GoodGroup;
import com.example.exam.model.Sales;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class SalesService {

    private final GoodMapper goodMapper;
    private final SalesMapper salesMapper;
    private final GoodGroupMapper goodGroupMapper;

    public Sales getById(Long id) {
        Sales sales = salesMapper.findById(id);
        Good good = goodMapper.findByIdOfSales(id);
        good.setGoodGroup(goodGroupMapper.findByIdOfGood(good.getId()));
        sales.setGood(good);
        return sales;
    }

    public List<Sales> getAll( ) {
        List<Sales> salesList = salesMapper.findAll();
        salesList.forEach(sales -> {
            Good good = goodMapper.findByIdOfSales(sales.getId());
            good.setGoodGroup(goodGroupMapper.findByIdOfGood(good.getId()));
            sales.setGood(good);
        });
        return salesList;
    }

    public void buy(Long id, Long amount) {
        Good good = goodMapper.findById(id);
        good.setAmount(good.getAmount()-amount);
        goodMapper.updateAmount(good);

        Sales sales = new Sales();
        sales.setSaleDate(LocalDate.parse(LocalDate.now()
                .format(DateTimeFormatter.ofPattern( "uuuu-MM-dd" , Locale.UK ))));
        sales.setGood(good);
        sales.setAmountSold(amount);
        sales.setTotalSum(amount*good.getPrice());
        sales.setPriceForOne(good.getPrice());
        salesMapper.insert(sales);
    }
}
