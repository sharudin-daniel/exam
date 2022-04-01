package com.example.exam.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Sales {

    private Long id;

    private Good good;

    private Long amountSold;

    private Long priceForOne;

    private Long totalSum;

    private LocalDate saleDate;

}
