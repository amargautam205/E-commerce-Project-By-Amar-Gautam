package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private int id;

    private  String name;

}
