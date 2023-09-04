package com.example.springbootjpa.controller;

import com.example.springbootjpa.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootjpa.model.Product;
import com.example.springbootjpa.service.ProductService;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Product product) {
        productService.createProduct(product);
        return ResponseHandler.generateResponse("product is created successfully",
                HttpStatus.CREATED, product);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Product product) {
        productService.updateProduct(product);
        return ResponseHandler.generateResponse("product is updated", HttpStatus.OK, product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseHandler.generateResponse("product is removed", HttpStatus.OK, id);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllProducts() {
        return ResponseHandler.generateResponse("product is removed",
                HttpStatus.OK, productService.getAllProducts());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Integer id) {
        return ResponseHandler.generateResponse("product is removed",
                HttpStatus.OK, productService.findProductById(id));
    }
}
