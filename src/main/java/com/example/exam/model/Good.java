package com.example.exam.model;

import lombok.Data;

@Data
public class Good {
    private Long id;

    private String name;

    private Long price;

    private Long amount;

    private GoodGroup goodGroup;

    private Boolean enabled;

}
