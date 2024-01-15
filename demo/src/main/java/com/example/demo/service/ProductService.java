package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    public ProductRepository productRepository;
    public List<Product> getAllProduct(){
        return this.productRepository.findAll();
    }

    public void addProduct(Product product) {
        this.productRepository.save(product);
    }

    public void deleteById(int id) {
        this.productRepository.deleteById(id);
    }

    public Optional<Product> getProductById(int id){
        return this.productRepository.findById(id);
    }

    public List<Product> getAllProductByCategoryId(int id){
        return productRepository.findAllByCategory_Id(id);
    }
}
