package com.example.demo.dto;


public class ProductDTO {

    private int id;
    private String name;
    private double weight;
    private double price;
    private String description;
    private String imageName;
    private int categoryId;


    public ProductDTO() {
    }

    public ProductDTO(int id, String name, double weight, double price, String description, String imageName, int categoryId) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.description = description;
        this.imageName = imageName;
        this.categoryId = categoryId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
