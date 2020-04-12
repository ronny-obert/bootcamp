package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipment {
    private int id;
    private String category;
    private String brand;
    private String name;
    private Integer stock;
    private String model;
    private Double price;
}