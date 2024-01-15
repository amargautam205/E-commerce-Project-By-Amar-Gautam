package com.example.demo.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private int id;
    private String name;
    private double weight;
    private double price;
    private String description;
    private String imageName;
    private int categoryId;
}
